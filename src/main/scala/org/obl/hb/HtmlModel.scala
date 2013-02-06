package org.obl.hb

sealed trait HtmlModel {
  def append(ch: HtmlModel): HtmlModel
  
  def toXmlString(sh:HtmlModel => String = HtmlToString.raw):String = sh(this)

}

sealed trait ElementsContainer extends HtmlModel {
  def children: List[HtmlModel]

  def withChildren(ch: List[HtmlModel]): ElementsContainer

  def append(ch: HtmlModel) = withChildren(children ++ (ch match {
    case ElemSeq(elems) => elems
    case x => Seq(x)
  }))
}

case class Elem(name: String, attributes: Map[String, Any] = Map.empty, children: List[HtmlModel] = Nil) extends ElementsContainer {
  def withChildren(ch: List[HtmlModel]) = new Elem(name, attributes, ch)
  
  def toXml[T](sh:ToXmlAdapter[T] = adapters.ToScalaXml):T = sh(this)
}

case class ElemSeq(children: List[HtmlModel]) extends ElementsContainer {
  def withChildren(ch: List[HtmlModel]) = new ElemSeq(ch)
}
case class Text(text: String) extends HtmlModel {
  def append(ch: HtmlModel) = ElemSeq(List(this) ++ (ch match {
    case ElemSeq(elems) => elems
    case x => Seq(x)
  }))
}

object HtmlOp {

  def flatten(l: List[HtmlModel]): List[HtmlModel] = {
    l.flatMap { itm =>
      itm match {
        case ElemSeq(chs) => flatten(chs)
        case x => x :: Nil
      }
    }
  }

  val lAppend: (HtmlModel, HtmlModel) => HtmlModel = { (o, v) =>
    val elst = v match {
      case ElemSeq(nds) => nds
      case x => x :: Nil
    }
    o match {
      case t: Text => ElemSeq(t :: elst)
      case es @ ElemSeq(nds) => es.copy(children = nds ::: elst)
      case el @ Elem(_, _, nds) => el.copy(children = nds ::: elst)
    }
  }

  private val htmlEntitiesMap = Map(
    "\"" -> "quot",
    "&" -> "amp",
    "'" -> "apos",
    "<" -> "lt",
    ">" -> "gt")
  
  def replaceWithHtmlEntities(istr:String):String = {
    var str:String = istr
    htmlEntitiesMap.foreach { e =>
      if (str.contains(e._1)) {
        str = str.replaceAll(e._1, "&"+e._2+";")  
      }
    }
    str
  }
  
  def replaceHtmlEntities(istr:String):String = {
    var str:String = istr
    htmlEntitiesMap.foreach { e =>
      val entStr = "&"+e._2+";"
      if (str.contains(entStr)) {
        str = str.replaceAll(entStr, e._1)  
      }
    }
    str
  }

}