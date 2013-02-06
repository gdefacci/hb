package org.obl.hb

object HtmlToString extends HtmlToString("") {
  
  def raw = new HtmlToString("")
  def pretty = new HtmlToString("  ")

}

class HtmlToString(val indentString:String) extends (HtmlModel => String){

  def apply(hm:HtmlModel):String = {
    apply("", hm)
  }
  
  import AttributeRenderer._
  
  private def isSingleLine(h:HtmlModel):Boolean = h match {
	case Text(_) => true
	case Elem(_,_,Nil) => true
	case Elem(_,_,List(el)) if (isSingleLine(el))=> true
	case ElemSeq(Nil) => true
	case ElemSeq(List(el)) if (isSingleLine(el))=> true
	case _ => false
  }
  
  def apply(indent:String, hm:HtmlModel):String = {
    val nextIndent:String = indent+indentString
    val lf =  if (indentString.length == 0) "" else "\n"
    hm match {
      case Text(str) => HtmlOp.replaceWithHtmlEntities(str)
      case Elem(nm, attributes, Nil) => {
        "<"+nm+attrs(attributes)+"/>"
      }
      case Elem(nm, attributes, List(el)) if isSingleLine(el) => {
        "<"+nm+attrs(attributes)+">"+apply("", el)+"</"+nm+">"
      }
      case Elem(nm, attributes, chs) => {
        lazy val children = lf+chs.map( apply(nextIndent, _) ).map(str => nextIndent+str+lf).mkString+indent
        "<"+nm+attrs(attributes)+">"+(if(chs.nonEmpty)children else "")+"</"+nm+">"
      }
      case ElemSeq(elems) => elems.map(apply(indent, _)).mkString(lf) 
    }
    
  }
}