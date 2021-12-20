import scala.io.Source

object Day3 {
  def solutionPart1: Int = {
    val input = Source.fromResource("3/input").getLines().toSeq
    powerConsumption(input)
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
