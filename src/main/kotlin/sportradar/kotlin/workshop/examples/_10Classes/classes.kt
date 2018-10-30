package sportradar.kotlin.workshop.examples._10Classes

class NoCtor
class PrimaryCtor(val prop1: String, val prop2: Int)
class PrimWithInit(val prop1:String) {
    init {
        require(prop1.length > 1)
    }
}
class MultiConstructor(private val prop1: String, val prop2: Int){
    constructor(propPair: Pair<String, Int>) : this(propPair.first, propPair.second)
    init {
        require(prop1 == "yo")
        require(prop2 > 1)
    }
}