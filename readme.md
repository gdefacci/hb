# hb

hb is a scala DSL for generating html5 code.
The program:

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
    
will produce:

    <html lang="en">
	  <head><link href="css/mycss.css" rel="stylesheet"/></head>
	  <body class="myBodyClass"><div id="mydiv" style="padding-top:60px">hello world</div></body>
	</html>


