package sportradar.kotlin.workshop.examples._3TypeConvertion

import java.math.MathContext

fun main(args: Array<String>) {
    val int: Int = 1
    val byte = int.toByte()
    val uByte = int.toUByte()
    val short = int.toShort()
    val uShort = int.toUShort()
    val long = int.toLong()
    val uLong = int.toULong()
    val float = int.toFloat()
    val double = int.toDouble()
    val bigInteger = int.toBigInteger()
    val bigDecimal = int.toBigDecimal()
    val bigDecimalMC = int.toBigDecimal(MathContext.UNLIMITED)



}