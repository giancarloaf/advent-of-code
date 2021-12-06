import day2.{Point, carryOrders, solutionPart1}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class day2Test extends AnyFlatSpec with Matchers {

  "Translating up 1" should "make y negative" in {
    Point(0,0).move("up", 1) shouldEqual new Point(0, -1)
  }

  "Translating down 1" should "make y positive" in {
    Point(0,0).move("down", 1) shouldEqual new Point(0, 1)
  }

  "Translating forward 1" should "make x positive" in {
    Point(0,0).move("forward", 1) shouldEqual new Point(1, 0)
  }

  "Moving up" should "decrease y" in {
    carryOrders(Seq("up 1")) shouldEqual new Point(0, -1)
  }

  "Moving down" should "increase y" in {
    carryOrders(Seq("down 1")) shouldEqual new Point(0, 1)
  }

  "Moving forward" should "increase x" in {
    carryOrders(Seq("forward 1")) shouldEqual new Point(1, 0)
  }

  "Movement example" should "end with x=15,y=10" in {
    val instructions = Seq(
      "forward 5",
      "down 5",
      "forward 8",
      "up 3",
      "down 8",
      "forward 2"
    )
    carryOrders(instructions) shouldEqual new Point(15, 10)
  }

  "Solution" should "multiply x=1890,y=1172 = 2215080" in {
    solutionPart1 shouldEqual 2215080
  }
}
