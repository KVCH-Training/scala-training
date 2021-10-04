package collection

import scala.annotation.tailrec


/**
 * 1. isEmpty
 * 2. nonEmpty
 * 3. map
 * 4. head
 * 5. tail
 * 6. filter
 * 7. filterNot
 * 8. length / size
 * 9. flatMap
 * 10. flatten
 * 11. foreach
 * 12. find / exists / contains / forAll
 * 13. foldLeft vs foldRight
 * 14. reduce
 * 15. take/ takeRight/ takeWhile
 * 16. reverse
 * 17. sum
 * 18. mkString
 */
object ImmutableList extends App {

  val list: List[Int] = List(1,2,2,3,4,5)

  println(list(1))

  val str: String = list.mkString
  val toStr: String = list.toString()

  println(str, toStr)

  println(list.mkString(" / "))

  println(list.mkString("[", "  ", "]"))

  println(list.size)
  println(list.length)

  println(list.isEmpty)
  println(list.nonEmpty)

  println(list.head)

  val remaining: List[Int] = list.tail

  println(remaining)

  val incremented: List[Int] = list.map(f => f + 1)

  println(incremented)

  val multiple = list.map(_ * 2)

  println(multiple)

  val triple = list.map(f => f + f + f)

  println(triple)

  val strings: List[String] = list.map(_.toString)

  println(strings)

  val evenNumbers = list.filter(f => f % 2 == 0)

  println(evenNumbers)

  val oddNumbers = list.filter(_ % 2 != 0)

  println(oddNumbers)

  val oddNumbers1 = list.filterNot(_ % 2 == 0)

  println(oddNumbers1)

  val listOfList: List[List[Int]] = List(List(2,3,4), List(1,8,9))

  for (list1 <- listOfList) {
    for (ele <- list1) {
      print(ele + "   ")
    }
    println()
  }

  val addInMatrix = listOfList.map(_.map(_ + 1))

  println(addInMatrix)

  val oneDimensional: List[Int] = listOfList.flatten

  println(oneDimensional)

  val multiplyWithFlatten: List[Int] = listOfList.map(_.map(_ * 2)).flatten

  println(multiplyWithFlatten)

  val multiplyByThree = listOfList.flatMap(list => list.map(_ * 3))

  println(multiplyByThree)

  val multipleByFour = listOfList.flatMap(_.map(_ * 4))

  println(multipleByFour)

  val mappedList: List[List[Int]] = list.map(f => List.fill(3)(f))

  println(mappedList)

  val flappedList: List[Int] = list.flatMap(f => List.fill(3)(f))

  println(flappedList)

//  val wrongly = list.flatMap(_ + 1)

  list.foreach(f => println(f))

  list.foreach(println)

  println(list.contains(20))

  println(list.forall(_ >= 1))

  println(list.exists(_ % 2 == 0))

  val two: Option[Int] = list.find(_ == 2)

  two match {
    case Some(value) => println(value)
    case None => println("Not found")
  }

  val emptyList = List()

  println(emptyList.headOption)
  println(list.headOption)

  val foldLeft = list.foldLeft(0)((f, g) => f + g)

  println(foldLeft)

  val foldRight = list.foldRight(0)(_ + _)

  println(foldRight)

  // https://medium.com/@juntomioka/why-foldright-is-beautiful-7854ede3e133

  @tailrec
  def foldLeft[A, B](input: List[A])(z: B)(fxn: (B, A) => B): B = input match {
    case _ if input.isEmpty => z
    case _ => foldLeft(input.tail)(fxn(z, input.head))(fxn)
  }


  val sum = list.reduce((f, g) => {
    println(f, g)
    f + g
  })

  println(list.take(3))
  println(list.takeRight(2))
  println(list.takeWhile(_ <= 2))

  println(list.reverse)

  println(list.sum)

  val list1: List[Int] = list :+ 12

  println(list1)

  val list2: List[Int] = 12 +: list

  val combine: List[Int] = List(2,4,6) ::: List(1,2,3)

  println(list2)
  println(combine)

  @tailrec
  def filter[A](input: List[A], output: List[A] = List())(fxn: A => Boolean): List[A] = input match {
    case _ if input.isEmpty => output
    case _ if fxn(input.head) => filter(input.tail, output :+ input.head)(fxn)
    case _ => filter(input.tail, output)(fxn)
  }
}
