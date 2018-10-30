package sportradar.kotlin.presentation._6Coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun main(args: Array<String>) {

  println("Starting here")
    longRunningProcess()
    println("Ending here")
  println("Starting here")
    GlobalScope.launch {
        suspendableProcess()
    }
    println("Ending here")
}
fun longRunningProcess() {
  Thread.sleep(5000)
  println("in process")
}
suspend fun suspendableProcess() {
  Thread.sleep(2000)
  println("in process")
}
