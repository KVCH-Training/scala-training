package companion

object PrivateConstructor extends App {

  class Student private () {

    def className = "Student"

   println("Hello")

   println("Asasas")
  }

  object Student {

    def newInstance = {
      val student = new Student
      println("Object ccreated")
      student
    }
  }

  class Person private (email: String)

  object Person {

    def newInstance(email: String) = if (email.contains("@")) new Person(email) else throw new Exception(s"not a valid email $email")
  }

  class Person1(name: String) {

    if (!name.contains("@")) {
      throw new Exception("sasas")
    }
  }

  val student: Student = Student.newInstance

  val person = Person.newInstance("asas@sasas")

  val person1 = new Person1("Dasd")

//  val person1 = Person.newInstance("asassasas")
//  val person = new Person("Asas")

}
