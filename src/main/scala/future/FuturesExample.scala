package future

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

object FuturesExample extends App {

  println("Main >>>>>")
  println(Thread.currentThread().getName)
  val futre: Future[Int] = Future {
    println(Thread.currentThread().getName + ">>>>>>")
    throw new Exception("dsdsd")
  }

  println("Main ?>>>>")

  futre.map(_ + 2)

  futre.flatMap(f => Future(f * 2))

  futre.onComplete{
    case Success(value) =>
      println(value)
    case Failure(exception) =>
      println(exception.getMessage)
  }
}
