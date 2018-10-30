package sportradar.kotlin.presentation._5PatternMatching

fun main(args: Array<String>) {
  val x = 2
  when (x) {
    1 -> print("One")
    2 -> print("Two")
    3 -> print("Three")
    4 -> print("Four")
    else -> print("Something else")
  }
  println()

  when (val y = getAny()) {
    in 1..2 -> println("Is between 1 and 2: $y")
    is Double -> println("Is double ${y.javaClass.typeName}")
    in 3 until 15 -> println("is in range 3 until 15")

  }
}

fun getAny(): Any = 5.0
