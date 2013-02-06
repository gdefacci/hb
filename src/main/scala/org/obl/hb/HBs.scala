package org.obl.hb

import scala.language.implicitConversions

import org.obl.hb.attributes._

object `package` {
  import BaseHBs._
  import HBs._

  implicit def fromString(str: String):TextHB = new TextHB(str)
  implicit def fromIterableString(str: Iterable[String]) = new TextHB(str.mkString(""))
  implicit def fromPhrasingSeq(m: Iterable[PhrasingHB]) = new PhrasingElemSeqHB(ElemSeq(HtmlOp.flatten(m.map(_.value).toList)))
  implicit def fromFlowSeq(m: Iterable[FlowHB]) = new FlowElemSeqHB(ElemSeq(HtmlOp.flatten(m.map(_.value).toList)))
  implicit def fromFlowElementSeq(m: Iterable[FlowElementHB]) = new FlowElementElemSeqHB(ElemSeq(HtmlOp.flatten(m.map(_.value).toList)))

  implicit def fromHSeq(m: Iterable[HHB.BaseHB]) = new HHB.ElemSeqHB(ElemSeq(HtmlOp.flatten(m.map(_.value).toList)))
  implicit def fromLiSeq(m: Iterable[LiHB.BaseHB]) = new LiHB.ElemSeqHB(ElemSeq(HtmlOp.flatten(m.map(_.value).toList)))
  implicit def fromDlContentSeq(m: Iterable[DlContentHB.BaseHB]) = new DlContentHB.ElemSeqHB(ElemSeq(HtmlOp.flatten(m.map(_.value).toList)))
  implicit def fromOptSeq(m: Iterable[OptionHB.HBImpl]) = new OptionHB.ElemSeqHB(ElemSeq(HtmlOp.flatten(m.map(_.value).toList)))

  implicit def fromTableContentSeq(m:Iterable[TableContentHB.BaseHB]) = new TableContentHB.ElemSeqHB(ElemSeq(HtmlOp.flatten(m.map(_.value).toList)))
  implicit def fromTrSeq(m:Iterable[TrHB]) = new TrSeqHB(ElemSeq(HtmlOp.flatten(m.map(_.value).toList)))
  implicit def fromTHSeq(m:Iterable[ThHB]) = new TableCellSeqHB(ElemSeq(HtmlOp.flatten(m.map(_.value).toList)))
  implicit def fromTDSeq(m:Iterable[TdHB]) = new TableCellSeqHB(ElemSeq(HtmlOp.flatten(m.map(_.value).toList)))
  
  implicit def fromMetadataContentSeq(m:Iterable[MetadataContentHB]) = new MetadataContentHB.ElemSeqHB(ElemSeq(HtmlOp.flatten(m.map(_.value).toList)))
  implicit def fromScriptSeq(m:Iterable[MetadataContentHB.Script]) = new MetadataContentHB.ScriptSeq(ElemSeq(HtmlOp.flatten(m.map(_.value).toList)))
  implicit def fromStyleSeq(m:Iterable[MetadataContentHB.Style]) = new MetadataContentHB.StyleSeq(ElemSeq(HtmlOp.flatten(m.map(_.value).toList)))
  implicit def fromLinkSeq(m:Iterable[MetadataContentHB.Link]) = new MetadataContentHB.LinkSeq(ElemSeq(HtmlOp.flatten(m.map(_.value).toList)))
  implicit def fromCommandSeq(m:Iterable[MetadataContentHB.Command]) = new MetadataContentHB.CommandSeq(ElemSeq(HtmlOp.flatten(m.map(_.value).toList)))
  implicit def fromMetaSeq(m:Iterable[MetadataContentHB.Meta]) = new MetadataContentHB.MetaSeq(ElemSeq(HtmlOp.flatten(m.map(_.value).toList)))
  
  implicit def fromRubyContentSeq(m:Iterable[RubyContentHB]) = new RubyContentSeqHB(ElemSeq(HtmlOp.flatten(m.map(_.value).toList)))
  implicit def fromMediaContentSeq(m:Iterable[MediaContentHB]) = new MediaContentElemSeqHB(ElemSeq(HtmlOp.flatten(m.map(_.value).toList)))
  implicit def fromFieldsetContentSeq(m:Iterable[FieldsetContentHB]) = new FieldsetContentElemSeqHB(ElemSeq(HtmlOp.flatten(m.map(_.value).toList)))
  implicit def fromSelectContentSeq(m:Iterable[SelectContentHB]) = new SelectContentSeqHB(ElemSeq(HtmlOp.flatten(m.map(_.value).toList)))
  implicit def fromDatalistContentSeq(m:Iterable[DatalistContentHB]) = new DatalistContentElemSeqHB(ElemSeq(HtmlOp.flatten(m.map(_.value).toList)))
  implicit def fromDetailsElemSeq(m:Iterable[DetailsContentHB]) = new DetailsElemSeqHB(ElemSeq(HtmlOp.flatten(m.map(_.value).toList)))
  //  implicit class LiHBSeq(m: Iterable[Li.BaseHB]) extends Li.ElemSeqHB(ElemSeq(HtmlOp.flatten(m.map(_.value).toList)))
  //  implicit class LiHBSeq1(m: Iterable[Li.HBImpl]) extends Li.ElemSeqHB(ElemSeq(HtmlOp.flatten(m.map(_.value).toList)))
  //  implicit class TdHBSeq(m: Iterable[Td.BaseHB]) extends Td.ElemSeqHB(ElemSeq(HtmlOp.flatten(m.map(_.value).toList)))
  //  implicit class DlContentHBSeq(m: Iterable[DlContent.BaseHB]) extends DlContent.ElemSeqHB(ElemSeq(HtmlOp.flatten(m.map(_.value).toList)))
  //  implicit class OptionSeqHBSeq(m: Iterable[Option.BaseHB]) extends Option.ElemSeqHB(ElemSeq(HtmlOp.flatten(m.map(_.value).toList)))
  //  implicit class HeaderSeqHBSeq(m: Iterable[Header.BaseHB]) extends Header.ElemSeqHB(ElemSeq(HtmlOp.flatten(m.map(_.value).toList)))
  //  implicit class TableContentSeqHBSeq(m: Iterable[TableContent.BaseHB]) extends TableContent.ElemSeqHB(ElemSeq(HtmlOp.flatten(m.map(_.value).toList)))
}

object HBs {

  def globalAttributes = new GlobalAttributes() {}

  import BaseHBs._

  class HGroupHB(val value: Elem) extends BaseElemHB[GlobalAttributes, HGroupHB](globalAttributes, new HGroupHB(_)) with HeaderContainerHB with ElementsHB {
    type CanBeIn = FlowContainerHB
    type CanInclude = HHB.BaseHB
  }

  object HHB {
    trait BaseHB extends FlowHB {
      type Self <: BaseHB
      type CanBeIn = HeaderContainerHB
    }

    class ElemSeqHB(val value: ElemSeq) extends BaseHB {
      type Self = ElemSeqHB
    }

    class HBImpl(val value: Elem) extends BaseElemHB[GlobalAttributes, HBImpl](globalAttributes, new HBImpl(_)) with PhrasingContainerHB with BaseHB
  }

  trait LiContainerHB extends ContainerHB {
    type CanInclude = LiHB.BaseHB
  }

  class UlHB(val value: Elem) extends BaseElemHB[GlobalAttributes, UlHB](globalAttributes, new UlHB(_)) with FlowHB with LiContainerHB with ElementsHB {
    type CanBeIn = FlowContainerHB
  }

  object LiHB {
    trait BaseHB extends HB {
      type Self <: BaseHB
      type CanBeIn = LiContainerHB
    }

    class ElemSeqHB(val value: ElemSeq) extends BaseHB {
      type Self = ElemSeqHB
    }

    class HBImpl(val value: Elem) extends BaseElemHB[LiElementAttributes, HBImpl](new LiElementAttributes, new HBImpl(_)) with BaseHB with FlowContainerHB with ElementsHB {
      type CanInclude = FlowElementHB
    }
  }

  object TableContentHB {

    trait BaseHB extends HB

    class ElemSeqHB(val value: ElemSeq) extends BaseHB
  }

  class TableHB(val value: Elem) extends BaseElemHB[TableElementAttributes, TableHB](new TableElementAttributes, new TableHB(_)) with FlowHB with RowsContainerHB with ElementsHB  {
      type CanBeIn = FlowContainerHB
      type CanInclude = TableContentHB.BaseHB
    }

  class CaptionHB(val value:Elem) extends BaseElemHB[GlobalAttributes, CaptionHB](globalAttributes, new CaptionHB(_)) with TableContentHB.BaseHB with ElementsHB with TextContainerHB {
    type CanBeIn = TableHB
    type CanInclude = FlowElementHB
      
  }
  
  class ColgroupHB(val value:Elem) extends BaseElemHB[ColGroupColAttributes, ColgroupHB](new ColGroupColAttributes, new ColgroupHB(_)) with TableContentHB.BaseHB with ElementsHB {
    type CanBeIn = TableHB
    type CanInclude = ColHB
  }
  
  class ColHB(val value:Elem) extends BaseElemHB[ColGroupColAttributes, ColHB](new ColGroupColAttributes, new ColHB(_)) {
    type CanBeIn = ColgroupHB
  }
  
  class TrContainerHB(val value:Elem) extends BaseElemHB[GlobalAttributes, TrContainerHB](globalAttributes, new TrContainerHB(_)) with RowsContainerHB with ElementsHB with TableContentHB.BaseHB {
    type CanBeIn = TableHB
    type CanInclude = TableRowHB
  }
  
  trait TableRowHB extends HB {
    type CanBeIn = RowsContainerHB
  }
  
  class TrSeqHB(val value: ElemSeq) extends TableContentHB.BaseHB with TableRowHB 
  
  class TrHB(val value:Elem) extends BaseElemHB[GlobalAttributes, TrHB](globalAttributes, new TrHB(_)) with ElementsHB with TableContentHB.BaseHB with TableRowHB {
    type CanInclude = TableCellHB
  }
  
  trait TableCellHB extends HB {
    type CanBeIn = TrHB
  }
   
  class TableCellSeqHB(val value: ElemSeq) extends TableCellHB
  
  class TdHB(val value:Elem) extends BaseElemHB[TdElementAttributes, TdHB](new TdElementAttributes, new TdHB(_)) with FlowContainerHB with ElementsHB with TableCellHB {
    type CanInclude = FlowElementHB
  }
  
  class ThHB(val value:Elem) extends BaseElemHB[ThElementAttributes, ThHB](new ThElementAttributes, new ThHB(_)) with FlowContainerHB with ElementsHB with TableCellHB {
    type CanInclude = FlowElementHB
  }

  class HtmlHB(val value:Elem) extends BaseElemHB[HtmlElementAttributes, HtmlHB](new HtmlElementAttributes, new HtmlHB(_)) with ContainerHB {
    def apply(head:HeadHB, body:BodyHB) ={
      addChildren(head :: body :: Nil)
    }
    
    type CanBeIn = RootContainerHB
    type CanInclude = HB
  }
  
  class HeadHB(val value:Elem) extends BaseElemHB[TdElementAttributes, HeadHB](new TdElementAttributes, new HeadHB(_)) with ElementsHB with 
  	StyleContainerHB with ScriptContainerHB with 
  	NoScriptContainerHB with CommandContainerHB with MetaContainerHB {
    
    type CanBeIn = HtmlHB
    type CanInclude = MetadataContentHB
  }
  
  class BodyHB(val value:Elem) extends BaseElemHB[TdElementAttributes,BodyHB](new TdElementAttributes, new BodyHB(_)) with FlowContainerHB with ElementsHB {
    type CanBeIn = HtmlHB
    type CanInclude = FlowElementHB
  }
  
  trait MetadataContentHB extends HB 

  object MetadataContentHB {
    
    class ElemSeqHB(val value:ElemSeq) extends MetadataContentHB {
      type CanBeIn = HeadHB
      type Self = ElemSeqHB
    }
    
    class Base(val value:Elem) extends BaseElemHB[BaseElementAttributes, Base](new BaseElementAttributes, new Base(_)) with MetadataContentHB {
      type CanBeIn = HeadHB
    }
    
    class LinkSeq(val value:ElemSeq) extends MetadataContentHB {
      type CanBeIn = HeadHB
    }
    
    class Link(val value:Elem) extends BaseElemHB[LinkElementAttributes, Link](new LinkElementAttributes, new Link(_)) with MetadataContentHB {
      type CanBeIn = HeadHB
    }
    
    class CommandSeq(val value:ElemSeq) extends MetadataContentHB with PhrasingHB {
      type CanBeIn = CommandContainerHB
    }
    
    class MetaSeq(val value:ElemSeq) extends MetadataContentHB with PhrasingHB {
      type CanBeIn = MetaContainerHB
    }
    
    class Meta(val value:Elem) extends BaseElemHB[MetaElementAttributes, Meta](new MetaElementAttributes, new Meta(_)) with MetadataContentHB with PhrasingHB {
      type CanBeIn = MetaContainerHB
    }
    
    class Command(val value:Elem) extends BaseElemHB[CommandElementAttributes, Command](new CommandElementAttributes, new Command(_)) with MetadataContentHB with PhrasingHB {
      type CanBeIn = CommandContainerHB
    }
    
    class NoScript(val value:Elem) extends BaseElemHB[GlobalAttributes, NoScript](globalAttributes, new NoScript(_)) with MetadataContentHB with PhrasingHB with FlowContainerHB {
      type CanBeIn = NoScriptContainerHB
      type CanInclude = FlowElementHB
    }
    
    class ScriptSeq(val value:ElemSeq) extends MetadataContentHB with PhrasingHB  {
      type CanBeIn = ScriptContainerHB
    }
    
    class Script(val value:Elem) extends BaseElemHB[ScriptElementAttributes, Script](new ScriptElementAttributes, new Script(_)) with TextOnlyContainerHB with 
    	MetadataContentHB with PhrasingHB  {
      type CanBeIn = ScriptContainerHB
    }

    class StyleSeq(val value:ElemSeq) extends MetadataContentHB with FlowHB {
      type CanBeIn = StyleContainerHB
    }
    
    class Style(val value:Elem) extends BaseElemHB[StyleElementAttributes,Style](new StyleElementAttributes, new Style(_)) with TextOnlyContainerHB with 
    	MetadataContentHB with FlowHB {
      type CanBeIn = StyleContainerHB
    }
    
    class Title(val value:Elem) extends BaseElemHB[GlobalAttributes, Title](globalAttributes, new Title(_)) with TextOnlyContainerHB with
    	MetadataContentHB {
      type CanBeIn = HeadHB
    }
    
  }
  
  class DlHB(val value:Elem) extends BaseElemHB[GlobalAttributes, DlHB](globalAttributes, new DlHB(_)) with FlowHB with ElementsHB {
    type CanBeIn = FlowContainerHB
    type CanInclude = DlContentHB.BaseHB
  }

  object DlContentHB {
    trait BaseHB extends HB {
      type Self <: BaseHB
      type CanBeIn = DlHB
    }
    
    class ElemSeqHB(val value: ElemSeq) extends BaseHB {
      type Self = ElemSeqHB
    }
    
    class HBImpl(val value:Elem) extends BaseElemHB[GlobalAttributes, HBImpl](globalAttributes, new HBImpl(_)) with BaseHB with ElementsHB with TextContainerHB {
      type CanInclude = FlowElementHB
    }
  }
  
  class RubyHB(val value:Elem) extends BaseElemHB[GlobalAttributes, RubyHB](globalAttributes, new RubyHB(_)) with PhrasingContainerHB with PhrasingHB with ElementsHB {
    type CanBeIn = FlowElementContainerHB
    type CanInclude = RubyContentHB
  }
  
  trait RubyContentBaseHB extends HB with RubyContentHB {
    type Self <: RubyContentBaseHB
    type CanBeIn = RubyHB
  }
    
  class RubyContentSeqHB(val value: ElemSeq) extends RubyContentBaseHB {
    type Self = RubyContentSeqHB
  }
    
  class RubyContentHBImpl(val value:Elem) extends BaseElemHB[GlobalAttributes,RubyContentHBImpl](globalAttributes, new RubyContentHBImpl(_)) with PhrasingContainerHB with RubyContentBaseHB with ElementsHB {
    type CanInclude = PhrasingHB
  }
  
  class IFrameHB(val value:Elem) extends BaseElemHB[IFrameElementAttributes, IFrameHB](new IFrameElementAttributes, new IFrameHB(_)) with TextOnlyContainerHB with PhrasingHB {
    type CanBeIn = FlowElementContainerHB
  }
  
  class ObjectHB(val value:Elem) extends BaseElemHB[ObjectElementAttributes,ObjectHB](new ObjectElementAttributes, new ObjectHB(_)) with FlowContainerHB with ElementsHB {
    type CanInclude = ObjectContentHB
    type CanBeIn = FlowElementContainerHB
  }
  
  class ParamHB(val value:Elem) extends BaseElemHB[ObjectElementAttributes, ParamHB](new ObjectElementAttributes, new ParamHB(_)) with ObjectContentHB {
    type CanBeIn = ObjectHB
  } 

  class AudioHB(val value:Elem) extends BaseElemHB[AudioElementAttributes, AudioHB](new AudioElementAttributes, new AudioHB(_)) with FlowContainerHB with MediaContainerHB with ElementsHB {
    type CanBeIn = FlowElementContainerHB
    type CanInclude = MediaContentHB
  }
  
  class VideoHB(val value:Elem) extends BaseElemHB[VideoElementAttributes, VideoHB](new VideoElementAttributes, new VideoHB(_)) with FlowContainerHB with MediaContainerHB with ElementsHB {
    type CanBeIn = FlowElementContainerHB
    type CanInclude = MediaContentHB
  }
  
  
  class MediaContentElemSeqHB(val value:ElemSeq) extends MediaContentHB {
    type CanBeIn = MediaContainerHB
  }
  
  class SourceHB(val value:Elem) extends BaseElemHB[SourceElementAttributes,SourceHB](new SourceElementAttributes, new SourceHB(_)) with MediaContentHB {
    type CanBeIn = MediaContainerHB
  }
  
  class TrackHB(val value:Elem) extends BaseElemHB[TrackElementAttributes, TrackHB](new TrackElementAttributes, new TrackHB(_)) with MediaContentHB {
    type CanBeIn = MediaContainerHB
  }
  
//  class FieldsetHB(val value:Elem) extends BaseElemHB[FieldsetElemAttributes, FieldsetHB](new FieldsetElemAttributes, new FieldsetHB(_)) with FlowContainerHB with LegendContainerHB with ElementsHB {
  class FieldsetHB(val value:Elem) extends BaseElemHB[FieldsetElemAttributes, FieldsetHB](new FieldsetElemAttributes, new FieldsetHB(_)) with FlowContainerHB  with ElementsHB {
    type CanBeIn = FlowContainerHB
    type CanInclude = FieldsetContentHB
  }
  
  class FieldsetContentElemSeqHB(val value:ElemSeq) extends FieldsetContentHB {
    type CanBeIn = FieldsetHB
  }
  
  class LegendHB(val value:Elem) extends BaseElemHB[GlobalAttributes, LegendHB](globalAttributes, new LegendHB(_)) with PhrasingContainerHB with FieldsetContentHB {
    type CanBeIn = FieldsetHB
    type CanInclude = PhrasingHB
  }
  
  class SelectHB(val value:Elem) extends BaseElemHB[GlobalAttributes, SelectHB](globalAttributes, new SelectHB(_)) with OptionContainerHB with ElementsHB with PhrasingHB {
    type CanBeIn = FlowElementContainerHB
    type CanInclude = SelectContentHB
  }
  
  trait SelectContentHB extends HB
  
  class SelectContentSeqHB(val value:ElemSeq) extends SelectContentHB {
    type Self = SelectContentSeqHB
    type CanBeIn = SelectHB
  }
  
  class OptGroupHB(val value:Elem) extends BaseElemHB[OptGroupElementAttributes, OptGroupHB](new OptGroupElementAttributes, new OptGroupHB(_)) with OptionContainerHB with SelectContentHB with ElementsHB {
    type CanBeIn = SelectHB
    type CanInclude = OptionHB.Base
  }
  
  class DatalistContentElemSeqHB(val value:ElemSeq) extends DatalistContentHB {
    type Self = DatalistContentElemSeqHB
    type CanBeIn = DatalistHB
  }
  
  class DatalistHB(val value:Elem) extends BaseElemHB[GlobalAttributes, DatalistHB](globalAttributes, new DatalistHB(_)) with OptionContainerHB with ElementsHB with PhrasingHB {
    type CanBeIn = FlowElementContainerHB
    type CanInclude = DatalistContentHB
  }
  
  object OptionHB {
  
	trait Base extends DatalistContentHB with SelectContentHB {
	  type CanBeIn = OptionContainerHB
	}

	class ElemSeqHB(val value:ElemSeq) extends Base {
	  type Self = ElemSeqHB
	}
	  
	class HBImpl(val value:Elem) extends BaseElemHB[GlobalAttributes, HBImpl](globalAttributes, new HBImpl(_)) with Base with ElementsHB with TextContainerHB {
	  type CanInclude = PhrasingHB
	}
  
  }
  
  class TextareaHB(val value:Elem) extends BaseElemHB[TextareaElementAttributes, TextareaHB](new TextareaElementAttributes, new TextareaHB(_)) with TextOnlyContainerHB with PhrasingHB {
	  type CanBeIn = FlowElementContainerHB
  }
  
  class DetailsElemSeqHB(val value:ElemSeq) extends DetailsContentHB {
      type Self = DetailsElemSeqHB
      type CanBeIn = DetailsHB
  }
  
  class DetailsHB(val value:Elem) extends BaseElemHB[DetailsElementAttributes, DetailsHB](new DetailsElementAttributes, new DetailsHB(_)) with FlowContainerHB with FlowHB with ElementsHB {
      type CanInclude = DetailsContentHB
	  type CanBeIn = FlowContainerHB
  }
  
  class SummaryHB(val value:Elem) extends BaseElemHB[DetailsElementAttributes, SummaryHB](new DetailsElementAttributes, new SummaryHB(_)) with DetailsContentHB with PhrasingContainerHB with ElementsHB {
      type CanInclude = PhrasingHB
	  type CanBeIn = DetailsHB
  }
  
}