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
    Stream.continually(Day01.numbers.toStream).flatten

  def firstFrequencyReachedTwice(changes: Stream[Int]): Int = ???

  println(firstFrequencyReachedTwice(repeat(Day01.numbers)))
}
