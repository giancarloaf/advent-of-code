import scala.io.Source

object Day2 {

  def main(args: Array[String]): Unit = {
    println(solutionPart1)
    println(solutionPart2)
  }

  case class Point(x: Int, y: Int, a: Int = 0) {
    def move(direction: String, length: Int): Point = direction match {
      case "up" => this.copy(y = this.y - length)
      case "down" => this.copy(y = this.y + length)
      case "forward" => this.copy(x = this.x + length)
    }

    def moveAndAim(direction: String, length: Int): Point = direction match {
      case "up" => this.copy(a = this.a - length)
      case "down" => this.copy(a = this.a + length)
      case "forward" => this.copy(x = this.x + length, y = this.y + (this.a * length))
    }
  }

  def solutionPart1: Int = {
    val input = Source.fromResource("2/input").getLines().toSeq
    val destination = carryOrdersPart1(input)
    destination.x * destination.y
  }

  def carryOrdersPart1(instructions: Seq[String], start: Point = Point(0,0)): Point = {
    instructions
      .map(_.split(" ") match {
        case Array(x, y) => (x, y.toInt)
      })
      .foldLeft(start) {
        case (point, (direction, length)) => point.move(direction, length)
      }
  }

  def solutionPart2: Any = {
    val input = Source.fromResource("2/input").getLines().toSeq
    val destination = carryOrdersPart2(input)
    destination.x * destination.y
  }

  def carryOrdersPart2(instructions: Seq[String], start: Point = Point(0,0)): Point = {
    instructions
      .map(_.split(" ") match {
        case Array(x, y) => (x, y.toInt)
      })
      .foldLeft(start) {
        case (point, (direction, length)) => point.moveAndAim(direction, length)
      }
  }
}
