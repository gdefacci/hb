package org.obl.hb.test

import org.obl.hb.{ObjMap, OptionalValue, OptionalAttributes}
import org.junit.Test
import junit.framework.Assert._
import org.obl.hb.AttributeContainer

class ObjMapTest {

  class MyValue extends OptionalValue {
    def isDefault = true
  }
  
  @Test 
  def testDefault = {
    assertTrue(ObjMap.isDefault(null))
    assertTrue(ObjMap.isDefault(false))
    assertTrue(ObjMap.isDefault(new MyValue))
    
    assertTrue(ObjMap.isDefault(new Cont1))
    assertFalse(ObjMap.isDefault(new Cont))
    
    assertFalse(ObjMap.isDefault(true))
    assertFalse(ObjMap.isDefault(0))
    assertFalse(ObjMap.isDefault(""))
  }
  
    
  class Cont1 extends OptionalAttributes[Cont1] with AttributeContainer {
    var b:Boolean = _
    var c:String = _

    var p = new MyValue
    
    def someMethod(i:Int):String = i.toString
    def someOthrMthd() = {
      
    }
    val myconst = "22"
  }

  
  class Cont extends OptionalAttributes[Cont] with AttributeContainer {
    var a:Int = _
    var b:Boolean = _
    var c:String = _

    var p = new MyValue
    
    def someMethod(i:Int):String = i.toString
    def someOthrMthd() = {
      
    }
    val myconst = "22"
  }
  
  
  @Test
  def testGetVars = {
    val i0 = new Cont
    val vrs = ObjMap.vars(i0)
    
    assertEquals(List[(String,Any)]("a" -> 0, "b" -> false, "p" -> i0.p), vrs.toList.sortBy(_._1))
    
    var i1 = new Cont
    i1.c = "myval"
    val vrs1 = ObjMap.vars(i1)  
      
    assertEquals(List[(String,Any)]("a" -> 0, "b" -> false, "c" -> "myval", "p" -> i1.p), vrs1.toList.sortBy(_._1))
  }
  
  
}