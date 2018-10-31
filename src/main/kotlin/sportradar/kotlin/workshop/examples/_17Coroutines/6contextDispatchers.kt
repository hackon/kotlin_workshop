package sportradar.kotlin.workshop.examples._17Coroutines

import kotlinx.coroutines.*

fun main() {
//  dispatchers()
//  unconfined()
//  logging()
//  jumpingContext()
//  jobInContext()
//  childrenOfCoroutine()
//  parentalGuidance()
//  namingRoutines()
  combiningContext()
}

fun combiningContext() = runBlocking<Unit> {
  launch(Dispatchers.Default + CoroutineName("test")) {
    println("I'm working in thread ${Thread.currentThread().name}")
  }
}

fun namingRoutines() = runBlocking(CoroutineName("main")) {
    log("Started main coroutine")
    // run two background value computations
    val v1 = async(CoroutineName("v1coroutine")) {
        delay(500)
        log("Computing v1")
        252
    }
    val v2 = async(CoroutineName("v2coroutine")) {
        delay(1000)
        log("Computing v2")
        6
    }
    log("The answer for v1 / v2 = ${v1.await() / v2.await()}")
}

fun parentalGuidance() = runBlocking{
  // launch a coroutine to process some kind of incoming request
  val request = launch {
    repeat(3) { i -> // launch a few children jobs
      launch  {
        delay((i + 1) * 200L) // variable delay 200ms, 400ms, 600ms
        println("Coroutine $i is done")
      }
    }
    println("request: I'm done and I don't explicitly join my children that are still active")
  }
  request.join() // wait for completion of the request, including all its children
  println("Now processing of the request is complete")
}

fun childrenOfCoroutine() = runBlocking<Unit> {

  // launch a coroutine to process some kind of incoming request
  val request = launch {
    // it spawns two other jobs, one with GlobalScope
    GlobalScope.launch {
      println("job1: I run in GlobalScope and execute independently!")
      delay(1000)
      println("job1: I am not affected by cancellation of the request")
    }
    // and the other inherits the parent context
    launch {
      delay(100)
      println("job2: I am a child of the request coroutine")
      delay(1000)
      println("job2: I will not execute this line if my parent request is cancelled")
    }
  }
  delay(500)
  request.cancel() // cancel processing of the request
  delay(1000) // delay a second to see what happens
  println("main: Who has survived request cancellation?")
}

fun jobInContext() = runBlocking<Unit> {
  //sampleStart
  println("My job is ${coroutineContext[Job]}")
//sampleEnd
}

fun jumpingContext() {
  newSingleThreadContext("Ctx1").use { ctx1 ->
    newSingleThreadContext("Ctx2").use { ctx2 ->
      runBlocking(ctx1) {
        log("Started in ctx1")
        withContext(ctx2) {
          log("Working in ctx2")
        }
        log("Back to ctx1")
      }
    }
  }
}

fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")

fun logging() = runBlocking<Unit> {
  //sampleStart
  val a = async {
    log("I'm computing a piece of the answer")
    6
  }
  val b = async {
    log("I'm computing another piece of the answer")
    7
  }
  log("The answer is ${a.await() * b.await()}")
//sampleEnd
}

fun unconfined() = runBlocking<Unit> {
  //sampleStart
  launch(Dispatchers.Unconfined) { // not confined -- will work with main thread
    println("Unconfined      : I'm working in thread ${Thread.currentThread().name}")
    delay(500)
    println("Unconfined      : After delay in thread ${Thread.currentThread().name}")
  }
  launch { // context of the parent, main runBlocking coroutine
    println("main runBlocking: I'm working in thread ${Thread.currentThread().name}")
    delay(1000)
    println("main runBlocking: After delay in thread ${Thread.currentThread().name}")
  }
//sampleEnd
}


fun dispatchers() = runBlocking{
  launch {
    // context of the parent, main runBlocking coroutine
    println("main runBlocking      : I'm working in thread ${Thread.currentThread().name}")
  }
  launch(Dispatchers.Unconfined) {
    // not confined -- will work with main thread
    println("Unconfined            : I'm working in thread ${Thread.currentThread().name}")
  }
  launch(Dispatchers.Default) {
    // will get dispatched to DefaultDispatcher
    println("Default               : I'm working in thread ${Thread.currentThread().name}")
  }
  launch(newSingleThreadContext("MyOwnThread")) {
    // will get its own new thread
    println("newSingleThreadContext: I'm working in thread ${Thread.currentThread().name}")
  }
}