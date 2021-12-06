import Day1.{countReductions, solutionPart1, solutionPart2}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Day1Test extends AnyFlatSpec with Matchers {
  "A single reduction" should "have a count of 1" in {
    countReductions(Seq(0, 1)) shouldEqual 1
  }

  "A mix of additions and reductions" should "only count reductions" in {
    countReductions(Seq(0, 1, 2, 1, 0)) shouldEqual 2
  }

  "The solution for Part One" should "equal 1446" in {
    solutionPart1 shouldEqual 1446
  }

  "Part 2 three-measurement sliding example" should "increase by 1" in {
    countReductions(Seq(199, 200, 208, 210), 3) shouldEqual 1
  }

  "The solution for Part Two" should "equal " in {
    solutionPart2 shouldEqual 1486
  }
}
