package funtional

object LambdaExpressions extends App {

  println(1.+(1))
  println(1 + 1)

  val add: (Int, Int) => Int = (a, b) => a + b

  val print: String => Unit = (a: String) => println(a)

  val print1: Int => Unit = (a: Int) => {
    println("SAsas")
    println("dasdasd")
  }

  val print2: String => Int = {
    case "1" => 1
    case "0" => 0
    case _ => Int.MinValue
  }

  println(add(1, 2))

  print("Hello")
  print1(223)

  print2("2")

  val unit: Unit = ()
}
