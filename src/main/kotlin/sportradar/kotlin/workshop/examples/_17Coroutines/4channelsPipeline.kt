package sportradar.kotlin.workshop.examples._17Coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.coroutineContext

fun main(args: Array<String>) {
  pipeline()
  primePipeline()
}
fun primePipeline() = runBlocking {
  //sampleStart
  var cur = numbersFrom(2)
  for (i in 1..10) {
    val prime = cur.receive()
    println(prime)
    cur = filter(cur, prime)
  }
  coroutineContext.cancelChildren() // cancel all children to let main finish
//sampleEnd
}

fun CoroutineScope.numbersFrom(start: Int) = produce<Int> {
  var x = start
  while (true) send(x++) // infinite stream of integers from start
}

fun CoroutineScope.filter(numbers: ReceiveChannel<Int>, prime: Int) = produce<Int> {
  for (x in numbers) if (x % prime != 0) send(x)
}

fun pipeline() = runBlocking {
  val numbers = produceNumbers() // produces integers from 1 and on
  val squares = square(numbers) // squares integers
  for (i in 1..5) println(squares.receive()) // print first five
  println("Done!") // we are done
  coroutineContext.cancelChildren() // cancel children coroutines
}

private fun CoroutineScope.produceNumbers() = produce<Int> {
  var x = 1
  while (true) send(x++) // infinite stream of integers starting from 1
}
fun CoroutineScope.square(numbers: ReceiveChannel<Int>): ReceiveChannel<Int> = produce {
  for (x in numbers) send(x * x)
}