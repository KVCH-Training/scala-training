package collection

object StringExample extends App {

  val str = "Hello"

  str.foreach(println)

  println(str.head)

  println(str.tail)

  val mapped = str.map(f => f + 1)
}
