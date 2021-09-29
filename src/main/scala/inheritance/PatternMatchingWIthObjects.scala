package inheritance

object PatternMatchingWIthObjects extends App {

  trait A

  class B extends A {

    def b: String = "B"
  }
  class C extends A
  class D extends A
  class E extends A

//  final class X
//
//  class Y extends X

//  printNameOfObj(new C)

  println(getClass(new E))

  def getClass(input: A)= input match {
    case b: B => "B"
    case c: C => "C"
    case d: D => "D"
  }

  def printNameOfObj(input: A): Unit = {
    if (input.isInstanceOf[B])
      println(input.asInstanceOf[B].b)
    else if (input.isInstanceOf[C])
      println("C")
    else if (input.isInstanceOf[D])
      println("D")
    else
      println("Unknown")
  }

  def printNameOfObj1(input: A): Unit = input match {
    case b: B =>
      println(b)
      println(b.b)
    case c: C =>
      println("C")
    case d: D =>
      println(d)
//    case "Hello" => println("Sas")
    case _ => println("Unknown")
  }
}
