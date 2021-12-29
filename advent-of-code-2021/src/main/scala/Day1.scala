import scala.io.Source

object Day1 {
  def main(args: Array[String]): Unit = {
    print("solutions: ")
    println(
      Seq(solutionPart1, solutionPart2)
        .zipWithIndex
        .map(s=> s"part${s._1}=${s._2}")
        .mkString(",")
    )
  }

  def solutionPart1: Int = {
    val input = Source.fromResource("day1").getLines().map(_.toInt).toSeq
    countReductions(input)
  }

  def solutionPart2: Int = {
    val input = Source.fromResource("day1").getLines().map(_.toInt).toSeq
    countReductions(input, 3)
  }

  def countReductions(input: Seq[Int], window: Int = 1): Int = {
    val slices: Seq[Seq[Int]] = input.sliding(window).toSeq
    slices.zip(slices.tail).count{ case (l,r) => r.sum > l.sum }
  }
}
