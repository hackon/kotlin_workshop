package sportradar.kotlin.workshop.examples._17Coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.channels.produce

fun main(args: Array<String>) {
  fanout()
  fanin()
  buffered()
}

fun buffered() = runBlocking<Unit> {
  val channel = Channel<Int>(4) // create buffered channel
  val sender = launch { // launch sender coroutine
    repeat(10) {
      println("Sending $it") // print before sending each element
      channel.send(it) // will suspend when buffer is full
    }
  }
  // don't receive anything... just wait....
  delay(1000)
  sender.cancel() // cancel sender coroutine
}


fun fanin()= runBlocking {
  //sampleStart
  val channel = Channel<String>()
  launch { sendString(channel, "foo", 200L) }
  launch { sendString(channel, "BAR!", 500L) }
  repeat(6) { // receive first six
    println(channel.receive())
  }
  coroutineContext.cancelChildren() // cancel all children to let main finish
//sampleEnd
}

suspend fun sendString(channel: SendChannel<String>, s: String, time: Long) {
  while (true) {
    delay(time)
    channel.send(s)
  }
}
fun fanout()= runBlocking<Unit> {
  //sampleStart
  val producer = produceNumbers()
  repeat(5) { launchProcessor(it, producer) }
  delay(950)
  producer.cancel() // cancel producer coroutine and thus kill them all
//sampleEnd
}

private fun CoroutineScope.produceNumbers() = produce<Int> {
  var x = 1 // start from 1
  while (true) {
    send(x++) // produce next
    delay(100) // wait 0.1s
  }
}

fun CoroutineScope.launchProcessor(id: Int, channel: ReceiveChannel<Int>) = launch {
  for (msg in channel) {
    println("Processor #$id received $msg")
  }
}