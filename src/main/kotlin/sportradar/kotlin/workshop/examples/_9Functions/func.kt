package sportradar.kotlin.workshop.examples._9Functions

fun main(args: Array<String>) {
    infix()

    val p = Structure()
    p createPyramid 4       // p.createPyramid(4)
    p.createPyramid(4)

    displayBorder()
    displayBorder('*')
    displayBorder(length = 4)
}

fun infix(){
    val a = true
    val b = false
    var result: Boolean

    result = a or b // a.or(b)
    println("result = $result")

    result = a and b // a.and(b)
    println("result = $result")
}

class Structure {

    infix fun createPyramid(rows: Int) {
        var k = 0
        for (i in 1..rows) {
            k = 0
            for (space in 1..rows-i) {
                print("  ")
            }
            while (k != 2*i-1) {
                print("* ")
                ++k
            }
            println()
        }
    }
}

fun displayBorder(character: Char = '=', length: Int = 15) {
    for (i in 1..length) {
        print(character)
    }
}


