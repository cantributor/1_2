package ru.otus.bn

import scala.annotation.tailrec

object bn2 {
  def factorialM(_i: Int): Long = {
    var res: Long = 1
    var i         = _i
    myWhile(i > 1) {
      res = res * i
      i -= 1
    }
    res
  }

  @tailrec
  def myWhile(cond: => Boolean)(body: => Unit): Unit = {
    if (cond) {
      body
      myWhile(cond)(body)
    } else ()
  }
}
