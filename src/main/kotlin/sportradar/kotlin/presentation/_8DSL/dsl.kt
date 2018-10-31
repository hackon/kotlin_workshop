package sportradar.kotlin.presentation._8DSL

import java.text.SimpleDateFormat
import java.util.*

val person = person {
    name = "John"
    dateOfBirth = "1980-12-01"
    addresses {
        address {
            street = "Main Street"
            number = 12
            city = "London"
        }
        address {
            street = "Dev Avenue"
            number = 42
            city = "Paris"
        }
    }
}
data class Person(val name: String,
                  val dateOfBirth: Date,
                  val address: List<Address> )


data class Address(val street: String ,
                   val number: Int ,
                   val city: String )
fun person(block: PersonBuilder.() -> Unit): Person = PersonBuilder().apply(block).build()


@PersonDsl
class PersonBuilder {

    var name: String = ""

    private var dob: Date = Date()
    var dateOfBirth: String = ""
        set(value) {
            dob = SimpleDateFormat("yyyy-MM-dd").parse(value)
        }


    private val addresses = mutableListOf<Address>()

    fun addresses(block: ADDRESSES.() -> Unit) {
        addresses.addAll(ADDRESSES().apply(block))
    }

    fun build(): Person = Person(name, dob, addresses)
}

@PersonDsl
class ADDRESSES: ArrayList<Address>() {

    fun address(block: AddressBuilder.() -> Unit) {
        add(AddressBuilder().apply(block).build())
    }

}

@PersonDsl
class AddressBuilder {

    var street: String = ""
    var number: Int = 0
    var city: String = ""

    fun build() : Address = Address(street, number, city)

}

@DslMarker
annotation class PersonDsl