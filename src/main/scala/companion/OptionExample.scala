package companion

object OptionExample extends App {

  val name: String = null

//  println(name.length)

  val optionalName: Option[String] = Option(null)
  val optionalName1: Option[String] = Option.apply("Hello")

  println(optionalName1.get + ">>>>>>>>>>")
//  println(optionalName.get)

  if (optionalName.isDefined) {
    println(optionalName1.get)
  } else {
    println("NoValue")
  }

  println(optionalName.isEmpty)
  println(optionalName1.isEmpty)

  println(optionalName.isDefined)
  println(optionalName1.isDefined)

  val optionValue: Option[String] = Some("Hello")
  val optionValue1: Some[String] = Some.apply("Hello")

  val noValue: Option[String] = None

  findLengthOfString(Some("Hello"))
  findLengthOfString(None)
  findLengthOfString(Option("Jello"))
  findLengthOfString(Option(null))
  findLengthOfString(Some(null))

  def findLengthOfString(optionalString: Option[String]) = optionalString match {
    case some: Some[String] =>
      println(some.get.length)
    case None =>
      println(0)
  }
}
