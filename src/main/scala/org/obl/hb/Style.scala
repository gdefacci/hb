package org.obl.hb

import css._

final class Style extends OptionalAttributes[Style] {

  var color: CssValue[Color] = CssValue.empty

  var background = CssValue.empty[List[BackgroundValue]]
  
  var background_color: CssValue[Color] = CssValue.empty
  var background_image: WithNoneCssValue[Url] = WithNoneCssValue.empty 
  var background_repeat: CssValue[BackgroudRepeatEnum.Value] = CssValue.empty
  var background_attachment: CssValue[BackgroundAttachmentEnum.Value] = CssValue.empty
  var background_position: CssValue[BackgroundPositionValue] = CssValue.empty

  var border: CssValue[List[BorderValue]] = CssValue.empty
//  var border_style: String = _
//  var border_color: String = _
//
  var border_top: CssValue[List[BorderValue]] = CssValue.empty
  var border_right: CssValue[List[BorderValue]] = CssValue.empty
  var border_bottom: CssValue[List[BorderValue]] = CssValue.empty
  var border_left: CssValue[List[BorderValue]] = CssValue.empty
//
//  var border_width: String = _

  var border_collapse: CssValue[BorderCollapseEnum.Value] = CssValue.empty
  var border_top_color: CssValue[Color] = CssValue.empty
  var border_right_color: CssValue[Color] = CssValue.empty
  var border_bottom_color: CssValue[Color] = CssValue.empty
  var border_left_color: CssValue[Color] = CssValue.empty

  val border_top_style: WithNoneCssValue[BorderStyleEnum.Value] = WithNoneCssValue.empty
  val border_right_style: WithNoneCssValue[BorderStyleEnum.Value] = WithNoneCssValue.empty
  val border_bottom_style: WithNoneCssValue[BorderStyleEnum.Value] = WithNoneCssValue.empty
  val border_left_style: WithNoneCssValue[BorderStyleEnum.Value] = WithNoneCssValue.empty

  var border_top_width: CssValue[BorderWidthValue] = CssValue.empty
  var border_right_width: CssValue[BorderWidthValue] = CssValue.empty
  var border_bottom_width: CssValue[BorderWidthValue] = CssValue.empty
  var border_left_width: CssValue[BorderWidthValue] = CssValue.empty

  var bottom: WithAutoCssValue[CssLengthOrPercentage] = WithAutoCssValue.empty
  var caption_side: CssValue[CaptionSideEnum.Value] = CssValue.empty
  var clear: WithNoneCssValue[ClearEnum.Value] = WithNoneCssValue.empty

  var display: WithNoneCssValue[DisplayEnum.Value] = WithNoneCssValue.empty
  
  var elevation = CssValue.empty[ElevationValue]
  var empty_cells: CssValue[EmptyCellsEnum.Value] = CssValue.empty

  var float: WithNoneCssValue[FloatEnum.Value] = WithNoneCssValue.empty

  var font_family: CssValue[String] = CssValue.empty
  var font_style: CssValue[FontStyleEnum.Value] = CssValue.empty
  var font_variant: CssValue[FontVariantEnum.Value] = CssValue.empty
  var font_weight: CssValue[FontWeightEnum.Value] = CssValue.empty
  var font_size: CssValue[FontSizeValue] = CssValue.empty

//  var font: String = _

  var height: WithAutoCssValue[CssLengthOrPercentage] = WithAutoCssValue.empty
  var left: WithAutoCssValue[CssLengthOrPercentage] = WithAutoCssValue.empty
  var letter_spacing: WithAutoCssValue[LetterSpacingValue] = WithAutoCssValue.empty
  var line_height: WithAutoCssValue[LineHeightValue] = WithAutoCssValue.empty

  var list_style_image: WithNoneCssValue[String] = WithNoneCssValue.empty

  var list_style_position: CssValue[ListStylePositionEnum.Value] = CssValue.empty
  var list_style_type: WithNoneCssValue[ListStyleTypeEnum.Value] = WithNoneCssValue.empty

  var margin_top: WithAutoCssValue[CssLengthOrPercentage] = WithAutoCssValue.empty
  var margin_right: WithAutoCssValue[CssLengthOrPercentage] = WithAutoCssValue.empty
  var margin_bottom: WithAutoCssValue[CssLengthOrPercentage] = WithAutoCssValue.empty
  var margin_left: WithAutoCssValue[CssLengthOrPercentage] = WithAutoCssValue.empty

  var marker_offset: WithAutoCssValue[CssLength] = WithAutoCssValue.empty
  var marks: WithAutoCssValue[MarksEnum.Value] = WithAutoCssValue.empty
  var max_height: WithAutoCssValue[CssLengthOrPercentage] = WithAutoCssValue.empty
  var max_width: WithAutoCssValue[CssLengthOrPercentage] = WithAutoCssValue.empty
  var min_height: CssValue[CssLengthOrPercentage] = CssValue.empty
  var min_width: CssValue[CssLengthOrPercentage] = CssValue.empty

  var orphans: CssValue[CssIntNumber] = CssValue.empty

  var outline_color: CssValue[OutlineColorValue] = CssValue.empty
  var outline_style: CssValue[BorderStyleEnum.Value] = CssValue.empty
  var outline_width: CssValue[BorderWidthValue] = CssValue.empty

  var overflow: WithAutoCssValue[OverflowEnum.Value] = WithAutoCssValue.empty

  var padding_top: CssValue[CssLengthOrPercentage] = CssValue.empty
  var padding_right: CssValue[CssLengthOrPercentage] = CssValue.empty
  var padding_bottom: CssValue[CssLengthOrPercentage] = CssValue.empty
  var padding_left: CssValue[CssLengthOrPercentage] = CssValue.empty
  
  var page:CssValue[String] = CssValue.empty
  
  var page_break_after:WithAutoCssValue[PageBreakEnum.Value] = WithAutoCssValue.empty
  var page_break_before:WithAutoCssValue[PageBreakEnum.Value] = WithAutoCssValue.empty
  var page_break_inside:WithAutoCssValue[PageBreakInsideEnum.Value] = WithAutoCssValue.empty
  
  var position:WithAutoCssValue[CssPositionEnum.Value] = WithAutoCssValue.empty
  
  var right:WithAutoCssValue[CssLengthOrPercentage] = WithAutoCssValue.empty
  
  var size:WithAutoCssValue[CssSizeValue] = WithAutoCssValue.empty
  
  var table_layout:WithAutoCssValue[TableLayoutEnum.Value] = WithAutoCssValue.empty
  
  var text_align:CssValue[TextAlignEnum.Value] = CssValue.empty
  var text_decoration:WithNoneCssValue[TextDecorationEnum.Value] = WithNoneCssValue.empty
  
  var text_indent:WithNoneCssValue[CssLengthOrPercentage] = WithNoneCssValue.empty
  var text_transform:WithNoneCssValue[TextTransformEnum.Value] = WithNoneCssValue.empty
  
  var top:WithAutoCssValue[CssLengthOrPercentage] = WithAutoCssValue.empty
  
  var vertical_align:CssValue[VerticalAlignValue] = CssValue.empty
  var visibility:CssValue[VisibilityEnum.Value] = CssValue.empty

  var white_space = CssValue.empty[WhiteSpaceEnum.Value]
  var windows: CssValue[CssIntNumber] = CssValue.empty
  var width:WithAutoCssValue[CssLengthOrPercentage] = WithAutoCssValue.empty
  var word_spacing:WithAutoCssValue[WordSpacingValue] = WithAutoCssValue.empty
  
  var z_index:WithAutoCssValue[CssIntNumber] = WithAutoCssValue.empty
}