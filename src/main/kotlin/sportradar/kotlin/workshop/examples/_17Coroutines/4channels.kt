package sportradar.kotlin.workshop.examples._17Coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
//  basics()
//  closingChannels()
  buildingProducers()
}

private fun CoroutineScope.produceSquares(): ReceiveChannel<Int> = produce {
  for (x in 1..5) send(x * x)
}

fun buildingProducers() = runBlocking {
  //sampleStart
  val squares = produceSquares()
  squares.consumeEach { println(it) }
  println("Done!")
//sampleEnd
}

fun closingChannels() = runBlocking {
  //sampleStart
  val channel = Channel<Int>()
  launch {
    for (x in 1..5) channel.send(x * x)
    channel.close() // we're done sending
  }
  // here we print received values using `for` loop (until the channel is closed)
  for (y in channel) println(y)
  println("Done!")
//sampleEnd
}


fun basics() = runBlocking {
  val channel = Channel<Int>()
  launch {
    // this might be heavy CPU-consuming computation or async logic, we'll just send five squares
    for (x in 1..5) channel.send(x * x)
  }
  // here we print five received integers:
  repeat(5) { println(channel.receive()) }
  println("Done!")
}