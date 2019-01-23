package org.lafeuille.adventofcode.y2018.d01

import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{Matchers, WordSpec}

class Day01Part1Spec extends WordSpec with Matchers with TableDrivenPropertyChecks {

  "Sample input" should {

    val table = Table(
      ("Frequency", "Changes"),
      (3, List(1, 1, 1)),
      (0, List(1, 1, -2)),
      (-6, List(-1, -2, -3)),
    )

    forAll(table) { (frequency, changes) =>
      s"frequency $frequency with $changes changes" in {
        Day01Part1.compute(changes) shouldBe frequency
      }
    }
  }

  "My input" should {
    val expected = 433
    s"reach $expected" in {
      Day01Part1.compute(Day01.numbers) shouldBe expected
    }
  }

}
