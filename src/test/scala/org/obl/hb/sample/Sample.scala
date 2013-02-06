package org.obl.hb.sample

import scala.language.postfixOps

object Sample1 {
  
  import org.obl.hb._
  import org.obl.hb.Html._
  import org.obl.hb.css._
  
  val myHtmlDoc =
  
  html(_.lang="en")(
    head >>: link(_.rel = RelLinkEnum.stylesheet, _.href="css/mycss.css"),    
    (body % "myBodyClass") >>: 
      (div(_.style.padding_top = 60 px) :# "mydiv") (
    	"hello world")
  )
  
  def main(args:Array[String]):Unit = {
    println(myHtmlDoc().toXmlString(HtmlToString.pretty))
  }
  
}