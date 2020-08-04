package ru.otus.bn

object bn1 {
  sealed trait Option[+T]
  case object None                    extends Option[Nothing]
  final case class Some[+T](value: T) extends Option[T]

  def extGetOrDefault[T](ot: Option[T])(default: T): T =
    ot match {
      case None        => default
      case Some(value) => value
    }

  val v = extGetOrDefault(Some(1)) {
    println("abc")
    2
  }

  def extGetOrElse[T](ot: Option[T])(default: () => T): T =
    ot match {
      case None        => default()
      case Some(value) => value
    }

  extGetOrElse(Some(1))(() => 0)

  def extGetOrElse1[T](ot: Option[T])(default: => T): T =
    ot match {
      case None        => default
      case Some(value) => value
    }

  extGetOrElse1(Some(1))(0)

}
