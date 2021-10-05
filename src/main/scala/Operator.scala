class Operator(val a: Int) {

  def *(operator: Operator): Operator = new Operator(this.a * operator.a)
}

object Operator extends App {

  val op: Operator = new Operator(23)
  val op1: Operator = new Operator(2)

  val p2 = op.*(op1)

  val op3: Operator = op * op1

  println(op3)
}
