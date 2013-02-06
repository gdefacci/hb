package org.obl.hb.css

private[css] object HexUtils {
  def toHexString(i:Int):String = {
     if (i==0) "0"
     else if (i < 0) throw new UnsupportedOperationException("negative values not allowed")
     else {
		 val v:Int = i / 16
	     val r:Int = i % 16
	     val rest = if (v == 0) "" else toHexString(v)
	     rest + (r match {
		   case i if i < 9 => i.toString
		   case 10 => "A"
		   case 11 => "B"
		   case 12 => "C"
		   case 13 => "D"
		   case 14 => "E"
		   case 15 => "F"
		 }) 
     }
  }
  
  def main(args:Array[String]) {
    
    println(toHexString(0x343FED6))
  }
}
