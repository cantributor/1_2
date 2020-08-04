package ru.otus.sc

object se1 {
  sealed trait Option[+T]
  final case class Some[+T](value: T) extends Option[T]
  case object None                    extends Option[Nothing]

  def printIfAny[T](op: Option[T]): Unit =
    op match {
      case Some(value) => println(value)
      case None        =>
    }
}
