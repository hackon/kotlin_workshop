package sportradar.kotlin.presentation._3nullSafety

fun main(args: Array<String>) {
    var x :String = "name"
//    x = null //not possible
    var y:String? = "name"
    y = null

    val name = y ?: "nullName"

    var person: Person? = Person(null)
    person = null
    val name2 = person?.name ?: "other name"
}

data class Person(val name:String?)