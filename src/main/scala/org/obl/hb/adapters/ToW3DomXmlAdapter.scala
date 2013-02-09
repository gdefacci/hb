package org.obl.hb.adapters

import org.obl.hb.{ToXmlAdapter, Elem, Text, ElemSeq, HtmlModel}
import org.obl.hb.AttributeRenderer.render
import javax.xml.parsers.DocumentBuilderFactory

import org.w3c.dom._

object ToW3DomXmlAdapter extends ToXmlAdapter[Document] {

  private lazy val docBldr = DocumentBuilderFactory.newInstance().newDocumentBuilder()
  
  def apply(el:Elem):Document = {
    val doc = docBldr.newDocument()
    val wel = apply(doc, el)
    doc.appendChild(wel)
    doc
  }
  
  def append(doc:Document, par:Element, itm:HtmlModel):Unit = {
	itm match {
	  case el:Elem => par.appendChild( apply(doc,el) )
	  case Text(str) => par.appendChild( doc.createTextNode(str) )
	  case ElemSeq(itms) => itms.foreach { ch =>
	    append(doc,par,ch)
	  }
	}  
  }
  
  def apply(doc:Document, elem:Elem):Element = {
    val el = doc.createElement(elem.name)
    elem.attributes.foreach { attr =>
      el.setAttribute(attr._1, render(attr._2))
    }
    elem.children.foreach { ch =>
      append(doc, el, ch)
    }
    el
  }
  
}

object XmlBuildTest {
  
  def main(Args:Array[String]):Unit = {
    val docBldr = DocumentBuilderFactory.newInstance().newDocumentBuilder()
    val doc = docBldr.newDocument
    val el = doc.createElement("div")
    el.setAttribute("att1", "v1")
 
    println(el)
    println(el.getAttribute("att1"))
  }
}