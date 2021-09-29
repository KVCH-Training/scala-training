package companion

object UnApplyMethod extends App {

  val optionName: Option[String] = Option("Hello")
  val optionName2: Option[String] = Option(null)

//  println(optionName2 == None)

  val Some(name: String) = optionName
//  val Some(name1) = optionName2

  println(name)
  println(optionName)

  findLength(Some("!11111"))

  def findLength(input: Option[String]): Unit = input match {
    case Some(name) => println(name.length)
    case None => println(0)
  }

  class Person(val name: String, val rollNumber: Int) {

    val section = "A"
  }

  object Person {

    def unapply(person: Person): Option[(String, Int)] = Option(person) match {
      case Some(per) => Some(per.name, per.rollNumber)
      case None => None
    }
  }

  val person = new Person("Arun", 1)

  val Person(perName, rollNumber) = person

  println(perName, rollNumber)

  person match {
    case Person(nm1, roll) =>
      println(nm1)
      println(roll)
//      println(section)
  }
}
