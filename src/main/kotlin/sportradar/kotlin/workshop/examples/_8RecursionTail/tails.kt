package sportradar.kotlin.workshop.examples._8RecursionTail

import java.math.BigInteger

fun main(args: Array<String>) {

    val number = 4
    val result: Long

    //Recursion
    result = factorial(number)
    println("Factorial of $number = $result")

    val n = 100
    val first = BigInteger("0")
    val second = BigInteger("1")

    //Tail Recursion
    println(fibonacci(n, first, second))

    val number2 = 5
    println("Factorial of $number2 = ${factorial(number2)}")
}

fun factorial(n: Int): Long {
    return if (n == 1) n.toLong() else n*factorial(n-1)
}

tailrec fun fibonacci(n: Int, a: BigInteger, b: BigInteger): BigInteger {
    return if (n == 0) a else fibonacci(n-1, b, a+b)
}

tailrec fun factorial(n: Int, run: Int = 1): Long {
    return if (n == 1) run.toLong() else factorial(n-1, run*n)
}