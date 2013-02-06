package org.obl.hb

trait HB {

  val value:HtmlModel
  
  type CanBeIn <: ContainerHB
  type Self

  def apply() = value
  
  def >>: [C <: CanBeIn](h1:C):h1.Self = {
    val itm = h1.value
    val ni = HtmlOp.lAppend(itm, value)
    h1.copy(ni)
  }
  
}

trait ElemHB extends HB {

  type Self <: ElemHB 
  type Attr <: AttributeContainer
  
  def attributeFactory:Attr
  
  protected def withAttrs(mp:Map[String,Any]) = {
    copy(value.copy(attributes = value.attributes ++ mp))
  }
  
  def apply(frst:Attr => Unit, rest:Attr => Unit*):Self   
  def % (className:String) = withAttrs(Map("class" -> className))
  def :# (id:String) = withAttrs(Map("id" -> id))
  
  val value:Elem
  
  private[hb] def copy(ni: HtmlModel): Self = {
    ni match {
      case el:Elem => copy(el)
      case _ => throw new Error("")
    }
  }
  
  private[hb] def copy(ni: Elem): Self 
}

import scala.reflect.ClassTag
import scala.reflect.runtime.universe.TypeTag

abstract class BaseAttrHB[A <: AttributeContainer](f: => A)(implicit tt: TypeTag[A], ct: ClassTag[A]) extends ElemHB {
  type Attr = A 
  def attributeFactory = f
  
 def apply(frst:Attr => Unit, rest:Attr => Unit*):Self = {
    val na = attributeFactory
    (Seq(frst) ++ rest).foreach { efct =>
      efct(na)
    }
    val attrs = ObjMap.vars[A](na).filter( e => !ObjMap.isDefault(e._2))
    withAttrs(attrs)
  }
   
}

abstract class BaseElemHB[A <: AttributeContainer, S <: ElemHB](f: => A, factory:Elem => S)(implicit tt: TypeTag[A], ct: ClassTag[A]) extends BaseAttrHB[A](f) with ElemHB {
  final type Self = S
  final def copy(ni: Elem) = factory(ni)
}

trait ContainerHB extends ElemHB {
  
  type Self <: ContainerHB
  type CanInclude <: HB
  
  private[hb] def copy(ni: HtmlModel): Self 
  
  protected def addChildren(hels: List[CanInclude]): Self = {
    val els = hels.map(_.value)
    val itm = ElemSeq(HtmlOp.flatten(els))
    val ni = HtmlOp.lAppend(value, itm)
    copy(ni)
  }
}

trait ElementsHB extends ContainerHB {

  def apply(c1:CanInclude, cs:CanInclude*):Self = addChildren(c1 :: cs.toList)

}