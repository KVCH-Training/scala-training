package funtional

object DifferenceDefAndValFunct extends App {

  val funct: Int => Int = a => a + 1

  val funct1: Function1[Int, Int] = a => a + 1

  val funct3: (Int, Int) => Int = (a: Int, b: Int) => a + b

  val funct4: Function2[Int, Int, Int] = (a: Int, b: Int) => a + b

  val tuple: (Int, Int) = (1, 2)
  val tuple1: (Int, Int) = 1 -> 2

  val tuple2: Tuple2[Int, Int] = Tuple2(2, 3)
  val tuple3: (Int, Int) = Tuple2(2, 3)

  println(funct(1))
  println(funct.apply(1))

  println(funct1(2))

  println(funct.isInstanceOf[Function1[Int, Int]])
  println(funct1.isInstanceOf[Function1[Int, Int]])

  println(funct.isInstanceOf[Int => Int])
  println(funct1.isInstanceOf[Int => Int])

  def add(a: Int, b: Int)  = a+ b

  println(add(1, 2))
  println(funct3.apply(1, 2))

  println(add(1, 2))
  println(funct3.apply(1, 2))

  println(add(1, 2))
  println(funct3.apply(1, 2))

  class A extends (Int => Int) {
    override def apply(v1: Int): Int = v1 + 1
  }

  class B extends Function2[Int, Int, String] {
    override def apply(v1: Int, v2: Int): String = ???
  }

  val a1: A = new A

  println(a1(23))

  val a2: Int => Int = new A
}
