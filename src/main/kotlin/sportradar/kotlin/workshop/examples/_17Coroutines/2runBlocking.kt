package sportradar.kotlin.workshop.examples._17Coroutines

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  // start main coroutine
  GlobalScope.launch {
    // launch new coroutine in background and continue
    delay(1000L)
    println("World!")
  }
  println("Hello,") // main coroutine continues here immediately
  delay(2000L)      // delaying for 2 seconds to keep JVM alive

  val job = GlobalScope.launch {
    // launch new coroutine and keep a reference to its Job
    delay(1000L)
    println("World!")
  }
  println("Hello,")
  job.join() // wait until child coroutine completes

  scopeBuilder()
  extractRefactor()
  lightweight()
  daemon()
}

suspend fun scopeBuilder() = runBlocking { // this: CoroutineScope
  launch {
    delay(200L)
    println("Task from runBlocking")
  }

  coroutineScope { // Creates a new coroutine scope
    launch {
      delay(500L)
      println("Task from nested launch")
    }

    delay(100L)
    println("Task from coroutine scope") // This line will be printed before nested launch
  }

  println("Coroutine scope is over") // This line is not printed until nested launch completes
}
suspend fun extractRefactor()=runBlocking {
  launch { doWorld() }
  println("Hello,")
}

// this is your first suspending function
suspend fun doWorld() {
  delay(1000L)
  println("World!")
}

suspend fun lightweight() =runBlocking {
  repeat(100_000) { // launch a lot of coroutines
    launch {
      delay(1000L)
      print(".")
    }
  }
}

suspend fun daemon() {
  GlobalScope.launch {
    repeat(1000) { i ->
      println("I'm sleeping $i ...")
      delay(500L)
    }
  }
  delay(1300L) // just quit after delay
}