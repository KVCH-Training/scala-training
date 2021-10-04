package collection

object StackMain extends App {

  val stack = Stack[Int]()

  stack.push(11)
  stack.push(12)
  stack.push(14)

  println(stack.pop())
  println(stack.pop())

  stack.push(13)

  stack.foreach(println)
}
