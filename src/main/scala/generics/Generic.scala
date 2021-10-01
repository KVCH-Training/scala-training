package generics

object Generic extends App {

  val array: Array[Any] = Array(1, (), true, "Hello")

  val firstElement: Any = array(0)
//  val firstElement1: Int = array(1).asInstanceOf[Int]

  val array1: Array[Int] = Array(1, 2)

  val second: Int = array1(0)

  case class Record[A](value: A) {

    def map[B](fxn: A => B): Record[B] = copy(fxn(value))
  }

  val record: Record[Int] = Record[Int](23)

  val a: Int = record.value

  val record1: Record[String] = Record("Hello")

  val a1: String = record1.value

  val x: Record[Int] = record.map(_ + 1)
  val x1: Record[String] = x.map(_.toString)
  val x2: Record[Int] = x1.map[Int](_.toInt)

  println(x, x1, x2)

  println(x.map(_ + 2).map(_ * 4).map(f => s"Value is $f").value)

  type TupleOfInt = (Int, Int)

  def add(input: TupleOfInt): Int =input match {
    case (x, y) => x + y
  }

  val f: (Int, Int) = (1, 2)
  val f1: TupleOfInt = (1, 2)
}
