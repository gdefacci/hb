package org.obl.hb.css

import scala.language.implicitConversions

import org.obl.hb.ValueRenderer
import org.obl.hb.ValueRenderer

object `package` {
  implicit def intToCssLenFactory(i: Int): CssLengthFactory = new CssIntLengthFactory(i)
  implicit def doubleToCssLenFactory(i: Double): CssLengthFactory = new CssDoubleLengthFactory(i)

  implicit def intToCssAngleFactory(i: Int): CssAngleFactory = new CssIntAngleFactory(i)
  implicit def doubleToCssAngleFactory(i: Double): CssAngleFactory  = new CssDoubleAngleFactory(i)
  
  implicit def intToCssNumber(i: Int): CssIntNumber = new CssIntNumberImpl(i)
  implicit def doubleToCssNumber(i: Double): CssNumber = new CssDoubleNumber(i)
  
}

object CssLengthUnit extends Enumeration {
  val em, ex, px, in, cm, mm, pt, pc = Value
}

trait CssLengthFactory {
  protected def lengthFactory(u: CssLengthUnit.Value): CssLength
  protected def percentFactory: PercentCssLength

  def em: CssLength = lengthFactory(CssLengthUnit.em)
  def ex: CssLength = lengthFactory(CssLengthUnit.ex)
  def px: CssLength = lengthFactory(CssLengthUnit.px)
  def in: CssLength = lengthFactory(CssLengthUnit.in)
  def cm: CssLength = lengthFactory(CssLengthUnit.cm)
  def mm: CssLength = lengthFactory(CssLengthUnit.mm)
  def pt: CssLength = lengthFactory(CssLengthUnit.pt)
  def pc: CssLength = lengthFactory(CssLengthUnit.pc)
  def %% : PercentCssLength = percentFactory
}

private[css] class CssDoubleLengthFactory(i: Double) extends CssLengthFactory {
  protected def lengthFactory(u: CssLengthUnit.Value): CssLength = new CssLengthValue[Double](i, u)
  protected def percentFactory: PercentCssLength = new PercentCssDoubleLengthImpl(i)

}

private[css] class CssIntLengthFactory(i: Int) extends CssLengthFactory {
  protected def lengthFactory(u: CssLengthUnit.Value): CssLength = new CssLengthValue[Int](i, u)
  protected def percentFactory: PercentCssLength = new PercentCssIntLengthImpl(i)

}



trait CssLength extends ValueRenderer with CssLengthOrPercentage with BorderWidthValue with FontSizeValue with LetterSpacingValue with LineHeightValue with VerticalAlignValue with WordSpacingValue

trait PercentCssLength extends ValueRenderer with CssLengthOrPercentage with FontSizeValue with LineHeightValue with VerticalAlignValue

trait CssNumber extends ValueRenderer with LineHeightValue
trait CssIntNumber extends CssNumber

private[css] class CssDoubleNumber(v: Double) extends CssNumber {
  def render = v.toString
}

private[css] class CssIntNumberImpl(v: Int) extends CssIntNumber {
  def render = v.toString
}

private[css] final class CssLengthValue[N](i: N, lunit: CssLengthUnit.Value) extends CssLength {
  def render = i.toString + lunit.toString
}

private[css] final class PercentCssDoubleLengthImpl(i: Double) extends PercentCssLength {
  assert(i >= 0 && i < 100, "invalid percent value:" + i)
  def render: String = i + "%"
}

private[css] final class PercentCssIntLengthImpl(i: Int) extends PercentCssLength {
  assert(i >= 0 && i < 100, "invalid percent value:" + i)
  def render: String = i + "%"
}

trait CssLengthOrPercentage extends ValueRenderer

object CssAngleUnit extends Enumeration {
  val deg, grad, rad = Value
}

trait CssAngle extends ValueRenderer with ElevationValue

private[css] class CssDoubleAngle(value:Double, angleUnit:CssAngleUnit.Value) extends CssAngle {
  def render = value+angleUnit.toString
}

private[css] class CssIntAngle(value:Int, angleUnit:CssAngleUnit.Value) extends CssAngle {
  def render = value+angleUnit.toString
}

trait CssAngleFactory {
  protected def angleFactory(u: CssAngleUnit.Value): CssAngle

  def deg = angleFactory(CssAngleUnit.deg)
  def grad = angleFactory(CssAngleUnit.grad) 
  def rad = angleFactory(CssAngleUnit.rad)
}

private[css] class CssIntAngleFactory(i:Int) extends CssAngleFactory {
  protected def angleFactory(u: CssAngleUnit.Value): CssAngle = new CssIntAngle(i,u)
}

private[css] class CssDoubleAngleFactory(i:Double) extends CssAngleFactory {
  protected def angleFactory(u: CssAngleUnit.Value): CssAngle = new CssDoubleAngle(i,u)
}