import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers

final class CalculatorSpec extends AnyFreeSpec with Matchers {

  "add" - {

    "it should add two numbers and produce result" in {

      Calculator.add(1, 2) should equal(3)
    }

    "it should produce unexpected result if int range is crossed" in {

      assert(Calculator.add(Int.MaxValue, 1) <= 0)
    }
  }
}
