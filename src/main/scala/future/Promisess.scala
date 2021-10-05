package future

import scala.concurrent.{Future, Promise}
import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global

object Promisess extends App {

  val promise = Promise[Int]()

  val future: Future[Int] = promise.future

  future.onComplete{
    case Success(value) => print(value)
    case Failure(exception) => exception.printStackTrace()
  }

  promise.success(34)
//  promise.failure(new Exception("dasd"))

  Thread.sleep(1000)
}
