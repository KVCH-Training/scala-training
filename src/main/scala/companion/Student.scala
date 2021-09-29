package companion

class Student(val name: String, private val rollNumber: Int) {

  override def toString: String = s"Student($name, $rollNumber, ${Student.CLASS})"
}

object Student {

  def printRoolNumber(students: Array[Student]) = {
    for (student <- students) {
      println(student.rollNumber)
    }
  }

  private val CLASS = "CS"

  def printAllStudent(students: Array[Student]): Unit = {

    for (student <- students) {

      println(student)
    }
  }
}
