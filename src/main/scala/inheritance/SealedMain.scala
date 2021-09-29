package inheritance

object SealedMain extends App {

  def print(sealedInheriatnce: SealedInheriatnce): String = sealedInheriatnce match {
    case a: SealedInheriatnceA => "A"
    case b: SealedInheriatnceB => "B"
  }

  class X

  object A extends X

  //  class B extends A

  def getGender(gender: Gender) = gender match {
    case Male => "male"
    case Female => "female"
    case Other => "other"
  }
}
