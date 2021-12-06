import day1.countReductions
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class day1Test extends AnyFlatSpec with Matchers {
  "A single reduction" should "have a count of 1" in {
      countReductions(Seq(0,1)) shouldEqual 1
  }

  "A mix of additions and reductions" should "only count reductions" in {
      countReductions(Seq(0,1,2,1,0)) shouldEqual 2
  }
}
