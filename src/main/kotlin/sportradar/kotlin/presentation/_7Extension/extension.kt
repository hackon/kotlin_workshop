package sportradar.kotlin.presentation._7Extension

fun main(args: Array<String>) {
  println("This should all be title case.".toTitleCase())

  println("The same".isTheSameAs("The same"))
  println("The same infix" isTheSameAs "The same infix")

}
infix fun String.isTheSameAs(value: String) = this == value

fun String.toTitleCase(): String {
  return this.split(" ").joinToString(" ") { it.capitalize() }
}