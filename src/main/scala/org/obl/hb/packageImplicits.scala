package org.obl.hb

import scala.language.implicitConversions

object `package` {
  import BaseHBs._
  import HBs._

  implicit def dynAttributePairToAttributeEffect[T, A <: AttributeContainer]( p:(DynAttribute[T,A], T) ):A => Unit = { t => t.put(p._1, p._2) }
  implicit def singleDynAttributePairToAttributeEffect[A <: AttributeContainer, DA]( p:SingleDynAttribute[A] ):A => Unit = { t => t.put(p, true) }
  
  implicit def optvDynAttributePairToAttributeEffect[DA, A <: AttributeContainer]( p:(OptionalValueDynAttribute[DA,A], DA) ):A => Unit = { t => t.put(p._1, p._2) }
  implicit def optvSingleDynAttributePairToAttributeEffect[A <: AttributeContainer]( p:OptionalValueDynAttribute[_,A] ):A => Unit = { t => t.put(p) }
  
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
