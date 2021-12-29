import scala.io.Source

object Day5 {
  def part1solution = {
    val input = Source.fromResource("day5").getLines().toSeq
    countOverlaps(draw(parseInput(input)))
  }

  def countOverlaps(diagram: Array[Array[Int]]): Int = {
    diagram.map(_.count(_ > 1)).sum
  }

  def draw(lines: Seq[Line]): Array[Array[Int]] = {
    val maxX = lines.flatMap(line => Seq(line.x1, line.x2)).max
    val maxY = lines.flatMap(line => Seq(line.y1, line.y2)).max
    val a = Array.fill[Int](maxX+1,maxY+1)(0)
    for {
      line <- lines
      if (line.x1 == line.x2) | (line.y1 == line.y2)
      x <- (line.x1 min line.x2) to (line.x1 max line.x2)
      y <- (line.y1 min line.y2) to (line.y1 max line.y2)
    } {
      println(line)
      a(x)(y) = a(x)(y) + 1
    }
    a.transpose
  }

  def parseInput(lines: Seq[String]): Seq[Line] = {
    val regex = """(\d+),(\d+) -> (\d+),(\d+)""".r
    lines.map {
      case regex(x1, y1, x2, y2) => Line(x1.toInt,y1.toInt,x2.toInt,y2.toInt)
    }
  }

  case class Line(x1: Int, y1: Int, x2: Int, y2:Int)
}
