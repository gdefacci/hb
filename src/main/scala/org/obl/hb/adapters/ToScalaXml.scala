package org.obl.hb.adapters

import org.obl.hb.{Elem => HElem, Text => HText, ElemSeq => HElemSeq, HtmlModel }
import org.obl.hb._
import org.obl.hb.AttributeRenderer
import scala.xml.MetaData
import scala.xml.UnprefixedAttribute
import org.obl.hb.ObjMap
import org.obl.hb.ValueRenderer

object ToScalaXml extends ToXmlAdapter[xml.Document] {
  
  def apply(e:HElem):xml.Document = {
	val doc = new xml.Document()
	
	val xel = elem(e);
	doc.docElem = xel
	doc
  }
  
  private def helem(m:HtmlModel):xml.NodeSeq = {
    m match {
      case HText(str) => xml.Text(str)
      case el:HElem => elem(el)
      case HElemSeq(chs) => chs.flatMap(helem(_))
    }
  } 
  
  private def elem(el:HElem):xml.Elem = {
    val chs = el.children.flatMap(helem(_))
    new xml.Elem(null, el.name, attributes(el.attributes.toSeq), xml.TopScope, true, chs:_*)
  }
  
  private def attributes(lst:Seq[(String,Any)]):MetaData = {
    if (lst.isEmpty) xml.Null
    else {
      val hd = lst.head
      val rest = lst.tail
      if (ObjMap.isDefault(hd._2)) attributes(rest)
      else new UnprefixedAttribute(AttributeRenderer.attrKey(hd._1, hd._2), ValueRenderer.render(hd._2), attributes(rest))
    }
  }
  
  
}

