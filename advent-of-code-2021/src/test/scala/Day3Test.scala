import Day3._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Day3Test extends AnyFlatSpec with Matchers {
  val input = Seq(
  "00100",
  "11110",
  "10110",
  "10111",
  "10101",
  "01111",
  "00111",
  "11100",
  "10000",
  "11001",
  "00010",
  "01010"
  )

  "Part 1 example" should "produce gamma binary of 10110" in {
    gamma(input) shouldEqual "10110"
  }
  it should "produce gamma decimal of 22" in {
    Integer.parseInt(gamma(input), 2) shouldEqual 22
  }
  it should "produce epsilon binary of 01001" in {
    epsilon(input) shouldEqual "01001"
  }
  it should "produce epsilon decimal of 9" in {
    Integer.parseInt(epsilon(input), 2) shouldEqual 9
  }
  it should "produce a power consumption of 198" in {
    powerConsumption(input) shouldEqual 198
  }

  "Part 1 solution" should "equal 3429254" in {
    solutionPart1 shouldEqual 3429254
  }

  "Part 2 example" should "produce oxygen generator rating binary of 10111" in {
    oxygenGeneratorRating(input) shouldEqual "10111"
  }
  it should "produce CO2 scrubber rating binary of 01010" in {
    c02ScrubberRating(input) shouldEqual "01010"
  }
  it should "produce a life support rating of 230" in {
    lifeSupportRating(input) shouldEqual 230
  }

  "Part 2 solution" should "equal 5410338" in {
    solutionPart2 shouldEqual 5410338
  }
}
