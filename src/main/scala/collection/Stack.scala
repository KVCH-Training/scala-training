package collection

object Stack {

  private final case class Node[T](element: T, next: Option[Node[T]] = None)

  def apply[T](): Stack[T] = new Stack()
}

final class Stack[T] private () extends Iterable[T]{

  import Stack._

  private var top: Option[Node[T]] = None

  def push(element: T): Unit = top match {
    case Some(stack) =>
      top = Some(Node(element, Some(stack)))
    case None =>
      top = Some(Node(element))
  }

  def pop(): Option[T] = top match {
    case Some(stack) =>
      val element = Some(stack.element)
      top = stack.next
      element
    case None => None
  }

  override def iterator: Iterator[T] = new Iterator[T] {

    private var start: Option[Node[T]] = top

    override def hasNext: Boolean = start.isDefined

    override def next(): T = {
      val element = start.get.element
      start = start.get.next
      element
    }
  }
}
