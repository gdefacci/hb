package org.obl.hb

import scala.reflect.ClassTag
import scala.reflect.runtime.universe.TypeTag

object BaseHBs {
  
  // flow element
trait FlowElementHB extends HB with ObjectContentHB with MediaContentHB with FieldsetContentHB with DetailsContentHB
// flow element that is not a phrasing element
trait FlowHB extends FlowElementHB 
// phrasing element
trait PhrasingHB extends FlowElementHB with RubyContentHB with DatalistContentHB

trait FlowElementContainerHB extends TextContainerHB with ScriptContainerHB with NoScriptContainerHB with CommandContainerHB 

// can cantains FlowHB and PhrasingHB elements
trait FlowContainerHB extends ContainerHB with FlowElementContainerHB with HeaderContainerHB with StyleContainerHB {
//  type CanInclude <: FlowElementHB
}

// can cantains only phrasing elements 
trait PhrasingContainerHB extends ContainerHB with FlowElementContainerHB {
//  type CanInclude <: PhrasingHB
} 

trait TextContainerHB extends ContainerHB

trait RowsContainerHB extends ContainerHB // can contain TR

trait HeaderContainerHB extends ContainerHB // can contains h1,h2..h6

trait StyleContainerHB extends ContainerHB  // can contain style element

trait MetaContainerHB extends ContainerHB  // can contain meta element

trait ScriptContainerHB extends ContainerHB // can contain script element

trait LiContainerHB extends ContainerHB // can contain li element

trait OptionContainerHB extends ContainerHB // can contain option element

trait CommandContainerHB extends ContainerHB // can contain command element

trait NoScriptContainerHB extends ContainerHB // can contain noScript element

trait MediaContainerHB extends ContainerHB // can contain noScript element

//trait LegendContainerHB extends ContainerHB // can contain legend element

trait FieldsetContentHB extends HB // is valid content for fieldset element

trait RubyContentHB extends HB // is valid content for ruby element

trait ObjectContentHB extends HB // is valid content for object element

trait MediaContentHB extends HB // is valid content for video/audio element

trait DatalistContentHB extends HB // is valid content for datalist element

trait DetailsContentHB extends HB // is valid content for details element

trait RootContainerHB extends ContainerHB {
	throw new UnsupportedOperationException("should never be instantiated")
}



  class TextHB(str: String) extends PhrasingHB {
    val value = Text(str)
    type CanBeIn = TextContainerHB
  }
  
  trait TextOnlyContainerHB extends ContainerHB with TextContainerHB {
    type CanInclude = TextHB
  }
  
  class PhrasingHBImpl[A <: AttributeContainer](val value: Elem, attributeFactory: => A)(implicit tt: TypeTag[A], ct: ClassTag[A]) extends BaseElemHB[A, PhrasingHBImpl[A]](attributeFactory, new PhrasingHBImpl[A](_, attributeFactory)) with 
  	PhrasingContainerHB with PhrasingHB with ElementsHB {
    type CanBeIn = FlowElementContainerHB
    type CanInclude = PhrasingHB
  }

  class EmptyPhrasingHB[A <: AttributeContainer](val value: Elem, attributeFactory: => A)(implicit tt: TypeTag[A], ct: ClassTag[A]) extends BaseElemHB[A, EmptyPhrasingHB[A]](attributeFactory, new EmptyPhrasingHB(_, attributeFactory)) with PhrasingHB {
    type CanBeIn = FlowElementContainerHB
  }

  class PhrasingElemSeqHB(val value: ElemSeq) extends PhrasingHB {
    type Self = PhrasingElemSeqHB

    type CanBeIn = FlowElementContainerHB
  }

  object PhrasingHBImpl {
    def apply[A <: AttributeContainer](value: Elem, attributeFactory: => A)(implicit tt: TypeTag[A], ct: ClassTag[A]) =
      new PhrasingHBImpl[A](value, attributeFactory)
  }

  class FlowHBImpl[A <: AttributeContainer](val value: Elem, af: => A)(implicit tt: TypeTag[A], ct: ClassTag[A]) extends BaseElemHB[A, FlowHBImpl[A]](af, new FlowHBImpl[A](_, af)) with FlowContainerHB with FlowHB with ElementsHB {
    type CanBeIn = FlowContainerHB
    type CanInclude = FlowElementHB
  }

  class FlowElemSeqHB(val value: ElemSeq) extends FlowHB {
    type Self = FlowElemSeqHB
    type CanBeIn = FlowContainerHB
  }
  
  class FlowElementElemSeqHB(val value: ElemSeq) extends FlowElementHB {
    type Self = FlowElemSeqHB
    type CanBeIn = FlowContainerHB
  }

  object FlowHBImpl {
    def apply[A <: AttributeContainer](value: Elem, attributeFactory: => A)(implicit tt: TypeTag[A], ct: ClassTag[A]) =
      new FlowHBImpl[A](value, attributeFactory)
  }

}