import scala.io.Source

object day1 {
  def main(args: Array[String]): Unit = {
    println(solution)
  }

  def solution: Int = {
    val input = Source.fromResource("1/input").getLines().map(_.toInt).toSeq
    countReductions(input)
  }

  def countReductions(input: Seq[Int]): Int = {
    input.zip(input.tail)
      .map{ case (l,r) => r > l }
      .count(_ == true)
  }
}
