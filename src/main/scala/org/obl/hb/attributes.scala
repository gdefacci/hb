package org.obl.hb

trait AttributeContainer

object attributes {

trait CoreAttributes extends AttributeContainer {
  var accessKey: String = _
  var Class: String = _
  var contentEditable: Boolean = _
  var contextMenu: String = _
  var dir: HtmlValue[DirEnum.Value] = HtmlValue.empty
  var draggable: Boolean = _
  var dropzone: String = _
  var hidden: Boolean = _
  var id: String = _
  var lang: String = _
  var spellCheck: Boolean = _
  var style: Style = new Style
  var tabIndex: HtmlValue[Int] = HtmlValue.empty[Int]
  var title: String = _
  var translate: HtmlValue[TranslateEnum.Value] = HtmlValue.empty
}

trait EventHandlerAttributes extends AttributeContainer {

  var onabort: String = _
  var onblur: String = _
  var oncanplay: String = _
  var oncanplaythrough: String = _
  var onchange: String = _
  var onclick: String = _
  var oncontextmenu: String = _
  var oncuechange: String = _
  var ondblclick: String = _
  var ondrag: String = _
  var ondragend: String = _
  var ondragenter: String = _
  var ondragleave: String = _
  var ondragover: String = _
  var ondragstart: String = _
  var ondrop: String = _
  var ondurationchange: String = _
  var onemptied: String = _
  var onended: String = _
  var onerror: String = _
  var onfocus: String = _
  var oninput: String = _
  var oninvalid: String = _
  var onkeydown: String = _
  var onkeypress: String = _
  var onkeyup: String = _
  var onload: String = _
  var onloadeddata: String = _
  var onloadedmetadata: String = _
  var onloadstart: String = _
  var onmousedown: String = _
  var onmousemove: String = _
  var onmouseout: String = _
  var onmouseover: String = _
  var onmouseup: String = _
  var onmousewheel: String = _
  var onpause: String = _
  var onplay: String = _
  var onplaying: String = _
  var onprogress: String = _
  var onratechange: String = _
  var onreset: String = _
  var onscroll: String = _
  var onseeked: String = _
  var onseeking: String = _
  var onselect: String = _
  var onshow: String = _
  var onstalled: String = _
  var onsubmit: String = _
  var onsuspend: String = _
  var ontimeupdate: String = _
  var onvolumechange: String = _
  var onwaiting: String = _
}

trait GlobalAttributes extends CoreAttributes with EventHandlerAttributes

trait WithTargetAttributes extends AttributeContainer {
  var target: String = _
}

trait WithHrefAttributes extends AttributeContainer {
  var href: String = _ // FIXME: URL
}

trait WithMediaAttributes extends AttributeContainer {
  var media:String = _ // FIXME: media query
}

trait WithMimeTypeAttributes extends AttributeContainer {
  var Type:HtmlValue[Mime.Value] = HtmlValue.empty 
}

trait WithCharsetAttributes extends AttributeContainer {
    var charset:String = _ 
}

trait WithHrefLangAttributes extends AttributeContainer {
  var hrefLang:String = _
}

trait WithCiteAttributes extends AttributeContainer {
  var cite: String = _
}

trait WithSrcAttributes extends AttributeContainer {
  var src:String = _ // FIXME:  url
}

trait WithNameAttributes extends AttributeContainer {
  var name:String = _
}

trait WithUseMapAttributes extends AttributeContainer {
   var useMap:String = _ 
}

trait WithCrossOriginAttributes extends AttributeContainer {
   var crossOrigin:HtmlValue[CorsSettingsEnum.Value] = HtmlValue.empty 
}

trait WithSpanAttributes extends AttributeContainer {
  var span:HtmlValue[Int] = HtmlValue.empty
}

trait DimensionAttributes extends AttributeContainer {
  var width: HtmlValue[Int] = HtmlValue.empty  
  var height: HtmlValue[Int] = HtmlValue.empty 
}

trait WithAltAttributes extends AttributeContainer {
  var alt:String = _
}

trait WithPingAttributes extends AttributeContainer {
  var ping:String = _ // FIXME url
}

trait WithAreaAndARelAttributes extends AttributeContainer {
  var rel:HtmlValue[RelAreaAndAEnum.Value] = HtmlValue.empty
}

trait MultiMediaElementAttributes extends AttributeContainer {
  var preload:HtmlValue[PreloadEnum.Value] = HtmlValue.empty
  var autoplay:Boolean = _
  var mediaGroup:String = _
  var loop:Boolean = _
  var muted:Boolean = _
  var controls:Boolean = _
}


class HtmlElementAttributes extends GlobalAttributes {
  var manifest:String = _ // fixme URL
}

class BaseElementAttributes extends GlobalAttributes with WithHrefAttributes with WithTargetAttributes 


class LinkElementAttributes extends GlobalAttributes with WithHrefAttributes with WithMediaAttributes with WithMimeTypeAttributes with WithHrefLangAttributes {
  var rel:HtmlValue[RelLinkEnum.Value] = HtmlValue.empty
  var sizes:ValuesSet[Size] = ValuesSet.empty
}

class MetaElementAttributes extends GlobalAttributes with WithCharsetAttributes with WithNameAttributes {
  var http_equiv:String = _ // FIXME
  var content:String = _ 
}

class StyleElementAttributes extends GlobalAttributes with WithMediaAttributes with WithMimeTypeAttributes{
  var scoped:Boolean = _
}

class ScriptElementAttributes extends GlobalAttributes with WithCharsetAttributes with WithMimeTypeAttributes with WithSrcAttributes {
  var aynch:Boolean = _
  var defer:Boolean = _
}

class BlockquoteElementAttributes extends GlobalAttributes with WithCiteAttributes 

class OlElementAttributes extends GlobalAttributes {
  var reversed: Boolean = _
  var start: HtmlValue[Int] = HtmlValue.empty[Int]
  var Type:HtmlValue[ListMarkerTypeEnum.Value] = HtmlValue.empty
}

class LiElementAttributes extends GlobalAttributes with WithNameAttributes {
  var value:String = _
}

trait WithDownloadAttributes extends AttributeContainer {
  var download:String = _
}

class AElementAttributes extends GlobalAttributes with WithHrefAttributes with WithTargetAttributes with WithMediaAttributes with 
	WithHrefLangAttributes with WithMimeTypeAttributes with WithDownloadAttributes with WithAltAttributes with WithPingAttributes with WithAreaAndARelAttributes 

	
class AreaElementAttributes extends GlobalAttributes with WithHrefAttributes with WithTargetAttributes with 
	WithHrefLangAttributes with WithMimeTypeAttributes with WithDownloadAttributes with WithAltAttributes with WithPingAttributes with WithAreaAndARelAttributes {
  
  var shape:HtmlValue[ShapeEnum.Value] = HtmlValue.empty
  var coords:ValuesSet[Int] = ValuesSet.empty
  
} 

class QElementAttributes extends GlobalAttributes with WithCiteAttributes 

class TimeElementAttributes extends GlobalAttributes {
  var dateTime:String = _ // FIXME DATE
  var pubDate:Boolean = _
}

class InsDelAttributes extends GlobalAttributes with WithCiteAttributes {
  var dateTime: String = _ // FIXME, DATE
}


class ImgElementAttributes extends GlobalAttributes with WithSrcAttributes with DimensionAttributes with WithUseMapAttributes with WithCrossOriginAttributes {
  var isMap:Boolean = _ 
}

class IFrameElementAttributes extends GlobalAttributes with WithSrcAttributes with DimensionAttributes with WithNameAttributes {
  var srcdoc:String = _
  var sandbox:ValuesSet[SandboxEnum.Value] = ValuesSet.empty
  var seamless:Boolean = _
}

class EmbedElementAttributes extends GlobalAttributes with WithSrcAttributes with DimensionAttributes with WithMimeTypeAttributes

class ObjectElementAttributes extends GlobalAttributes with DimensionAttributes with WithMimeTypeAttributes  with WithNameAttributes with WithUseMapAttributes {
  var data:String = _ // FIXME: URL
  var typeMustMatch:Boolean = _ 
  var form:String = _
}

class ParamElementAttributes extends GlobalAttributes with WithNameAttributes {
  var value:String = _
}

class VideoElementAttributes extends GlobalAttributes with DimensionAttributes with WithSrcAttributes with WithCrossOriginAttributes with MultiMediaElementAttributes {
  var poster:String = _// FIXME: url
}

class AudioElementAttributes extends GlobalAttributes with WithSrcAttributes with WithCrossOriginAttributes with MultiMediaElementAttributes 

class SourceElementAttributes extends GlobalAttributes with WithSrcAttributes with WithMimeTypeAttributes with WithMediaAttributes

trait WithLabelAttributes extends AttributeContainer {
  var label:String = _
}

class TrackElementAttributes extends GlobalAttributes with WithSrcAttributes with WithLabelAttributes {
  var srcLang:String = _
  var kind:HtmlValue[TrackKindEnum.Value] = HtmlValue.empty
  var default:Boolean = _
}

class CanvasElementAttributes extends GlobalAttributes with DimensionAttributes

class TableElementAttributes extends GlobalAttributes {
  var sortable:Boolean = _
}

class ColGroupColAttributes extends GlobalAttributes with WithSpanAttributes

trait TdThCommonAttributes extends AttributeContainer {
  var colspan = HtmlValue.empty[Int]
  var rowspan = HtmlValue.empty[Int]
  var headers: ValuesSet[String] = ValuesSet.empty
}

class TdElementAttributes extends GlobalAttributes with TdThCommonAttributes 

class ThElementAttributes extends GlobalAttributes with TdThCommonAttributes {
  var scope:HtmlValue[ThScopeEnum.Value] = HtmlValue.empty
  var sorted:String = _ // FIXME 4.9.13 html spec
  var abbr:String = _
} 

trait WithAutocompleteAttributes extends AttributeContainer {
  var autocomplete: HtmlValue[AutocompleteEnum.Value] = HtmlValue.empty
}

trait WithFormAttributes extends AttributeContainer {
  var form:String = _  
}

trait WithValueAttributes extends AttributeContainer {
  var value:String = _  
}

trait WithDisabledAttributes extends AttributeContainer {
  var disabled:Boolean = _
}

trait WithFormInfoAttributes extends AttributeContainer {
  var formAction: String = _ // FIXME: URL
  var formEnctype: HtmlValue[EncTypeEnum.Value] = HtmlValue.empty
  var formMethod: HtmlValue[FormMethodEnum.Value] = HtmlValue.empty
  var formNoValidate: Boolean = _
  var formTarget: String = _
}

trait WithRequiredAttributes extends AttributeContainer {
  var required:Boolean = _
}

trait WithMultipleAttributes extends AttributeContainer {
  var multiple:Boolean = _
}

trait WithAutofocusAttributes extends AttributeContainer {
  var autofocus:Boolean = _
}

trait WithSizeAttributes extends AttributeContainer {
  var size:HtmlValue[Int] = HtmlValue.empty
}

trait WithDirNameAttributes extends AttributeContainer {
  var dirname:HtmlValue[DirEnum.Value] = HtmlValue.empty
}

trait WithMaxLengthAttributes extends AttributeContainer {
  var maxLength:HtmlValue[Int] = HtmlValue.empty
}

trait WithPlaceholderAttributes extends AttributeContainer {
  var placeholder:String = _
}

trait WithReadonlyAttributes extends AttributeContainer {
  var readOnly:Boolean = _
}

trait WithForAttributes extends AttributeContainer {
   var For:String = _
}

trait WithCheckedAttributes extends AttributeContainer {
  var checked:Boolean = _
}

class FormElementAttributes extends GlobalAttributes with WithTargetAttributes with WithNameAttributes with WithAutocompleteAttributes {
  var accept_charset: String = _
  var action: String = _ // FIXME: URL
  var enctype: HtmlValue[EncTypeEnum.Value] = HtmlValue.empty
  var method: HtmlValue[FormMethodEnum.Value] = HtmlValue.empty
  var noValidate: Boolean = _
}

class LabelElementAttributes extends GlobalAttributes with WithFormAttributes with WithForAttributes

class InputElementAttributes extends GlobalAttributes with DimensionAttributes with WithAltAttributes with WithAutocompleteAttributes with WithFormAttributes with 
	WithNameAttributes with WithSrcAttributes with WithDisabledAttributes with WithFormInfoAttributes  with WithValueAttributes with 
	WithSizeAttributes with WithRequiredAttributes with WithMultipleAttributes with WithAutofocusAttributes with WithDirNameAttributes with WithMaxLengthAttributes with 
	WithPlaceholderAttributes with WithReadonlyAttributes with WithCheckedAttributes {
  var accept:String = _ // FIXME
  
  var inputMode:HtmlValue[InputModeEnum.Value] = HtmlValue.empty
  var list:String = _
  var min:String = _
  var max:String = _
  var pattern:String = _ // FIXME RegExp
  
  
  var step:String = _ // floating point number or string "any"
  var Type:HtmlValue[InputTypeEnum.Value] = HtmlValue.empty
  
}

class FieldsetElemAttributes extends GlobalAttributes with WithDisabledAttributes with WithFormAttributes with WithNameAttributes

class ButtonElementAttributes extends GlobalAttributes with WithDisabledAttributes with WithFormAttributes with WithFormInfoAttributes with WithValueAttributes {
  var autoFocus:Boolean = _
  var Type:HtmlValue[ButtonTypeEnum.Value] = HtmlValue.empty 
  var menu:String = _
}

class SelectElementAttributes extends GlobalAttributes with WithAutofocusAttributes with WithDisabledAttributes with WithFormAttributes with 
	WithMultipleAttributes with WithNameAttributes with WithRequiredAttributes with WithSizeAttributes

class OptionElementAttributes extends GlobalAttributes with WithDisabledAttributes with WithLabelAttributes with WithValueAttributes {
  var selected:Boolean = _
}

class OptGroupElementAttributes extends GlobalAttributes with WithDisabledAttributes with WithLabelAttributes

class TextareaElementAttributes extends GlobalAttributes with WithAutofocusAttributes with WithDirNameAttributes with WithFormAttributes with 
	WithMaxLengthAttributes with WithPlaceholderAttributes with WithReadonlyAttributes{
  var cols:HtmlValue[Int] = HtmlValue.empty
  var rows:HtmlValue[Int] = HtmlValue.empty
  var wrap:HtmlValue[TextareaWrapNum.Value] = HtmlValue.empty
}
	
class KeygenElementAttributes extends GlobalAttributes with WithNameAttributes with WithAutofocusAttributes with WithDisabledAttributes with WithFormAttributes {
  var challenge:String = _
  var keyType:HtmlValue[KeyTypeEnum.Value] = HtmlValue.empty
}

class OutputElementAttributes extends GlobalAttributes with WithNameAttributes with WithFormAttributes with WithForAttributes

trait ProgressMeterCommonAttributes extends AttributeContainer {
  var value:HtmlValue[Double] = HtmlValue.empty
  var max:HtmlValue[Double] = HtmlValue.empty
}

class ProgressElementAttributes extends GlobalAttributes with ProgressMeterCommonAttributes
class MeterElementAttributes extends GlobalAttributes with ProgressMeterCommonAttributes {
  var min     :HtmlValue[Double] = HtmlValue.empty 
  var low     :HtmlValue[Double] = HtmlValue.empty
  var high    :HtmlValue[Double] = HtmlValue.empty
  var optimum :HtmlValue[Double] = HtmlValue.empty 
}

class DetailsElementAttributes extends GlobalAttributes {
  var open:Boolean = _
}

class CommandElementAttributes extends GlobalAttributes with WithLabelAttributes with WithDisabledAttributes with WithCheckedAttributes {
  var Type:HtmlValue[CommandTypeEnum.Value] = HtmlValue.empty
  var icon:String = _ // FIXME: URL
  var radiogroup:String = _
  var command:String = _
}

class MenuElementAttributes extends GlobalAttributes with WithLabelAttributes {
  var Type:HtmlValue[MenuTypeEnum.Value] = HtmlValue.empty
}

}