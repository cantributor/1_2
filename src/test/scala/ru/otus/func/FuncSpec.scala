package ru.otus.func

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers._
import ru.otus.func.f5._

class FuncSpec extends AnyFreeSpec {
  "func" - {
    "mapOption" - {
      "should return mapped option" in {
        mapOption(Some(2))(v => v * 2) should be(Some(4))
      }
      "should return None" in {
        mapOption(None)((v => v * 2): Int => Int) should be(None)
      }
    }
  }
}
