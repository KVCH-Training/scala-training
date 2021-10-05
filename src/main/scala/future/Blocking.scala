package future

import java.util.concurrent.TimeUnit
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.{Duration, FiniteDuration}

// https://stackoverflow.com/a/41170782/14104693
object Blocking extends App {

  println(Thread.currentThread().getName)

  val future: Future[Int] = Future {
    Thread.sleep(3000)
    23
  }

  println(future.isCompleted)

  val output: Int = Await.result(future, FiniteDuration(2, TimeUnit.SECONDS))

  Await.result(Future{34}, Duration.Inf)

  println(future.isCompleted)

  println(output)
}
