package optiontryeither

object ExceptionHandling extends App {

  try {
    println(34 / 0)
  } catch {
    case ex: ArithmeticException => println(ex.getMessage)
    case ex: Exception => println(ex.getMessage)
  }

  println(">>>>")

  try {
    println(34 / 0)
  } catch {
    case ex: ArithmeticException => println(ex.getMessage)
    case ex: Exception => println(ex.getMessage)
  } finally {
    println("finally")
  }

  println(">>>>")

  try {
    println(34)
  } catch {
    case ex: ArithmeticException => println(ex.getMessage)
    case ex: Exception => println(ex.getMessage)
  } finally {
    println("finally")
  }

  def checkAge(age: Int): Boolean = if (age > 18) true else throw new Exception("Not eligible")

  try {
    println(checkAge(222))
    println(checkAge(3))
    println(checkAge(22))
  } catch {
    case ex: Exception => println(ex.getMessage)
  }

  println("MMMM")


  case object NotValidAgeException extends Exception("Not eligible age.")

  @throws[Exception]
  def checkAge1(age: Int): Boolean = if (age > 18) true else throw NotValidAgeException

  try {
    println(checkAge1(2))
  } catch {
    case NotValidAgeException => println("asas")
  }
}
