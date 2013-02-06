package org.obl.hb

trait OptionalValue {
  def isDefault: Boolean
}

trait ValueRenderer {
  def render: String
}


object ValueRenderer {
  
  import ObjMap.isDefault

  private val sq = "'"
  private val dq = "\""

  def quote(str: String) = {
    if (str.indexOf(dq) < 0) dq + str + dq
    else if (str.indexOf(sq) < 0) sq + str + sq
    else {
      dq + str.replaceAll("\"", "&quot;") + dq
    }
  }

  def render(a: Any): String = a match {
    case ar: ValueRenderer => ar.render
//    case x if isDefault(x) => "" // FIXME valutare se e' possbile rimuovere
    case s: String => s
    case s: Char => s.toString
    case x @ (_: Int, _: Short, _: Byte, _:Double, _:Float) => x.toString
    case _: Boolean => ""
    case x: Enumeration#Value => x.toString.replaceAll("_", "-")
    case x => x.toString
  }

}

abstract class BaseOptionalValue[T](_value: Option[T], formatter: T => String) extends OptionalValue with ValueRenderer {
  def isDefault = _value.isEmpty
  protected def value = _value.get
  def render: String = _value.map(formatter(_)).getOrElse(emptyValue)
  protected def emptyValue:String
}

