package ru.otus.rec

object rec2 {
  sealed trait List[+T] {
    def ::[H >: T](h: H): List[H] = Cons(h, this)
  }
  case object Nil                                 extends List[Nothing]
  final case class ::[+T](head: T, tail: List[T]) extends List[T]
  val Cons = ::

  val l = 1 :: 2 :: 3 :: Nil

}
