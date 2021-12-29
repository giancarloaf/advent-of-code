import scala.io.Source

object Day3 {
  def main(args: Array[String]): Unit = {
    println(s"Day 3 Part 1 solution: ${solutionPart1}")
    println(s"Day 3 Part 2 solution: ${solutionPart2}")
  }

  def solutionPart2: Int = {
    val input = Source.fromResource("day3").getLines().toSeq
    lifeSupportRating(input)
  }

  def solutionPart1: Int = {
    val input = Source.fromResource("day3").getLines().toSeq
    powerConsumption(input)
  }

  def lifeSupportRating(input: Seq[String]): Int = {
    val o2 = Integer.parseInt(oxygenGeneratorRating(input), 2)
    val co2 = Integer.parseInt(c02ScrubberRating(input), 2)
    o2 * co2
  }

  def c02ScrubberRating(input: Seq[String]): String = {
    commonValuesByBits(input, mostSignificantValue = '0', leastSignificantValue = '1')
  }

  def oxygenGeneratorRating(input: Seq[String]): String = {
    commonValuesByBits(input, mostSignificantValue = '1', leastSignificantValue = '0')
  }

  // helper method
  private def commonValuesByBits(input: Seq[String], mostSignificantValue: Char, leastSignificantValue: Char): String = {
    val ret = (0 until input.head.length).foldLeft(input) {
      // iterate while there are still items remaining
      case (intermediate, i) if intermediate.size > 1 =>
        val ones = intermediate.map(_.toCharArray.map(_.asDigit)).transpose.map(_.sum)
        val zeros = ones.map(o => intermediate.length - o)
        intermediate.filter(_(i) == (if (ones(i) >= zeros(i)) mostSignificantValue else leastSignificantValue))
      // return early if only one value remaining
      case (intermediate, _) => intermediate
    }
    ret.head
  }

  def powerConsumption(input: Seq[String]): Int = {
    val g = Integer.parseInt(gamma(input), 2)
    val e = Integer.parseInt(epsilon(input), 2)
    g * e
  }

  def gamma(input: Seq[String]): String = {
    // transpose columns to rows
    val transposed = input.map(_.toCharArray.map(_.asDigit)).transpose
    // half the length of all measurements
    val midpoint = transposed.head.length / 2
    // bit frequency
    transposed.map(e => if (e.sum > midpoint) 1 else 0).mkString
  }

  def epsilon(input: Seq[String]): String = {
    val g = Integer.parseInt(gamma(input), 2)
    // ones compliment to flip bits, then truncate to expected length
    (~g).toBinaryString.takeRight(input.head.length)
  }
}
