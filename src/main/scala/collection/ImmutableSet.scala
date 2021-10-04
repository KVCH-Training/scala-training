package collection

import java.util
import java.util.Objects

import scala.collection.immutable.Set

object ImmutableSet extends App {

  val set: Set[Int] = Set(1,1,1,1,2,2,3,4)

  println(set)

  class Student(val name: String, val rollNumber: Int) {

    override def toString: String = s"Student($name,$rollNumber)"

    override def equals(o: Any): Boolean = o match {
      case student: Student => student.name == name && student.rollNumber == rollNumber
      case _ => false
    }

    override def hashCode(): Int = Objects.hash(name, rollNumber)
  }

  val set1 = Set(new Student("Arun", 1),
    new Student("Arun", 1),
    new Student("Arun", 2))

  val javaSet: util.HashSet[Student] = new util.HashSet[Student]()

  javaSet.add(new Student("Arun", 1))
  javaSet.add(new Student("Arun", 1))
  javaSet.add(new Student("Arun", 2))

  println(set1)

  println(javaSet)
}
