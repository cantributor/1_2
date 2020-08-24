package ru.otus.sc

import org.scalatest.freespec.AnyFreeSpec
import se2.{None, _}
import org.scalatest.matchers.should.Matchers._
import ru.otus.rec.rec3._

class Se2Spec extends AnyFreeSpec {
  "se2" - {
    "extGetOrDefault" - {
      "should return default value on None" in {
        extGetOrDefault(None, 666) should be(666)
      }

      "should return value on Some" in {
        extGetOrDefault(Some(13), 666) should be(13)
      }
    }
  }

  "rec3" - {
    "reverse" - {
      "should revert list" in {
        reverse(1 :: 2 :: 3 :: Nil) should be(3 :: 2 :: 1 :: Nil)
      }
    }
  }
}
