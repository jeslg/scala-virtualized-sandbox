package org.hablapps

import scala.language.implicitConversions

object DSL {

  case class Wrap[A](value: A)

  def __ifThenElse[A](
      cond: Wrap[Boolean], 
      thenp: => Wrap[A], 
      elsep: => Wrap[A]): Wrap[A] =
    cond match { 
      case Wrap(true) => thenp
      case _ => elsep
    }

  implicit def liftV[A](v: A): Wrap[A] = Wrap(v)
}

import DSL._

object HelloWorld extends App {
  println((
    if (true) "Hello World!" else "error"
  ).value)
}

