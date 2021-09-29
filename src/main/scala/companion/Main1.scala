package companion

object Main1 extends App {

  class Student(name: String, val rollNumber: Int, var mobile: String, private val age: Int) {

//    name = "Sass"

    def getName: String = name
  }


  object Student {

    def getRollNumber(student: Student): Int = {
//      println(student.name)
      student.age
    }


  }

  val student = new Student("asas", 33, "2233", 17)

  println(student.getName)
  println(student.rollNumber)
  println(student.mobile)
  student.mobile = "asasas"
  println(student.mobile)
//  println(student.age)
  println(Student.getRollNumber(student))
}
