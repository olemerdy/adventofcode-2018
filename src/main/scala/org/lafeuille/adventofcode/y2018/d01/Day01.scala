package org.lafeuille.adventofcode.y2018.d01

import scala.io.Source
import scala.io.Source.fromURL

object Day01 {

  def myInput: Source =
    fromURL(getClass.getResource("input.txt"))

  def numbers: List[Int] =
    myInput.getLines.map(_.toInt).toList
}

object Day01Part1 extends App {

  def compute(changes: List[Int]): Int =
    changes.sum

  println(compute(Day01.numbers))

}

object Day01Part2 extends App {

  def repeat(numbers: List[Int]): Stream[Int] =
    Stream.continually(numbers.toStream).flatten

  def firstFrequencyReachedTwice(changes: Stream[Int]): Int = {
    def rec(changes: Stream[Int], current: Int, previous: Set[Int]): Int =
      changes match {
        case x #:: _ if previous.contains(current + x) => current + x
        case x #:: xs => rec(xs, current + x, previous + current)
      }

    rec(changes, 0, Set(0))
  }

  println(firstFrequencyReachedTwice(repeat(Day01.numbers)))
}
