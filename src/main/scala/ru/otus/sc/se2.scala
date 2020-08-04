package ru.otus.sc

object se2 {

  sealed trait Option[+T]
  case object None                    extends Option[Nothing]
  final case class Some[+T](value: T) extends Option[T]

  def printIfAny[T](ot: Option[T]): Unit =
    ot match {
      case None        =>
      case Some(value) => println(value)
    }

  // TODO
  def extGetOrDefault[T](ot: Option[T], default: T): T = ???
}
