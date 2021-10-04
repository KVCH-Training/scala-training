package funtional

import scala.annotation.tailrec

object CallByValueCallByName extends App {

  def increment(a: Int) = 1 + 1

  println(increment(23))

  println(increment{
    println("Hello")
    23
  })

  println(">>>>>>>>>>>>>>")

  def increment1(a: => Int) = {
    println("LLLLL")
    println(a + 1)
  }

  increment(1)
  increment1(1)

  increment1{
    println("Scala")
    333
  }

  increment{
    println("Hello")
    23
  }

  increment1(1212)

  def increment2(a: () => Int) = {

  }

  def sum(args: Int*): Int = {

    @tailrec
    def compute(index: Int, output: Int = 0): Int = {
      if (index >= args.length) {
        output
      } else {
        compute(index + 1, output + args(index))
      }
    }

    compute(0)
  }

  increment2(() => 45)


}
