package sportradar.kotlin.workshop.examples._6When

fun main(args: Array<String>) {
    val a :Any= 100
    when (a) {
        in 1..10 -> println("in 1 .. 10")
        in 10..100 -> println(" in 10 .. 100")
    }
    when (a) {
        is Int -> println("int ${a + 100}")
        is String -> println("String ${a} ")
        is IntArray -> println("intArray ${a.sum()}")
    }

    //When as if
    whenever(123)
    whenever("This is a string")
    whenever(intArrayOf(10,10,10))
    whenever(listOf('2','4'))
}

private fun whenever(a: Any) {
    when {
        a is Int && a > 10 -> println("int larger than 10: $a")
        a is String && a.length > 10 -> println("string longer than 10 char: $a")
        a is IntArray && a.sum() < 100 -> println("intarray with sum < 100: ${a.sum()}")
        else -> println("well it's something else: ${a.javaClass.typeName}")
    }
}