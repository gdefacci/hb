package org.obl.hb

object DirEnum extends Enumeration {
  val ltr, rtl, auto = Value
}

object TranslateEnum extends Enumeration {
  val yes, no = Value
}

object InputTypeEnum extends Enumeration {
  val text, hidden, search, tel, url, email, password, datetime, date, month, week, time, datetime_local, number, range, color, checkbox, radio, file, submit, image, reset, button = Value
}

object AutocompleteEnum extends Enumeration {
  val on, off = Value
}

object EncTypeEnum extends Enumeration {
  val application_x_www_form_urlencoded = Value(0, "application/x-www-form-urlencoded")
  val multipart_form_data = Value(1, "multipart/form-data")
  val text_plain = Value(2, "text/plain")
}

object FormMethodEnum extends Enumeration {
  val get, post = Value
}

object RelLinkEnum extends Enumeration {
  val alternate, author, help, icon, license, next, prefetch, prev, search, stylesheet  = Value
}

object RelAreaAndAEnum extends Enumeration {
  val alternate ,author ,bookmark ,help ,license ,next ,nofollow ,noreferrer ,prefetch ,prev ,search ,tag = Value
}

object Size {
  def fromPair(p:(Int,Int)) = new Size(p._1, p._2)
}

class Size(width:Int, height:Int) extends OptionalValue with ValueRenderer {
  def isDefault = false
  def render: String = width+"x"+height
}

object ListMarkerTypeEnum extends Enumeration {
  val decimal 		= Value(0, "1")
  val lower_alpha	= Value(1, "a")
  val upper_alpha	= Value(2, "A")
  val lower_roman	= Value(3, "i")
  val upper_roman	= Value(4, "I")
}

object SandboxEnum extends Enumeration {
  val allow_forms, allow_same_origin, allow_scripts, allow_top_navigation = Value
}

object PreloadEnum extends Enumeration {
  val metadata, auto = Value
}

object TrackKindEnum extends Enumeration {
  val subtitles, captions, descriptions, chapters, metadata = Value
}

object ShapeEnum extends Enumeration {
  val rect, circle, default, poly = Value
}

object ThScopeEnum extends Enumeration {
  val auto, row, col, rowgroup, colgroup = Value
}

object InputModeEnum extends Enumeration {
  val verbatim, latin, latin_name, latin_prose, full_width_latin, kana, katakana, numeric, tel, email, url = Value
}

object ButtonTypeEnum extends Enumeration {
  val submit,reset,button,menu = Value 
}

object TextareaWrapNum extends Enumeration {
  val soft, hard = Value
}

object KeyTypeEnum extends Enumeration {
  var rsa = Value
}

object MenuTypeEnum extends Enumeration {
  val list, context, toolbar = Value
}

object CommandTypeEnum extends Enumeration {
  val command, checkbox, radio = Value
}

object CorsSettingsEnum extends Enumeration {
  val anonymous, use_credentials = Value
}