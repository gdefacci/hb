package org.obl.hb.test

import org.junit.Test
import junit.framework.Assert._
import org.obl.hb.AttributeRenderer
import org.obl.hb.ValueRenderer

class ValueRendererTest {

  @Test
  def testQuoted = {
    val inp = List(
      "\"kskskd",
      "ksks\'kd",
      "ks\"ks\'kd")

    val exp = List(
      "'\"kskskd'",
      "\"ksks\'kd\"",
      "\"ks&quot;ks\'kd\"")

     inp.zip(exp).foreach { p =>
       assertEquals(p._2, AttributeRenderer.quote(p._1))  
     }
  }
  
  object MyEnum extends Enumeration {
    val prop_1 = Value("prop-1")
    val prop2 = Value
  }
  
  class MyClass extends ValueRenderer {
    def render = "custom rendered"
  }
  
  @Test
  def testRender = {
    assertEquals("", AttributeRenderer.render(true))
    assertEquals("", AttributeRenderer.render(false))
    assertEquals("prop-1", AttributeRenderer.render(MyEnum.prop_1))
    assertEquals("prop2", AttributeRenderer.render(MyEnum.prop2))
    assertEquals("a", AttributeRenderer.render("a"))
    assertEquals("1", AttributeRenderer.render(1))
    assertEquals("1.0", AttributeRenderer.render(1.0))
    assertEquals("custom rendered", AttributeRenderer.render(new MyClass))
    
    
  }

}