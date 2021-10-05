import EnumerationsExample.Week.Week

object EnumerationsExample extends App {

  object Week extends Enumeration {

    type Week = Value

    val MONDAY = Value("monday")
    val TUESDAY = Value("tuesday")

  }

  println(Week.MONDAY)


  week(Week.TUESDAY)

  val a: Week = Week.withName("tuesday")

  def week(day: Week) = println(day)

  sealed trait Gender

  object Gender {

    case object Male extends Gender
    case object Female extends Gender
    case object Others extends Gender

    def values: Seq[Gender] = List(Male, Female, Others)

    def withName(input: String): Option[Gender] = values.find(_.toString.toLowerCase == input.toLowerCase)
  }

  def printGender(gender: Gender) = println(gender)

  printGender(Gender.Male)

  val b = Gender.withName("male")
}
