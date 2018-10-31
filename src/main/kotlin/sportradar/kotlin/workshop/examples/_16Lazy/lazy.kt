package sportradar.kotlin.workshop.examples._16Lazy

fun main(args: Array<String>) {
  val lazyValue:String by lazy {
    println("Computing!")
    "Hello"
  }
  println(lazyValue)
  println(lazyValue)
}