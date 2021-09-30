package caseclass

object CaseObjectExample extends App {

  object A

  case object B

  println(B.isInstanceOf[Serializable])
  println(A.isInstanceOf[Serializable])

  println(A)
  println(B)


  sealed trait Gender {

    def name: String = toString.toLowerCase
  }

  object Gender {

    case object Male extends Gender
    case object Female extends Gender

    def values: Array[Gender] = Array(Male, Female)

    def fromName(inpt: String): Gender = inpt.toLowerCase match {
      case "male" => Male
      case "female" => Female
    }
  }
}
