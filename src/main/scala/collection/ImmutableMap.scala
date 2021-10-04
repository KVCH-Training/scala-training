package collection

object ImmutableMap extends App {

  val map = Map(1 -> "Arun", 2 -> "Arun", (3, "Anil"), (3, "Sumeet"))

  println(map)

  println(map(2))

  map.get(7) match {
    case Some(value) => println(value)
    case None => println("Not found")
  }

  map.foreach(f => println(f._1, f._2))

  map.foreach(f => f match {
    case (key, value) => println(key, value)
  })

  map.foreach {
    case (key, value) =>
    println(key, value)
  }

  map.foreach(println)

  val keys: Iterable[Int] = map.keys
  val values: Iterable[String] = map.values

  println(keys)
  println(values)
}
