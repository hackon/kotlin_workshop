package sportradar.kotlin.presentation._2variableDef

import java.math.BigDecimal

fun main(args: Array<String>) {
    val pi = StrictMath.PI
    val piDec: Double = StrictMath.PI
    val piBD: BigDecimal = StrictMath.PI.toBigDecimal()
//    pi = 2.0

    var name = "java"
    name = "kotlin"
    var age: Int = 23
    age = 2

    // (default immutable) kotlin list
    val listOf = listOf('1', '2', '3')

    val listOfDec: List<Char> = listOf
//    listOf.add()  doens't exist
    val newImmutableList = listOf + '4'
//    newImmutableList == ['1','2','3','4']
    println(newImmutableList)


    val mutableListOf = listOf.toMutableList() // or mutableListOf('1', '2', '3')
    val mutableListOfDec: MutableList<Char> = mutableListOf
    mutableListOf.add('4')
    println(mutableListOf)

}
