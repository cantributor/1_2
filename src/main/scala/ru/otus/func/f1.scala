package ru.otus.func

import scala.annotation.tailrec

object f1 {
  sealed trait List[+T] {
    def ::[H >: T](h: H): List[H] = Cons(h, this)
  }
  case object Nil                                 extends List[Nothing]
  final case class ::[+T](head: T, tail: List[T]) extends List[T]
  val Cons = ::

  @tailrec
  def reverse[T](l: List[T], acc: List[T] = Nil): List[T] =
    l match {
      case Nil          => acc
      case head :: tail => reverse(tail, head :: acc)
    }

  val l = 1 :: 2 :: 3 :: Nil

  // def incList [1, 2, 3] => [2, 3, 4]

  def incList(l: List[Int]): List[Int] = {
    @tailrec
    def inner(l: List[Int], acc: List[Int]): List[Int] =
      l match {
        case Nil            => acc
        case ::(head, tail) => inner(tail, (head + 1) :: acc)
      }

    reverse(inner(l, Nil))
  }

  def shoutList(l: List[Int]): List[String] = {
    @tailrec
    def inner(l: List[Int], acc: List[String]): List[String] =
      l match {
        case Nil            => acc
        case ::(head, tail) => inner(tail, s"$head!" :: acc)
      }

    reverse(inner(l, Nil))
  }

  trait Converter[-T, +R] {
    def apply(t: T): R
  }

  def mapList[T, R](l: List[T])(f: Converter[T, R]): List[R] = {
    @tailrec
    def inner(l: List[T], acc: List[R]): List[R] =
      l match {
        case Nil            => acc
        case ::(head, tail) => inner(tail, f(head) :: acc)
      }

    reverse(inner(l, Nil))
  }

  mapList(l) { t =>
    s"$t!"
  }

}
