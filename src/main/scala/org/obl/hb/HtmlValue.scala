package org.obl.hb

import scala.language.implicitConversions

object HtmlValue {
  def defaultFormatter[T]:T => String = (t:T) => AttributeRenderer.render(t)
  
  implicit def fromT[T](t: T) = new HtmlValue[T](Some(t))
  def empty[T]:HtmlValue[T] = empty( defaultFormatter ) 		
  def empty[T](formatter: T => String) = new HtmlValue[T](None) 
}

class HtmlValue[T](_value: Option[T]) extends BaseOptionalValue(_value, (t:T) => AttributeRenderer.render(t)) {
  protected def emptyValue = ""
}

object ValuesSet {
  private def defaultFormatter[T]:T => String = (t:T) => AttributeRenderer.render(t)
  implicit def fromT[T](t:T) = fromTSet[T](Set(t))
  implicit def fromTSet[T](t:Set[T]) = new ValuesSet[T](t, defaultFormatter)
  
  def empty[T](f:T => String) = new ValuesSet[T](Set.empty,f)
  def empty[T]:ValuesSet[T] = empty[T](defaultFormatter)
}

class ValuesSet[T](set: Set[T], formatter: T => String, separator:String = " ") extends OptionalValue with ValueRenderer {
  def isDefault = set.isEmpty
  def render: String = set.map(formatter).mkString(separator)
}