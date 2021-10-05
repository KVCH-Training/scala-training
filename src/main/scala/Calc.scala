import scala.concurrent.{ExecutionContext, Future}

object Calc {

  def add(a: Int, b: Int)(implicit ec: ExecutionContext): Future[Int] = Future(a + b)
}
