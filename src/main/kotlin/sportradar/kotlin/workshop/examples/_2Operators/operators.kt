package sportradar.kotlin.workshop.examples._2Operators

fun main(args: Array<String>) {

    val number1 = 12.5
    val number2 = 3.5
    var result: Double

    result = number1 + number2
//    number1.plus(number2)
    println("number1 + number2 = $result")

    result = number1 - number2
//    number1.minus(number2)
    println("number1 - number2 = $result")

    result = number1 * number2
//    number1.times(number2)
    println("number1 * number2 = $result")

    result = number1 / number2
//    number1.div(number2)
    println("number1 / number2 = $result")

    result = number1 % number2
//    number1.rem(number2)
    println("number1 % number2 = $result")

var operator = Operator(10)
    println(operator + Operator(5))
    println(operator - Operator(5))
    println(operator * Operator(5))
    println(operator / Operator(5))
    println("++ ${++operator}" ) //req operator to be declared with var
    println("-- ${--operator}" ) //req operator to be declared with var
    println(operator(12345))
}

data class Operator(val value: Int) {
    operator fun plus(other: Operator): Operator = Operator(this.value + other.value)
    operator fun minus(other: Operator): Operator = Operator(this.value - other.value)
    operator fun times(other: Operator): Operator = Operator(this.value * other.value)
    operator fun div(other: Operator): Operator = Operator(this.value / other.value)
    operator fun rem(other: Operator): Operator = Operator(this.value % other.value)
    operator fun unaryPlus() = Operator(+this.value)
    operator fun unaryMinus() = Operator(-this.value)
    operator fun inc() = Operator(this.value + 1) //req var
    operator fun dec() = Operator(this.value - 1) //req var

    operator fun invoke(other: Int) = Operator(other)
}