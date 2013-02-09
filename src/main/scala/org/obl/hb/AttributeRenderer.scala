package org.obl.hb

object AttributeRenderer {
  private val sq = "'"
  private val dq = "\""

  import ObjMap.isDefault

  def attrKey(k: String, v: Any): String = {
    v match {
      case x if isDefault(x) => ""
      case x =>
        k.replaceAll("_", "-")
    }
  }

  private def attrEq(v: Any): String = v match {
    case x if isDefault(x) => ""
    case _ => "="
  }

  private def attrPair(k: String, v: Any) = {
    if (isDefault(v)) ""
    else " " + attrKey(k, v) + attrEq(v) +  quote(render(v)) // attrValue(v)
  }

  def attrs(mp: Map[String, Any]): String = {
    if (mp.isEmpty) ""
    else mp.toList.sortBy(_._1).map(e => attrPair(e._1, e._2)).mkString
  }

  def quote(str: String) = {
    if (str.indexOf(dq) < 0) dq + str + dq
    else if (str.indexOf(sq) < 0) sq + str + sq
    else {
      dq + str.replaceAll("\"", "&quot;") + dq
    }
  }

  def render(a: Any): String = a match {
    case ar: ValueRenderer => ar.render
    case _: Boolean => ""
    case x => x.toString
  }

}
