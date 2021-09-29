package companion

import xyz.StudentJava
import Student._


object Main extends App {

  val student: Student = new Student("Anup", 1)
  val student1: Student = new Student("Amit", 23)

  val studentJava: StudentJava = new StudentJava("aaa", 233)
  val studentJava1: StudentJava = new StudentJava("bbb", 333)

  println(student.toString)
  println(student1)

  println(studentJava)
  println(studentJava1)

  val array: Array[Student] = Array(student, student1)
  val array1: Array[StudentJava] = Array(studentJava, studentJava1)


  printAllStudent(array)
  StudentJava.printAllStudents(array1)

  StudentJava.printAllStudentRollNumber(array1)

  println(studentJava)
}
