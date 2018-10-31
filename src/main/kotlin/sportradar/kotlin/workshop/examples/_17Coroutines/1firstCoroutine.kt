package sportradar.kotlin.workshop.examples._17Coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
  GlobalScope.launch {
    // launch new coroutine in background and continue
    delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
    println("World!") // print after delay
  }
  println("Hello,") // main thread continues while coroutine is delayed
  Thread.sleep(2000L) // block main thread for 2 seconds to keep JVM alive


  GlobalScope.launch { // launch new coroutine in background and continue
        delay(1000L)
        println("World!")
    }
    println("Hello,") // main thread continues here immediately
    runBlocking {     // but this expression blocks the main thread
        delay(2000L)  // ... while we delay for 2 seconds to keep JVM alive
    }
}
