package companion

object ApplyMethod extends App {

  class Student(private val name: String) {

    def apply(greeting: String) = s"$greeting $name"

    def apply(greeting: String, lName: String) = s"$greeting $name $lName"
  }

  object Student {

    def apply(name: String) = new Student(name)
  }

  val student: Student = new Student("Arun")
  val student1: Student = Student.apply("Arun")
  val student2: Student = Student("Arun")

  println(student.apply("Hello"))
  println(student.apply("Hello", "Singh"))

  println(student("Hello"))
  println(student("Hello", "Singh"))

  val array: Array[Int] = Array(1,2,3,4,5)

  val array1: Array[Int] = Array.apply(1,2,3,4,5)
}
