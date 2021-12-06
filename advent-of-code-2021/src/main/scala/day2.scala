import scala.io.Source

object day2 {

  def main(args: Array[String]): Unit = {
    println(solutionPart1)
  }

  case class Point(x: Int, y: Int) {
    def move(direction: String, length: Int): Point = direction match {
      case "up" => this.copy(y = this.y - length)
      case "down" => this.copy(y = this.y + length)
      case "forward" => this.copy(this.x + length)
    }
  }

  def solutionPart1: Int = {
    val input = Source.fromResource("2/input").getLines().toSeq
    val destination = carryOrders(input)
    destination.x * destination.y
  }

  def carryOrders(instructions: Seq[String], start: Point = Point(0,0)): Point = {
    instructions
      .map(_.split(" ") match {
        case Array(x, y) => (x, y.toInt)
      })
      .foldLeft(start) {
        case (point, (direction, length)) => point.move(direction, length)
      }
  }
}
