package optiontryeither

import scala.util.Try

object EitherExample extends App {

  def method(age: Int) = {
    if (age > 18) {
      age
    } else {
      "NotValid"
    }
  }

  def method1(age: Int): (Int, String) = {
    if (age > 18) {
      (age, null)
    } else {
      (Int.MinValue, "NotValid")
    }
  }

  def method2(age: Int): (Option[Int], Option[String]) = {
    if (age > 18) {
      (Some(age), None)
    } else {
      (None, Some("Not valid"))
    }
  }

  method2(23) match {
    case (Some(value), Some(value1)) =>
    case (Some(value), None) =>
    case (None, Some(value1)) =>
    case (None, None) =>
  }

  def method3(age: Int): Either[Int, String] = {
    if (age > 18) {
      Left(1111)
    } else {
      Right("dssd")
    }
  }

  method3(22) match {
    case Right(value) =>
    case Left(value) =>
  }


  val either: Either[Throwable, Int] = Try(122/0).toEither
  val option: Option[Int] = Try(23/0).toOption

  either match {
    case Left(value: Exception) => value.printStackTrace()
    case Right(value) => println(value)
  }
}
