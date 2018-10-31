package sportradar.kotlin.workshop.examples._17Coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.NonCancellable.isActive

fun main(args: Array<String>) = runBlocking{
  // https://kotlinlang.org/docs/reference/coroutines/cancellation-and-timeouts.html

//  cancel()
//  cancelContinues()
//  cancelable()
//  finallyClosing()
//  nonCacellable()
//  timeouted() //Throw TimeoutCancellationException
  timeoutNull()
}

suspend fun timeoutNull() {
  val result = withTimeoutOrNull(1300L) {
    repeat(1000) { i ->
      println("I'm sleeping $i ...")
      delay(500L)
    }
    "Done" // will get cancelled before it produces this result
  }
  println("Result is $result")
}

suspend fun timeouted() {
  withTimeout(1300L) {
    repeat(1000) { i ->
      println("I'm sleeping $i ...")
      delay(500L)
    }
  }
}

suspend fun nonCacellable() {
  val job = GlobalScope.launch {
    try {
      repeat(1000) { i ->
        println("I'm sleeping $i ...")
        delay(500L)
      }
    } finally {
      withContext(NonCancellable) {
        println("I'm running finally")
        delay(1000L)
        println("And I've just delayed for 1 sec because I'm non-cancellable")
      }
    }
  }
  delay(1300L) // delay a bit
  println("main: I'm tired of waiting!")
  job.cancelAndJoin() // cancels the job and waits for its completion
  println("main: Now I can quit.")
}

suspend fun finallyClosing() {
  val job = GlobalScope.launch {
    try {
      repeat(1000) { i ->
        println("I'm sleeping $i ...")
        delay(500L)
      }
    } finally {
      println("I'm running finally")
    }
  }
  delay(1300L) // delay a bit
  println("main: I'm tired of waiting!")
  job.cancelAndJoin() // cancels the job and waits for its completion
  println("main: Now I can quit.")
}

suspend fun cancelable() {
  val startTime = System.currentTimeMillis()
  val job = GlobalScope.launch(Dispatchers.Default) {
    var nextPrintTime = startTime
    var i = 0
    while (isActive) { // cancellable computation loop
      // print a message twice a second
      if (System.currentTimeMillis() >= nextPrintTime) {
        println("I'm sleeping ${i++} ...")
        nextPrintTime += 500L
      }
    }
  }
  delay(1300L) // delay a bit
  println("main: I'm tired of waiting!")
  job.cancelAndJoin() // cancels the job and waits for its completion
  println("main: Now I can quit.")
}

private suspend fun cancel() {
  val job = GlobalScope.launch {
    repeat(1000) { i ->
      println("I'm sleeping $i ...")
      delay(500L)
    }
  }
  delay(1300L) // delay a bit
  println("main: I'm tired of waiting!")
  job.cancel() // cancels the job
  job.join() // waits for job's completion
  println("main: Now I can quit.")
}

suspend fun cancelContinues() = runBlocking {
  val startTime = System.currentTimeMillis()
  val job = launch(Dispatchers.Default) {
    var nextPrintTime = startTime
    var i = 0
    while (i < 5) { // computation loop, just wastes CPU
      // print a message twice a second
      if (System.currentTimeMillis() >= nextPrintTime) {
        println("I'm sleeping ${i++} ...")
        nextPrintTime += 500L
      }
    }
  }
  delay(1300L) // delay a bit
  println("main: I'm tired of waiting!")
  job.cancelAndJoin() // cancels the job and waits for its completion
  println("main: Now I can quit.")
}