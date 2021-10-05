package collection

// eq, equals, ==
object DifferenceEquals extends App {

  class Student(val name: String, val rollNumber: Int)
  class Professor(val name: String, val id: Int) {

    override def equals(o: Any): Boolean = o match {
      case professor: Professor => professor.name == name && professor.id == id
      case _ => false
    }
  }

  val student = new Student("Arun", 11)
  val student1 = new Student("Arun", 11)

  val professor = new Professor("Anil", 1)
  val professor1 = new Professor("Anil", 1)

  println(student eq student)
  println(student.eq(student))
  println(student eq student1)

  println(">>>>>>>>>>>>>")

  println(student equals student)
  println(student.equals(student1))

  println(">>>>>>>>>")

  println(student == student)
  println(student.==(student1))

  println(">>>>>>>>>")

  println(professor eq professor1)
  println(professor equals professor1)
  println(professor == professor1) // final method and can not be override, this would use equals method implementation

//  println(null equals professor) // NullPointerException
//  println(null.equals(professor))


  println(null == professor)
  println(null == null)

  val hello = new String("Hello")
  val hello1 = new String("Hello")

  println(">>>>>>>>")

  println(hello eq hello1)
  println(hello1 equals hello)
  println(hello == hello1)

  println(null == hello)

  println(professor equals null)
}

