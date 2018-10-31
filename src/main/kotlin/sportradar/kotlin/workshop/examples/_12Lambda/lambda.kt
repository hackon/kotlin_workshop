package sportradar.kotlin.workshop.examples._12Lambda

//    button.addActionListener(new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            System.out.println("Hi")
//        }
//    })

//button.addActionListener { println("Hi")}
fun main(args: Array<String>) {
  val list = listOf<Int>()
  list.any({i: Int -> i > 0})
  list.any(){i: Int -> i > 0}
  list.any { i: Int -> i > 0}
  list.any { i -> i > 0}
  list.any { it > 0}
  list.any {
    println("processing $it")
    it > 0 // last expression is the result
  }

  fun foo(list: List<String>) {
    list.forEach {
      if(it == "foo") return // returns from the funtion
    }
    println("foo")
  }

  fun foo2(list: List<String>) {
    list.forEach {
      if(it == "foo") return@forEach // returns to foreach
    }
    println("foo2")
  }

  fun foo3(list: List<String>) {
    list.forEach (fun (t) {
      if(t == "foo") return // explicit syntax returns to foreach
    })
    println("foo3")
  }

  val stringList = listOf("foo")
  foo(stringList)
  foo2(stringList)
  foo3(stringList)

  val people = listOf(Person("Per", 18))
  people.maxBy { it.age }
  people.maxBy(Person::age)



}

class Person(val name:String, val age:Int)