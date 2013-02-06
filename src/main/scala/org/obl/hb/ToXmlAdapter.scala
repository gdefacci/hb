package org.obl.hb

trait ToXmlAdapter[T] {
def apply(el:Elem):T
}