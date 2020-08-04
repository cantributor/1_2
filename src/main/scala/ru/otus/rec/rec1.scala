package ru.otus.rec

import scala.annotation.tailrec

object rec1 {
  // 10!

  def factorialM(_i: Int): Long = {
    var res: Long = 1
    var i         = _i
    while (i > 1) {
      res = res * i
      i -= 1
    }
    res
  }

  def factorial1(i: Int): Long =
    if (i <= 1) 1
    else i * factorial1(i - 1)

  @tailrec
  def factorial(i: Int, acc: Long = 1): Long =
    if (i <= 1) acc
    else factorial(i - 1, acc * i)
}
