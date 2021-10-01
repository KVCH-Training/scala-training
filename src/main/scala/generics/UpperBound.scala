package generics

object UpperBound extends App {

  trait A {
    override def toString: String = "A"
  }
  trait B extends A {
    override def toString: String = "B"
  }
  trait C extends B {
    override def toString: String = "C"
  }
  trait D extends B {
    override def toString: String = "D"
  }

  // A or child classes of A
  def print[T <: B](data: T): Unit = println(data.toString)

//  print("hello")
//  print(1223)

//  print(new A{})
  print(new B{})
  print(new C{})
  print(new D{})
}
