package sportradar.kotlin.workshop.examples._13CollectionSequence

fun main(args: Array<String>) {
  // All extentions on collections (list, set, map) are
  // Eager and Inline
  // Don't chain collection extension functions, use sequence
  val list = listOf(1, 2, 3, 4, 5, 6, 7)
  list.map { it * 2 }.filter { it % 2 == 2 }.asReversed().dropLastWhile { it > 12 }

  // Sequences are Lazy, list Java Streams
  list.asSequence()
    .map { it * 2 }
    .filter { it % 2 == 0 }
    .dropWhile { it > 12 }
    .toList() //terminal operation as Java Streams collect()
//    .toMutableList()
//    .toSortedSet()
}