package org.obl.hb.css

import scala.language.implicitConversions
import scala.language.higherKinds

import org.obl.hb._

trait CssValue[+T] extends ValueRenderer

trait CssValueFactory[C[X] <: CssValue[X]] {
  def defaultFormatter[T]:T => String = (t:T) => AttributeRenderer.render(t)
  
  implicit def fromT[T](t:T):C[T] = create[T](Some(t), defaultFormatter)
  implicit def fromListT[T](t:List[T]):C[List[T]] = create[List[T]](Some(t), p => p.map(defaultFormatter(_)).mkString(" ") )
  def empty[T]:C[T] = create[T](None, defaultFormatter)

  protected def create[T](opt:Option[T], fmt:T => String):C[T]
}

object CssValue extends CssValueFactory[CssValue] {
  
  protected def create[T](opt:Option[T], fmt:T => String) = new CssVal(opt, fmt)
  def raw[T](str:String):CssValue[T] = new CssRawValue[T](str)
}

private[hb] class CssVal[T](v:Option[T], fmt:T => String) extends BaseOptionalValue[T](v,fmt) with CssValue[T] with WithNoneCssValue[T] with WithAutoCssValue[T] {
  protected def emptyValue = ""
}

private[hb] class CssRawValue[T](str:String) extends CssValue[Nothing] {
  def render = str
}

trait WithNoneCssValue[+T] extends CssValue[T]

object WithNoneCssValue extends CssValueFactory[WithNoneCssValue] {
  protected def create[T](opt:Option[T], fmt:T => String) = new CssVal(opt, fmt)
}

trait WithAutoCssValue[+T] extends CssValue[T]

object WithAutoCssValue extends CssValueFactory[WithAutoCssValue] {
  protected def create[T](opt:Option[T], fmt:T => String) = new CssVal(opt, fmt)
}

object inherit extends CssValue[Nothing] with WithNoneCssValue[Nothing] with WithAutoCssValue[Nothing] {
  def render = "inherit"
}

object none extends CssValue[Nothing] with WithNoneCssValue[Nothing] {
  def render = "none"
}

object auto extends CssValue[Nothing] with WithAutoCssValue[Nothing] {
  def render = "auto"
}