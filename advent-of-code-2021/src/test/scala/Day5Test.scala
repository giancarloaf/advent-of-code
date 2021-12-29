import Day5._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Day5Test extends AnyFlatSpec with Matchers {
  val input =
    """0,9 -> 5,9
      |8,0 -> 0,8
      |9,4 -> 3,4
      |2,2 -> 2,1
      |7,0 -> 7,4
      |6,4 -> 2,0
      |0,9 -> 2,9
      |3,4 -> 1,4
      |0,0 -> 8,8
      |5,5 -> 8,2""".stripMargin

  "Part 1 example" should "contain 5 overlaps" in {
    countOverlaps(draw(parseInput(input.linesIterator.toSeq))) shouldEqual 5
  }

  "Part 1 solution" should "contain 5774 overlaps" in {
    part1solution shouldEqual 5774
  }

}
