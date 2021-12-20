object Day3 {
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
    (~g).toBinaryString.takeRight(input.head.length)
  }
}
