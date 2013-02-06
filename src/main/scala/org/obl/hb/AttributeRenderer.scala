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
    else " " + attrKey(k, v) + attrEq(v) +  ValueRenderer.quote(ValueRenderer.render(v)) // attrValue(v)
  }

  def attrs(mp: Map[String, Any]): String = {
    if (mp.isEmpty) ""
    else mp.toList.sortBy(_._1).map(e => attrPair(e._1, e._2)).mkString
  }
}
