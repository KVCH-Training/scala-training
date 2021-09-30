package caseclass

import spray.json._
import spray.json.DefaultJsonProtocol._

object SprayJsonExample extends App {

  case class Student(name: String, rollNumber: Int, address: Address, marks: Map[String, Int])

  case class Address(city: String, state: String, country: String)

  val marks = Map("Maths" -> 45, "English" -> 65)
  val address = Address("Lucknow", "UP", "IN")
  val student = Student("Arun", 12, address, marks)

  println(student)

  implicit val addressJsonFormat: RootJsonFormat[Address] = jsonFormat3(Address.apply)
  implicit val studentJsonFormat: RootJsonFormat[Student] = jsonFormat4(Student)

  println(student.toJson.prettyPrint)

  val json =
    """
      |{
      |  "address": {
      |    "city": "Lucknow",
      |    "country": "IN",
      |    "state": "UP"
      |  },
      |  "marks": {
      |    "Maths": 45,
      |    "English": 65,
      |    "Hindi": 65
      |  },
      |  "name": "Arun",
      |  "rollNumber": 12
      |}
      |""".stripMargin

  val obj: Student = json.parseJson.convertTo[Student]

  println(obj)
}
