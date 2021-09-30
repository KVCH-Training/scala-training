package caseclass

import java.io.{FileInputStream, FileOutputStream, ObjectInputStream, ObjectOutputStream}
import java.util.Objects

object CaseClassesExample extends App {

  class StudentNormal(val name: String, val rollNumber: Int) extends Product with Serializable {

    def copy(name: String = this.name, rollNumber: Int = this.rollNumber) =
      new StudentNormal(name, rollNumber)

    override def toString: String = s"StudentNormal($name,$rollNumber)"

    override def hashCode(): Int = Objects.hash(name, rollNumber)

    override def equals(o: Any): Boolean = o match {
      case obj if obj == null => false
      case studentNormal: StudentNormal =>
        studentNormal.name == name && studentNormal.rollNumber == rollNumber
      case _ => false
    }

    override def productArity: Int = 2

    override def productElement(n: Int): Any = n match {
      case 0 => name
      case 1 => rollNumber
      case _ => throw new IndexOutOfBoundsException
    }

    override def productElementName(n: Int): String = n match {
      case 0 => "name"
      case 1 => "rollNumber"
      case _ => throw new IndexOutOfBoundsException
    }

    override def canEqual(that: Any): Boolean = equals(that)
  }

  object StudentNormal {

    def apply(name: String, rollNumber: Int): StudentNormal = new StudentNormal(name, rollNumber)

    def unapply(arg: StudentNormal): Option[(String, Int)] = Option(arg) match {
      case Some(studentNormal: StudentNormal) => Some((studentNormal.name, studentNormal.rollNumber))
      case None => None
    }
  }

  // case class can not be able to inherit another case class but all rules of inheritance would remains the same
  case class StudentCase(name: String, rollNumber: Int) {

    def fullDetails = s"$name $rollNumber"
  }

  class A

  case class B()

  val studentNormal = new StudentNormal("Arun", 222)
  val studentCase = new StudentCase("Arun", 2222)

  println(studentCase.name, studentCase.rollNumber)
  println(studentNormal.name, studentNormal.rollNumber)

  val studentNormal1 = StudentNormal("Arun", 222)
  val studentCase1 = StudentCase("Arun", 2222)

  val StudentCase(nmeCase1, rollNumberCase1) = studentCase

  println(nmeCase1, rollNumberCase1)

  studentCase match {
    case StudentCase(name: String, rollNumber: Int) => println(name, rollNumber)
  }

  val StudentNormal(nmeNormal1, rollNumberNormal1) = studentNormal

  println(nmeCase1, rollNumberCase1)

  studentNormal match {
    case StudentNormal(name: String, rollNumber: Int) => println(name, rollNumber)
  }

  println(studentCase)
  println(studentNormal)

  println(studentCase.hashCode())
  println(studentCase1.hashCode())

  println(studentNormal.hashCode())
  println(studentNormal1.hashCode())

  val studentNormal2 = StudentNormal("Arun", 4222)

  println(studentNormal2.hashCode())

  println(studentCase.equals(studentCase1))
  println(studentNormal.equals(studentNormal1))

  println(">>>>>>>>>")

  for (nameOfParameters <- studentCase.productElementNames) {
    println(nameOfParameters)
  }

  println(">>>>>")

  println(studentCase.productArity)

  println(studentCase.productElementName(0))
  println(studentCase.productElementName(1))
//  println(studentCase.productElementName(2))

  println(">>>>")

  for (valueOfArg <- studentCase.productIterator) {
    println(valueOfArg)
  }

  println(">>>>")

  println(studentCase.productElement(0))
  println(studentCase.productElement(1))
  //  println(studentCase.productElementName(2))

  println(">>>>>>>>>")

  for (nameOfParameters <- studentNormal.productElementNames) {
    println(nameOfParameters)
  }

  println(">>>>>")

  println(studentNormal.productArity)

  println(studentNormal.productElementName(0))
  println(studentNormal.productElementName(1))
  //  println(studentCase.productElementName(2))

  println(">>>>")

  for (valueOfArg <- studentNormal.productIterator) {
    println(valueOfArg)
  }

  println(">>>>")

  println(studentNormal.productElement(0))
  println(studentNormal.productElement(1))
  //  println(studentCase.productElementName(2))

  println(">>>>")

  println(studentNormal.isInstanceOf[Product])
  println(studentCase.isInstanceOf[Product])

  val studentCase2: StudentCase = studentCase.copy("Anil", 121212)
  val studentCase3: StudentCase = studentCase.copy("22222")
  val studentCase4: StudentCase = studentCase.copy(rollNumber = 32323)

  println(studentCase3 + "{{{{{")

//  write[StudentCase](studentCase, "a.txt")

  val obj: StudentCase = read[StudentCase]("a.txt")

  println(obj)

//  write[StudentNormal](studentNormal, "b.txt")

  val obj1: StudentNormal = read[StudentNormal]("b.txt")

  println(obj1)

  def read[T](fileName: String): T = {

    val fis = new FileInputStream(fileName)
    val ois = new ObjectInputStream(fis)
    val obj = ois.readObject().asInstanceOf[T]
    ois.close()
    fis.close()
    obj
  }

  def write[T](obj: T, fileName: String): Unit = {

    val fos = new FileOutputStream(fileName)
    val oos = new ObjectOutputStream(fos)
    oos.writeObject(obj)
    oos.close()
    fos.close()
  }
}
