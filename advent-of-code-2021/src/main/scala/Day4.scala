import scala.collection.mutable.ListBuffer
import scala.io.Source
import scala.util.Random

object Day4 {
  def solutionPart1: Int = {
    val (draws, cards) = parseInput
    scoreFirstWinner(draws, cards)
  }

  def solutionPart2: Int = {
    val (draws, cards) = parseInput
    scoreLastWinner(draws, cards)
  }

  private def parseInput: (List[Int], Seq[Card]) = {
    val input = Source.fromResource("day4").getLines().toSeq
    val draws = input.head.split(",").map(_.toInt).toList
    val cards = input.tail
      .grouped(6)
      .map(lines =>
        Card(lines.tail.flatMap(line =>
          line.trim.split("""\s+""").map(_.toInt)
        ): _*)
      ).toSeq

    (draws, cards)
  }

  def scoreLastWinner(draws: List[Int], cards: Seq[Card]): Int = {
    val game = new Game(draws)
    var winners = Seq.empty[Card]

    while (winners.size != cards.size) {
      game.drawNumber
      winners = winners ++ (cards.toSet -- winners).filter(_.hasWon(game.drawnNumbers))
    }

    val sumWinner = winners.last.sumUnmarked(game.drawnNumbers)
    val lastBall = game.drawnNumbers.last
    sumWinner * lastBall
  }

  def scoreFirstWinner(draws: List[Int], cards: Seq[Card]): Int = {
    val game = new Game(draws)
    var winners = Seq.empty[Card]

    while (winners.isEmpty) {
      game.drawNumber
      winners = cards.filter(_.hasWon(game.drawnNumbers))
    }

    val sumWinner = winners.head.sumUnmarked(game.drawnNumbers)
    val lastBall = game.drawnNumbers.last
    sumWinner * lastBall
  }

  case class Card(values: Int*) {
    private final val rows, cols = 5

    private val valuesArray = intSeqToMultiArray(values: _*)

    def sumUnmarked(drawnNumbers: List[Int]): Int = {
      (values.toSet diff drawnNumbers.toSet).sum
    }

    def hasWon(drawnNumbers: List[Int]): Boolean = {
      // check rows and columns for drawn numbers
      (valuesArray ++ valuesArray.transpose).exists(row =>
        row.grouped(rows).exists(_.forall(drawnNumbers.contains))
      )
    }

    private def intSeqToMultiArray(values: Int*): Array[Array[Int]] = {
      val a: Array[Array[Int]] = Array.ofDim[Int](rows, cols)
      for {
        i <- 0 until rows
        j <- 0 until cols
      } a(i)(j) = values(Integer.parseInt(s"$i$j", 5))
      a
    }
  }

  class Game(numbers: List[Int] = Random.shuffle(1.to(75).toList)) {
    private val iter = numbers.iterator
    private val drawn = ListBuffer.empty[Int]

    def drawnNumbers: List[Int] = drawn.toList

    def drawNumber: Int = {
      val ball = iter.next()
      drawn += ball
      ball
    }
  }

}
