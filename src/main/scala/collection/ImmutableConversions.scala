package collection

object ImmutableConversions extends App {

  val list = List(1,2,2,2,2,3,3,3,4)

  println(list)

  val set: Set[Int] = list.toSet

  println(set)

  val list1: List[Int] = set.toList

  println(list1)

  val list2: List[(Int, String)] = List((1, "helo"), (2, "scala"), (2, "jaba"))

  val map: Map[Int, String] = list2.toMap

  println(list2)
  println(map)

  val list3: List[(Int, String)] = map.toList

  println(list2.toSet)
  println(list2.toMap)

  println(list2.toSet.toMap)
  println(map.toSet)

  println(Vector(1,2,3,4).toSet)
}
