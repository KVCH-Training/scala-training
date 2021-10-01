package funtional

import scala.util.Random

object FunctionalExample extends App {

  object ReferentialTransparency {

    def sq(x: Int): Int = x * x

    def sq1(x: Int): Int = {
      println(x)
      x * x
    }

    val a: Int = 1 + 2

    println(sq(2)) // -> println(4)

    println(sq1(2)) //
  }

  object PureFunctions {

     def f(x: Int): Int = x + 10
      def g(x: Int): Int = new Random().nextInt(2) + 10

    println(f(1))
    println(g(1))
  }

  object SideEffect {

    def add(a: Int, b: Int): Unit = println(a + b)

    def add2(a: Int, b: Int): Unit = {
      a + b
    }

    def add1(a: Int, b: Int): Int = {
      println("sas")
      a + b
    }
  }

  object MutableAndImmutable

  object HighOrderFunctions

  object AnonymousFunctions

  object FunctionCurrying {

    def student(name: String, rollNumber: Int, section: String) = s"$name, $rollNumber, $section"

    val studentOfSectionA: (String, Int) => String = (name: String, rollNumber: Int) => student(name, rollNumber, "A")
    val studentOfSectionB: (String, Int) => String = (name: String, rollNumber: Int) => student(name, rollNumber, "B")

    val studentOfSectionC: (String, Int) => String = student(_, _, "C")
  }

  object Wildcard {

    def add(a: Int, b: Int)(fxn: (Int, Int) => Int): Int = fxn(a, b)

    println(add(1, 2)((a, b) => a + b))

    println(add(1, 2)(_ + _))

    def map[A, B](fxn: A => B)(arg: A): B = fxn(arg)

    println(map[Int, Int](a => a + 1)(2))

    println(map[Int, Int](_ + 1)(2))

    map[Int, String](a => {
      println("Sas")
      a + 1 + ""
    })(23)

    map[Int, String]{a =>
      println("Sas")
      a + 1 + ""
    }(23)


    map[Int, Int]{
      case 0 => 0 + 1
      case 1 => 2
      case _ => Int.MinValue
    }(23)
  }

  object PartialFunctions {


    val partialFxn: PartialFunction[(Int, Int), Int] = new PartialFunction[(Int, Int), Int] {
      override def isDefinedAt(x: (Int, Int)): Boolean = x._2 != 0

      override def apply(v1: (Int, Int)): Int = v1 match {
        case (x, y) => x / y
      }
    }

    if (partialFxn.isDefinedAt((2, 3))) {
      println(partialFxn((2, 3)))
    }

    val partialFxn1: PartialFunction[Int, Int] = {
      case x if x != 0 => 2 / x
    }

    val partialFunction: PartialFunction[Int, String] = {
      case x => x.toString
    }

    val partialFxn2: PartialFunction[Int, String] = partialFxn1 andThen partialFunction

    println(partialFunction(23))

  }
}
