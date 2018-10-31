package sportradar.kotlin.presentation._8DSL

import com.google.gson.ExclusionStrategy
import com.google.gson.FieldAttributes
import com.google.gson.Gson
import com.google.gson.GsonBuilder

val gson = GsonBuilder()
  .addDeserializationExclusionStrategy(object : ExclusionStrategy {
    override fun shouldSkipClass(clazz: Class<*>?): Boolean {
      return clazz?.equals(Address::class.java) ?: false
    }

    override fun shouldSkipField(f: FieldAttributes?): Boolean {
      return f?.let { it.name == "internalId" } ?: false
    }

  })
  .addSerializationExclusionStrategy(object : ExclusionStrategy {
    override fun shouldSkipClass(clazz: Class<*>?): Boolean {
      return false
    }

    override fun shouldSkipField(f: FieldAttributes?): Boolean {
      return f?.let { it.declaringClass == Person::class.java && it.name == "address" } ?: false
    }

  })
  .serializeNulls()
  .create()



val gson2 = gson {
  dontDeserialize {
    whenField { name == "internalId" }
    whenClass { equals(Address::class.java) }
  }
  dontSerialize {
    whenField { declaringClass == Person::class.java && name == "address" }
  }
  serializeNulls()
}



fun gson(block: GsonBuilder.() -> Unit): Gson = GsonBuilder().apply(block).create()


fun GsonBuilder.dontDeserialize(block: ExclusionStrategyBuilder.() -> Unit) {
  val strategy = ExclusionStrategyBuilder().apply(block).build()
  this.addDeserializationExclusionStrategy(strategy)
}

fun GsonBuilder.dontSerialize(block: ExclusionStrategyBuilder.() -> Unit) {
  val strategy = ExclusionStrategyBuilder().apply(block).build()
  this.addSerializationExclusionStrategy(strategy)
}

class ExclusionStrategyBuilder {

  private var field: (FieldAttributes) -> Boolean = { false }
  private var clazz: (Class<*>) -> Boolean? = { false }

  fun whenField(block: FieldAttributes.() -> Boolean) {
    field = block
  }

  fun whenClass(block: Class<*>.() -> Boolean) {
    clazz = block
  }

  fun build(): ExclusionStrategy {
    return object : ExclusionStrategy {
      override fun shouldSkipClass(clazz: Class<*>?): Boolean {
        return clazz?.let { clazz(it) } ?: false
      }

      override fun shouldSkipField(f: FieldAttributes?): Boolean {
        return f?.let { field(it) } ?: false
      }

    }
  }
}