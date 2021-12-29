import Day4._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Day4Test extends AnyFlatSpec with Matchers {
  //noinspection ScalaStyle
  val draws = List(7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1)
  val cards = Seq(
    Card(
      22,13,17,11,0
      ,8,2,23,4,24
      ,21,9,14,16,7
      ,6,10,3,18,5
      ,1,12,20,15,19
    ),
    Card(
      3,15,0,2,22
      ,9,18,13,17,5
      ,19,8,7,25,23
      ,20,11,10,24,4
      ,14,21,16,12,6
    ),
    Card(
      14,21,17,24,4,
      10,16,15,9,19,
      18,8,23,26,20,
      22,11,13,6,5,
      2,0,12,3,7
    )
  )

  val game = new Game(draws.toList)


  "Part 1 example" should "produce a score of 4512" in {
    score(draws, cards) shouldEqual 4512
  }

  "Part 1 solution" should "produce a score of 33462" in {
    val s = solutionPart1
    solutionPart1 shouldEqual 0
  }
}
