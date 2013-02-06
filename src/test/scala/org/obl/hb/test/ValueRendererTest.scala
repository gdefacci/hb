package org.obl.hb.test

import org.junit.Test
import junit.framework.Assert._
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
       assertEquals(p._2, ValueRenderer.quote(p._1))  
     }
  }
  
  object MyEnum extends Enumeration {
    val prop_1, prop2 = Value
  }
  
  class MyClass extends ValueRenderer {
    def render = "custom rendered"
  }
  
  @Test
  def testRender = {
    assertEquals("", ValueRenderer.render(true))
    assertEquals("", ValueRenderer.render(false))
    assertEquals("prop-1", ValueRenderer.render(MyEnum.prop_1))
    assertEquals("prop2", ValueRenderer.render(MyEnum.prop2))
    assertEquals("a", ValueRenderer.render("a"))
    assertEquals("1", ValueRenderer.render(1))
    assertEquals("1.0", ValueRenderer.render(1.0))
    assertEquals("custom rendered", ValueRenderer.render(new MyClass))
    
    
  }

}