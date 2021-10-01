package funtional

object Assignment extends App {

  class A {
    override def toString: String = "A"
  }

  trait B {
    override def toString: String = "B"
  }

  println(new A with B)
}
