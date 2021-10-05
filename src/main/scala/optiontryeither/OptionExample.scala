package optiontryeither

object OptionExample extends App {

  val optionalLong = Option(1212L)

  optionalLong.map(f => {
    println(f)
    f + 1
  }).foreach(println)

  val optionExample: Option[String] = None

  optionExample.foreach(println)

//  println(optionExample.get)

  println(optionExample.getOrElse("Default"))

  class A(val a: Int)

  object A {

    def unapply(arg: A): Option[Int] = Option(arg).map(_.a)
  }
}
