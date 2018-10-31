package sportradar.kotlin.workshop.examples._12Lambda

fun main(args: Array<String>) {
  val sum = { x:Int, y:Int -> x+y}
  val sum2: (Int, Int) -> Int = { x:Int, y:Int -> x+y}

  val isEven: (Int)->Boolean = {i -> i % 2 == 0 }
  fun isEven(i:Int):Boolean = i%2 == 0
  val list = listOf(1, 2, 3, 4)
  list.any(isEven) // true
  list.filter(isEven) // [2,4]

  list.any(::isEven) // fun member ref
  list.filter(::isEven)
}