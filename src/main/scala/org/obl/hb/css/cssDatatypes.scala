package org.obl.hb.css

import scala.language.implicitConversions

import org.obl.hb._

trait BackgroundValue

case class Url(value: String) extends ValueRenderer with BackgroundValue {
  def render = "url(" + value + ")"
}

trait BackgroundPositionValue extends BackgroundValue

object BackgroundPositionValue {
  private def empty = new BackgroundPositionBuilder(Nil)

  val top = empty.top
  val center = empty.center
  val bottom = empty.bottom
  val left = empty.left
  val right = empty.right
}

class BackgroundPositionBuilder private[hb] (components: List[String]) extends ValueRenderer with BackgroundPositionValue {
  def top = new BackgroundPositionBuilder(components ::: "top" :: Nil)
  def center = new BackgroundPositionBuilder(components ::: "center" :: Nil)
  def bottom = new BackgroundPositionBuilder(components ::: "bottom" :: Nil)
  def left = new BackgroundPositionBuilder(components ::: "left" :: Nil)
  def right = new BackgroundPositionBuilder(components ::: "right" :: Nil)

  def render = components.mkString(" ")
}

object CssPos {
  def apply(p: (CssLengthOrPercentage, CssLengthOrPercentage)) = new CssPos(p._1, p._2)
}

class CssPos(_1: CssLengthOrPercentage, _2: CssLengthOrPercentage) extends BackgroundPositionValue with ValueRenderer {
  def render = _1.render + " " + _2.render
}

object BackgroundAttachmentEnum extends Enumeration {
  class Attachment(i: Int, name: String) extends Val(i, name) with BackgroundValue

  object Attachment {
    def apply(name: String) = new Attachment(nextId, name)
  }

  val scroll = Attachment("scroll")
  val fixed = Attachment("fixed")
}

object BackgroudRepeatEnum extends Enumeration {
  class Repeat(i: Int, name: String) extends Val(i, name) with BackgroundValue

  object Repeat {
    def apply(name: String) = new Repeat(nextId, name)
  }

  val repeat = Repeat("repeat")
  val repeat_x = Repeat("repeat-x")
  val repeat_y = Repeat("repeat-y")
  val no_repeat = Repeat("no-repeat")
}

object FontStyleEnum extends Enumeration {
  val normal, italic = Value
}

object FontVariantEnum extends Enumeration {
  val normal = Value
  val small_caps = Value("small-caps")
}

object FontWeightEnum extends Enumeration {
  val normal, bold = Value
}

object BorderCollapseEnum extends Enumeration {
  val collapse, separate = Value
}

trait BorderValue

object BorderStyleEnum extends Enumeration {
  class Border(i: Int, name: String) extends Val(i, name) with BorderValue

  object Border {
    def apply(name: String) = new Border(nextId, name)
  }

  val hidden = Border("hidden")
  val dotted = Border("dotted")
  val dashed = Border("dashed")
  val solid = Border("solid")
  val double = Border("double")
  val groove = Border("groove")
  val ridge = Border("ridge")
  val inset = Border("inset")
  val outset = Border("outset")
}

trait BorderWidthValue extends BorderValue

object BorderWidthEnum extends Enumeration {
  class Width(i: Int, name: String) extends Val(i, name) with BorderWidthValue

  object Width {
    def apply(name: String) = new Width(nextId, name)
  }

  val thin = Width("thin")
  val medium = Width("medium")
  val thick = Width("thick")
}

object CaptionSideEnum extends Enumeration {
  val top, bottom, left, right = Value
}

object ClearEnum extends Enumeration {
  val left, right, both = Value
}

object DisplayEnum extends Enumeration {
  val inline, block, compact, marker, table = Value 
  val run_in = Value("run-in"          )
  val list_item              = Value("list-item"          )
val inline_table           = Value("inline-table"       )
val table_row_group        = Value("table-row-group"    )
val table_header_group     = Value("table-header-group" )
val table_footer_group     = Value("table-footer-group" )
val table_row              = Value("table-row"          )
val table_column_group     = Value("table-column-group" )
val table_column           = Value("table-column"       )
val table_cell             = Value("table-cell"         )
val table_caption          = Value("table-caption"      )
}

object EmptyCellsEnum extends Enumeration {
  val show, hide = Value
}

object FloatEnum extends Enumeration {
  val left, right = Value
}

trait FontSizeValue

object FontSizeEnum extends Enumeration {
  class Size(i: Int, name: String) extends Val(i, name) with FontSizeValue

  object Size {
    def apply(name: String) = new Size(nextId, name)
  }

  val xx_small = Size("xx-small")
  val x_small = Size("x-small")
  val small = Size("small")
  val medium = Size("medium")
  val large = Size("large")
  val x_large = Size("x-large")
  val xx_large = Size("xx-large")
  val larger = Size("larger")
  val smaller = Size("smaller")

}

trait LetterSpacingValue

object LetterSpacingValue {
  object normal extends LetterSpacingValue with ValueRenderer {
    def render = "normal"
  }
}

trait LineHeightValue

object LineHeightValue {
  object normal extends LetterSpacingValue with ValueRenderer {
    def render = "normal"
  }
}

object ListStylePositionEnum extends Enumeration {
  val inside, outside = Value
}

object ListStyleTypeEnum extends Enumeration {
  val disc, circle, square, decimal, hebrew, armenian, georgian, hiragana, katakana = Value 
  val decimal_leading_zero  = Value("decimal-leading-zero")
val lower_roman           = Value("lower-roman")
val upper_roman           = Value("upper-roman")
val lower_greek           = Value("lower-greek")
val lower_alpha           = Value("lower-alpha")
val lower_latin           = Value("lower-latin")
val upper_alpha           = Value("upper-alpha")
val upper_latin           = Value("upper-latin")
val cjk_ideographic       = Value("cjk-ideographic")
val hiragana_iroha        = Value("hiragana-iroha")
val katakana_iroha        = Value("katakana-iroha")
}

object MarksEnum extends Enumeration {
  val crop, cross = Value
}

trait OutlineColorValue

object OutlineColorValue {
  object invert extends OutlineColorValue with ValueRenderer {
    def render = "invert"
  }
}

object OverflowEnum extends Enumeration {
  val visible, hidden, scroll = Value
}

object PageBreakEnum extends Enumeration {
  val always, avoid, left, right = Value
}

object PageBreakInsideEnum extends Enumeration {
  val avoid = Value
}

object CssPositionEnum extends Enumeration {

  val static, relative, absolute, fixed, inherit = Value

}

trait CssSizeValue

object CssSizeValue {
  implicit def fromLengthPair(p: (CssLength, CssLength)): CssSizeValue = new CssSizeValueImpl(p._1, p._2)
}

class CssSizeValueImpl(_1: CssLength, _2: CssLength) extends ValueRenderer with CssSizeValue {
  def render = _1.render + " " + _2.render
}

object CssSizeValueEnum extends Enumeration {
  class SizeValue(i: Int, name: String) extends Val(i, name) with CssSizeValue

  object SizeValue {
    def apply(name: String) = new SizeValue(nextId, name)
  }

  val portrait = SizeValue("portrait")
  val landscape = SizeValue("landscape")
}

object TableLayoutEnum extends Enumeration {
  val fixed = Value
}

//trait TextAlignValue
//
//object TextAlignValue {
//  implicit def fromString(str: String): TextAlignValue = new TextAlignValueImpl(str)
//}
//
//private[hb] class TextAlignValueImpl(str: String) extends TextAlignValue with ValueRenderer {
//  def render = AttributeRenderer.quote(str)
//}

object TextAlignEnum extends Enumeration {
  val left, right, center, justify = Value
  
  
//  class AlignValue(i: Int, name: String) extends Val(i, name) with TextAlignValue
//
//  object AlignValue {
//    def apply(name: String) = new AlignValue(nextId, name)
//  }

//  val left = AlignValue("left")
//  val right = AlignValue("right")
//  val center = AlignValue("center")
//  val justify = AlignValue("justify")

}

object TextDecorationEnum extends Enumeration {
  val underline, overline, blink = Value
  val line_through = Value("line-through")
}

object TextTransformEnum extends Enumeration {
  val capitalize, uppercase, lowercase = Value
}

trait VerticalAlignValue

object VerticalAlignValueEnum extends Enumeration {
  class AlignValue(i: Int, name: String) extends Val(i, name) with VerticalAlignValue

  object AlignValue {
    def apply(name: String) = new AlignValue(nextId, name)
  }

  val baseline = AlignValue("baseline")
  val sub = AlignValue("sub")
  val Super = AlignValue("super")
  val top = AlignValue("top")
  val text_top = AlignValue("text-top")
  val middle = AlignValue("middle")
  val bottom = AlignValue("bottom")
  val text_bottom = AlignValue("text-bottom")

}

object VisibilityEnum extends Enumeration {
  val visible, hidden, collapse = Value
}

trait WordSpacingValue

object WordSpacingValue {
  object normal extends WordSpacingValue with ValueRenderer {
    def render = "normal"
  }
}

object WhiteSpaceEnum extends Enumeration {
  val normal, pre, nowrap = Value
}

trait ElevationValue

object ElevationEnum extends Enumeration {
  class Elevation(i: Int, name: String) extends Val(i, name) with ElevationValue

  object Elevation {
    def apply(name: String) = new Elevation(nextId, name)
  }

  val below = Elevation("below")
  val level = Elevation("level")
  val above = Elevation("above")
  val higher = Elevation("higher")
  val lower = Elevation("lower")

}