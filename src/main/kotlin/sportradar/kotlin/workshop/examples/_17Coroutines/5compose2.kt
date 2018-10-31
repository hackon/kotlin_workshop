package sportradar.kotlin.workshop.examples._17Coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
  val time = measureTimeMillis {
    // we can initiate async actions outside of a coroutine
    val one = somethingUsefulOneAsync()
    val two = somethingUsefulTwoAsync()
    // but waiting for a result must involve either suspending or blocking.
    // here we use `runBlocking { ... }` to block the main thread while waiting for the result
    runBlocking {
      println("The answer is ${one.await() + two.await()}")
    }
  }
  println("Completed in $time ms")
}
//sampleEnd

fun somethingUsefulOneAsync() = GlobalScope.async {
  doSomethingUsefulOne()
}

fun somethingUsefulTwoAsync() = GlobalScope.async {
  doSomethingUsefulTwo()
}
