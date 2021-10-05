package future

import java.util.concurrent.{ExecutorService, Executors}
import scala.concurrent.{ExecutionContext, Future}

object ExecutionCOntextExample extends App {

  object Simple extends ExecutionContext {

    private var i= 0

    override def execute(runnable: Runnable): Unit = {
      println("Task submitted by " + Thread.currentThread().getName)
      new Thread(runnable, s"ThreadName-$i").start()
      i += 1
      println("Task had been submitted by " + Thread.currentThread().getName)
    }

    override def reportFailure(cause: Throwable): Unit = println(cause.getMessage + ">>>>>>>>>")

  }

  class Pool(numThread: Int) extends ExecutionContext {

    val executors: ExecutorService = Executors.newFixedThreadPool(numThread)

    override def execute(runnable: Runnable): Unit = executors.submit(runnable)

    override def reportFailure(cause: Throwable): Unit = ???
  }

  implicit val ec: ExecutionContext = new Pool(2)

  println(Thread.currentThread().getName + ">>>>>>")

  val future = Future {
    println(Thread.currentThread().getName)
    34
  }

  val future1 = Future {
    println(Thread.currentThread().getName)
    342
  }

  println(Thread.currentThread().getName + ">>>>>")

  future.onComplete(println)

}
