package optiontryeither

import scala.util.{Failure, Success, Try}

// map, flatMap. forEach
object TryExample extends App {

  val tried: Try[Int] = Try(23 / 0)

  tried match {
    case Success(value) => println(value)
    case Failure(exception: ArithmeticException) => println(exception.getMessage)
    case Failure(exception) => println(exception.getMessage)
  }

  val Success(value) = Try(34/4)

  // map flatmap

  val a: Try[Int] = tried.map(f => {
    println(f + ">>>>")
    f
  })

  val b: Try[Int] = tried.flatMap(f => Try(f / 0))
  val c: Try[Try[Int]] = tried.map(f => Try(f / 0))
  val d: Try[Int] = c.flatten

  c match {
    case Success(Success(value)) =>
    case Success(Failure(exception)) =>
    case Failure(exception) =>
  }

  println(a + ">>>>")

//  println(tried.get)

  println(tried.getOrElse(0))

  Try(throw new Exception("Hello")).foreach(println)
}
