package sportradar.kotlin.workshop.examples._9Functions

fun main(args: Array<String>) {
  val anys: List<Any> = listOf(1, "one", 2.0)

  // No explicite type, type is needed on the right
  val strings = anys.filterIsInstance2<String>() // ["one"]
  // Explicite type. type NOT needed on the right
  val strings2: List<String> = anys.filterIsInstance2() // ["one"]


}

inline fun <reified T> List<*>.filterIsInstance2(): List<T> {
  val destination = mutableListOf<T>()
  for (element in this) {
    if (element is T) {
      destination.add(element)
    }
  }
  return destination
}