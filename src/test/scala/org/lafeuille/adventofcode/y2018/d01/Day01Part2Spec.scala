package org.lafeuille.adventofcode.y2018.d01

import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{Matchers, WordSpec}

class Day01Part2Spec extends WordSpec with Matchers with TableDrivenPropertyChecks {

  "Sample input" should {

    val table = Table(
      ("First frequency", "Changes"),
      (0, List(1, -1)),
      (10, List(3, 3, 4, -2, -4)),
      (5, List(-6, 3, 8, 5, -6)),
      (14, List(7, 7, -2, -7, -4))
    )

    forAll(table) { (first, changes) =>
      s"reach $first twice with $changes changes" in {
        Day01Part2.firstFrequencyReachedTwice(Day01Part2.repeat(changes)) shouldBe first
      }
    }
  }

  "My input" should {
    val expected = 256
    s"reach $expected" in {
      Day01Part2.firstFrequencyReachedTwice(Day01Part2.repeat(Day01.numbers)) shouldBe expected
    }
  }


}
