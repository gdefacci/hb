package org.obl.hb

import scala.reflect.ClassTag
import scala.reflect.runtime.universe._

abstract class OptionalAttributes[A](implicit tt: TypeTag[A], ct: ClassTag[A]) extends OptionalValue with ValueRenderer { self:A => 
  
  def isDefault = ObjMap.areDefault( ObjMap.vars[A](this) )

  def render:String = {
    val vrs = ObjMap.vars[A](this) 
    vrs.filter( e => !ObjMap.isDefault(e._2) ).map { e =>
      AttributeRenderer.attrKey(e._1, e._2) + ":" + AttributeRenderer.render(e._2)
    }.mkString(";")
  }
  
}

object ObjMap {

  def isDefault(x: Any): Boolean = x match {
    case x if x == null => true
    case b: Boolean if !b => true
    case df:OptionalValue => df.isDefault
    case _ => false
  }
  
  def areDefault(mp:Map[String,Any]) = {
    mp.map(_._2).forall(isDefault(_))
  }

  private def collectMembers[A,T](na:A)(pf:PartialFunction[(InstanceMirror, Symbol),T])(implicit tt: TypeTag[A], ct: ClassTag[A]): Map[String, T] = {
    val mirror = runtimeMirror(na.getClass.getClassLoader)
    val instanceMirror = mirror.reflect[A](na)(ct)

    val mms = reflect.runtime.universe.typeOf[A].members

    mms .collect {
      case m if pf.isDefinedAt(instanceMirror -> m) => m.name.decoded.trim.toLowerCase -> pf(instanceMirror -> m)
    }.filter(_._2 != null).toMap
  }
  
   def vars[A](na: A)(implicit tt: TypeTag[A], ct: ClassTag[A]): Map[String, Any] = {
     
     def isVar(m:Symbol) = (m.isTerm && m.asTerm.isGetter && m.isMethod && m.asTerm.setter.isTerm) 
     
     collectMembers(na) {
	   case (instanceMirror, m) if isVar(m) => {
	     try {
	      instanceMirror.reflectMethod(m.asTerm.getter.asMethod).apply()
	     } catch {
	       case e:Throwable => throw new Exception(m.toString,  e)
	     }
	   }
	 }
   }
  
}