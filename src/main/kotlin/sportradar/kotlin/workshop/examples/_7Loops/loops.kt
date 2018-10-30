package sportradar.kotlin.workshop.examples._7Loops

fun main(args: Array<String>) {

    for (i in 1..5) {
        println(i)
    }

    print("for (i in 1..5) print(i) = ")
    for (i in 1..5) print(i)

    println()

    print("for (i in 5..1) print(i) = ")
    for (i in 5..1) print(i)             // prints nothing

    println()

    print("for (i in 5 downTo 1) print(i) = ")
    for (i in 5 downTo 1) print(i)

    println()

    print("for (i in 1..4 step 2) print(i) = ")
    for (i in 1..5 step 2) print(i)

    println()

    print("for (i in 4 downTo 1 step 2) print(i) = ")
    for (i in 5 downTo 1 step 2) print(i)

    var language = arrayOf("Ruby", "Koltin", "Python", "Java")

    for (item in language)
        println(item)

    for (item in language.indices) {

        // printing array elements having even index only
        if (item%2 == 0)
            println(language[item])
    }

    var text= "Kotlin"

    for (letter in text) {
        println(letter)
    }

    fun main(args: Array<String>) {

        here@ for (i in 1..5) {
            for (j in 1..4) {
                if (i == 3 || j == 2)
                    continue@here
                println("i = $i; j = $j")
            }
        }
    }
}