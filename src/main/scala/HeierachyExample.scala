object HeierachyExample extends App {

  class A

  class B(val a: A) extends AnyVal

  val a: Any = new A

  val array: Array[Int] = Array(1,2,3,4)

  val array1: Array[Boolean] = Array(true, false)

  val array2: Array[AnyVal] = Array(1,2,true, false)

  val array3: Array[A] = Array(new A, new A)
  val array4: Array[String] = Array("hello")

  val array5: Array[AnyRef] = Array(new A, "hello")

  val array6: Array[Any] = Array(1, true, new A, "hello")

  val a1: A = null

//  val a2: Int =  null
}
