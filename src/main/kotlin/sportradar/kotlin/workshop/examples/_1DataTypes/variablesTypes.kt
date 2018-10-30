package sportradar.kotlin.workshop.examples._1DataTypes

fun main(args: Array<String>) {
    var language: String = "French"
    val score: Int = 95

    val char: Char = 'h'
    val book: Boolean = true

    val byte: Byte = 123
    val short: Short = 12_345
    val int: Int = 1_234_567
    val long: Long = 12_345_678L
    val float: Float = 1_234.56f
    val double: Double = 1_234.56e2

    val hex = 0xFF_EC_DE_0F
    val bin = 0b00001011_01101001_10010100_10010010


    val s = "Hello, World!\n"
    val text = """
        |for (c in "foo")
        |    print(c)
    """.trimIndent() //default "|"
    println("$s.length is ${s.length}")
    println("${'$'}")

    //Experimental
//    val ubyte: UByte = 255u
//    val ushort: UShort = 65535u
//    val uint: UInt = 123u
//    val ulong: ULong = 123uL

}