package org.lafeuille.adventofcode.y2018.d02

import scala.io.Source
import scala.io.Source.fromURL

object Day02 {

  def myInput: Source =
    fromURL(getClass.getResource("input.txt"))

  def lines: List[Array[Char]] =
    myInput.getLines.map(_.toCharArray).toList

}

object Day02Part1 extends App {

  def checksum(lines: List[Array[Char]]) = {
    def foobar(lines: List[Array[Char]]) =
      lines.map(_.groupBy(c => c).mapValues(_.length))

    def counting(groups: Seq[Map[Char, Int]], appearance: Int) =
      groups.count(_.exists { case (_, i) => i == appearance })

    val groups = foobar(lines)
    val twiceCount = counting(groups, 2)
    val thriceCount = counting(groups, 3)
    twiceCount * thriceCount
  }

  println(checksum(Day02.lines))

}
