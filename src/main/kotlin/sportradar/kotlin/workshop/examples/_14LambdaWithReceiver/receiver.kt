package sportradar.kotlin.workshop.examples._14LambdaWithReceiver

import java.sql.Connection
import java.sql.ResultSet

fun main(args: Array<String>) {
  val sb = StringBuilder()
  sb.appendln("Alphabet: ")
  for (c in 'a'..'z') {
    sb.append(c)
  }
  println(sb.toString())

  val sbWith = StringBuilder()
  println(with(sb) {
    // implicit this. inside the block
    appendln("Alphabet: ")
    for (c in 'a'..'z') {
      append(c)
    }
    toString()
  })

  val s = buildString2 {
    appendln("Alphabet: ")
    for (c in 'a'..'z') {
      append(c)
    }
  }
  println(s)

  val isEven: (Int) -> Boolean = { it % 2 == 0 }
  val isOdd: Int.() -> Boolean = { this % 2 == 1 }
  isEven(6) // regular function
  3.isOdd() // extension function

  val sql = "select * from something"
  val result = mutableListOf<String>()
  MyConnection().use { db ->
    db.autoCommit = false
    db.prepareStatement(sql).use { prepareStatement ->

      prepareStatement.executeQuery().use { resultSet ->
        while (resultSet.next()) {
          result.add(resultSet.getString("id"))
        }
      }
    }
  }
  println(result)
  val mapResult: List<Pair<String, Int>> =
    MyConnection().mapResult(sql) {
      getString("id") to getInt("value")
    }
  val map: Map<String, Int> = mapResult.toMap()
}


inline fun buildString2(builderAction: StringBuilder.() -> Unit): String {
  val stringBuilder = StringBuilder()
  stringBuilder.builderAction()
  return stringBuilder.toString()
}

inline fun <T> Connection.mapResult(sql: String, mapper: ResultSet.() -> T): List<T> {
  val result = mutableListOf<T>()
  this.use { db ->
    db.createStatement().use { st ->
      st.executeQuery(sql).use { rs ->
        while (rs.next()) {
          rs.mapper()
        }
      }
    }
  }
  return result
}

inline fun <T : AutoCloseable?, R> T.use(block: (T) -> R): R {
  var exception: Throwable? = null
  try {
    return block(this)
  } catch (e: Throwable) {
    exception = e
    throw e
  } finally {
    when {
//            apiVersionIsAtLeast(1, 1, 0) -> this.closeFinally(exception)
      this == null -> {
      }
      exception == null -> close()
      else ->
        try {
          close()
        } catch (closeException: Throwable) {
          // cause.addSuppressed(closeException) // ignored here
        }
    }
  }
}