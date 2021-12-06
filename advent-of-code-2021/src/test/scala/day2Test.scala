import day2._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class day2Test extends AnyFlatSpec with Matchers {

  "Moving up 1" should "make y negative" in {
    Point(0,0).move("up", 1) shouldEqual Point(0, -1)
  }

  "Moving down 1" should "make y positive" in {
    Point(0,0).move("down", 1) shouldEqual Point(0, 1)
  }

  "Moving forward 1" should "make x positive" in {
    Point(0,0).move("forward", 1) shouldEqual Point(1, 0)
  }

  "Ordering up" should "decrease y" in {
    carryOrdersPart1(Seq("up 1")) shouldEqual Point(0, -1)
  }

  "Ordering down" should "increase y" in {
    carryOrdersPart1(Seq("down 1")) shouldEqual Point(0, 1)
  }

  "Ordering forward" should "increase x" in {
    carryOrdersPart1(Seq("forward 1")) shouldEqual Point(1, 0)
  }

  "Part 1 example" should "end with x=15,y=10" in {
    val instructions = Seq(
      "forward 5",
      "down 5",
      "forward 8",
      "up 3",
      "down 8",
      "forward 2"
    )
    carryOrdersPart1(instructions) shouldEqual Point(15, 10)
  }

  "Part 1 solution" should "multiply x=1890,y=1172 = 2215080" in {
    solutionPart1 shouldEqual 2215080
  }

  "Part 2 example" should "end with x=15,y=60" in {
    val instructions = Seq(
      "forward 5",
      "down 5",
      "forward 8",
      "up 3",
      "down 8",
      "forward 2"
    )
    carryOrdersPart2(instructions) shouldEqual Point(15, 60, 10)
  }

  "Part 2 solution" should "multiply x=1890,y=986622 = 1864715580" in {
    solutionPart2 shouldEqual 1864715580
  }
}
