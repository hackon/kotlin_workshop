package sportradar.kotlin.workshop.examples._9Functions

import java.util.concurrent.locks.Lock

fun main(args: Array<String>) {
  // INLINE
  // compiler substitutes a body of the function instead of calling it
  // No anonymous class for lambda, no performance overhead

  // inline kotlin lib functions
  // run a block of code, returning last expression
  val foo = run {
    println("Calculating foo")
    "foo"
  }

  // lets you check for f.ex non-null
  fun getEmail():String? {return null}
  fun sendEmailTo(email: String) { TODO("not implemented") }
  val email = getEmail()
  if (email != null) sendEmailTo(email)
  email?.let { e-> sendEmailTo(e) }
  getEmail()?.let { sendEmailTo(it) }

  // take if it satisfies the given predicate
  val number = 42
  val takeIf: Int? = number.takeIf { it > 10 } // 42

  val other = 2
  val otherTake: Int? = other.takeIf { n -> n > 10 } // null

  // take unless it satisfies the given predicate
  val number2 = 42
  val takeIf2: Int? = number2.takeUnless { it > 10 } // null

  val other2 = 2
  val otherTake2: Int? = other2.takeUnless { n -> n > 10 } // 2

  // repeat the block
  repeat(10) {
    println("Welcome!")
  }




}

fun foo(lock: Lock) {
  sync(lock) {
    println("action")
  }
}

// generated code in the byte code
//fun foo(lock: Lock) {
//  lock.lock()
//  try {
//    println("action")
//  }finally {
//    lock.unlock()
//  }
//}

inline fun <T> sync(lock: Lock, action: () -> T): T {
  lock.lock()
  try {
    return action()
  }finally {
    lock.unlock()
  }
}
