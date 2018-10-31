package sportradar.kotlin.workshop.examples._16Lazy

import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

fun main(args: Array<String>) {
}

// Object corresponds to a table in a database
object Users: IdTable<Int>() {
  // columns
  override val id: Column<EntityID<Int>>
    get() = integer("id").entityId()
  val name = varchar("name", length=50).index()
  val age = integer("age")
}

// correspons to a specific entry in this table
class User(id: EntityID<Int>) : Entity<Int>(id) {
  // values
  // with the 'by' delegate it automaticlt retrieves and updates the value in the db
  var name: String by Users.name
  var age:Int by Users.age
}
