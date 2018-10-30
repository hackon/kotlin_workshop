package sportradar.kotlin.presentation._4higherOrderLambda

typealias ClickHandler = (String, (String)->Unit)->Unit

fun main(args: Array<String>) {
    val listOf = listOf(1, 2, 3, 4, 5, 6)
    val doubleList = listOf.map { it * 2 }
    // creates a new list for each operation,
    // so if multiple steps use sequence aka streams
    val doubleBelowTenList = listOf.asSequence()
        .map { it * 2 }
        .filter { it < 10 }
        .toList()

    val folded = listOf.fold(0) { acc, i -> acc + i }
    println(folded)

    funky({it.toInt()}) {
        listOf.toSet()
    }

    val funkytoo: Char? = funkytoo('r') { null }

    val stringPlus: (String, String) -> String = String::plus
    val intPlus: Int.(Int) -> Int = Int::plus

    println(stringPlus.invoke("<-", "->"))
    println(stringPlus("Hello, ", "world!"))

    println(intPlus.invoke(1, 1))
    println(intPlus(1, 2))
    println(2.intPlus(3))
}
fun funky(fun1: (Number) -> Int, fun2: (List<out Number>) -> Set<Int>) {

}

fun <T, R> funkytoo(value:T,function: (T) -> R?): R? {
    return function(value)
}

