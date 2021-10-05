object Implicit extends App  {

  def compute(a: Int, b: Int)(implicit fxn: (Int, Int) => Int): Int = fxn(a, b)

  implicit val add : (Int, Int) => Int = (a, b) => {
    println("ASas")
    a + b
  }

//  implicit val sub : (Int, Int) => Int = (a, b) => {
//    println("ASas")
//    a + b
//  }


  println(compute(1,2))



  def name(name: String)(implicit greeting: String) = s"$greeting $name"

  implicit def gret: String = "hello"
  implicit def int = 45

  println(name("arun"))
  println(name("arun")("Sas"))

  def name1(name: String)(implicit greeting: String, a: Int) = s"$greeting $name"

  println(name1("arun"))
  println(name1("arun")("Sas", 22))
  println(name1("sddsd")(implicitly[String], 344))


  implicit class StringExte(name: String) {

    def count: Int = name.length
  }

//  val a = "hello"
//  val b = new StringExte("hello")
//
//  println(a.count)
//  println(b.count)
}
