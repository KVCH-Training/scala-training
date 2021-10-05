package collection

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object MutablilityArrayBuffer extends App {

  val arrayBuffer = ArrayBuffer(1,2,3,4,5)

  var mutableList = List(1,2,3,4)

  mutableList = mutableList :+ 23

  println(arrayBuffer)

  arrayBuffer += 45

  arrayBuffer.addOne(21212)

  println(arrayBuffer)

  val mutableSet = mutable.HashSet(1,2,2,2,23)

  val set: Set[Int] = mutableSet.toSet

  val hashMap = mutable.Map(1 -> "asas")

  val map = hashMap.toMap
}
