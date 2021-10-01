package funtional

object HighOrderFunctions extends App {

  def calculator(a: Int, b: Int, fxn: (Int, Int) => Int): Int = fxn(a, b)

  println(calculator(1, 2, (a, b) => a + b))
  println(calculator(1, 2, (a, b) => a - b))
  println(calculator(1, 2, (a, b) => a * b))

  def add(a: Int, b: Int): Int = a + b

  println(calculator(1, 2, add))

  def calculator(a: Int): Int => Int = (b: Int) => a + b

  val a: Int => Int = calculator(1)
  val a1: Int = a(2)

  println(a1)

  println(calculator(1)(2))

  def calculator1(a: Int)(b: Int): Int = a + b


  println(calculator1(1)(2))
  println(calculator(1)(2))

  val b: Int => Int = calculator1(1)

  // Int => Int => Int
  def calculator2(a: Int): Int => Int => Int = (b: Int) => (c: Int) => a + b + c

  println(calculator2(1)(2)(3))

  val c1: Int => Int => Int => Int = calculator2
  val c2: Int => Int => Int = c1(1)
  val c3: Int => Int = c2(1)
  val c4: Int = c3(1)
}
