package sportradar.kotlin.workshop.examples._17Coroutines

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking{
  sequentialByDefault()
  async()
  lazyAsync()
  structuredConcurencyAsync()
  cancelPropagation()
}

suspend fun cancelPropagation() = runBlocking<Unit> {
  try {
    failedConcurrentSum()
  } catch(e: ArithmeticException) {
    println("Computation failed with ArithmeticException")
  }
}

suspend fun failedConcurrentSum(): Int = coroutineScope {
  val one = async<Int> {
    try {
      delay(Long.MAX_VALUE) // Emulates very long computation
      42
    } finally {
      println("First child was cancelled")
    }
  }
  val two = async<Int> {
    println("Second child throws an exception")
    throw ArithmeticException()
  }
  one.await() + two.await()
}

suspend fun structuredConcurencyAsync() = runBlocking<Unit> {
  //sampleStart
  val time = measureTimeMillis {
    println("The answer is ${concurrentSum()}")
  }
  println("Completed in $time ms")
//sampleEnd
}

suspend fun concurrentSum(): Int = coroutineScope {
  val one = async { doSomethingUsefulOne() }
  val two = async { doSomethingUsefulTwo() }
  one.await() + two.await()
}


suspend fun sequentialByDefault() = runBlocking<Unit> {
    val time = measureTimeMillis {
      val one = doSomethingUsefulOne()
      val two = doSomethingUsefulTwo()
      println("The answer is ${one + two}")
    }
    println("Completed in $time ms")
  }

suspend fun async()= runBlocking<Unit> {

  val time = measureTimeMillis {
    val one = async { doSomethingUsefulOne() }
    val two = async { doSomethingUsefulTwo() }
    println("The answer is ${one.await() + two.await()}")
  }
  println("Completed in $time ms")

}

suspend fun lazyAsync() = runBlocking<Unit> {
  //sampleStart
  val time = measureTimeMillis {
    val one = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne() }
    val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulTwo() }
    // some computation
    one.start() // start the first one
    two.start() // start the second one
    println("The answer is ${one.await() + two.await()}")
  }
  println("Completed in $time ms")
//sampleEnd
}

suspend fun doSomethingUsefulOne(): Int {
  delay(1000L) // pretend we are doing something useful here
  return 13
}

suspend fun doSomethingUsefulTwo(): Int {
  delay(1000L) // pretend we are doing something useful here, too
  return 29
}