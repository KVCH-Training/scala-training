import org.scalatest.freespec.AsyncFreeSpec
import org.scalatest.matchers.should.Matchers

class CalcSpec extends AsyncFreeSpec with Matchers {

  "it should add two numbers and producer result in future" in {

    Calc.add(1, 2).map(output => output should be(3))
  }
}
