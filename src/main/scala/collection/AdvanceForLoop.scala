package collection

object AdvanceForLoop extends App {

  val list1: IndexedSeq[Int] = for (i <- 0 to 4) yield i * 2

  println(list1)

  val list2 = List(1, 2)
  val list3 = List("X", "Y")
  val list4 = List("A", "B")


  val output: List[(Int, String)] = for {
    a <- list2
    b <- list3
  } yield (a, b)

  val output1: List[(Int, String)] = list2.flatMap(a => list3.map(b => (a, b)))

  println(output)
  println(output1)

  val output2: List[(Int, String, String)] = for {
    a <- list2
    b <- list3
    c <- list4
  } yield (a, b, c)

  val output3: List[(Int, String, String)] = list2.flatMap(a => list3.flatMap(b => list4.map(c => (a, b, c))))

  println(output2)
  println(output3)

  val output4: List[(Int, String, String)] = for {
    a <- list2
    b <- list3
    c <- list4

    if (a % 2 != 0)
  } yield (a, b, c)

  println(output4)

  val output5 = list2.filter(_%2 == 0).flatMap(a => list3.flatMap(b => list4.map(c => (a, b, c))))


  println(output5)

  val options: Option[(String, Int)] = for {
    a <- Option("Hello")
    b <- Option(34)
  } yield (a, b)

  Option("hello").flatMap(a => Option(33).map(b => (a, b)))

  class Node[T](name: T) {

    def map[A](fxn: T => A): Node[A] = {
      println("Hello")
      new Node(fxn(name))
    }

    def flatMap[A](fx: T => Node[A]): Node[A] = {
      println("Hello1")
      fx(name)
    }
  }

  val node = new Node(23)
  val node1 = new Node("hello")

  val output8: Node[(Int, String)] = for {
    a <- node
    b <- node1
  } yield (a, b)

  node.flatMap(a =>node1.map(b => (a, b)))
}
