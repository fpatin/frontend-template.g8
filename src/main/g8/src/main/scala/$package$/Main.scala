package $package$

import com.raquo.laminar.api.L.*

import org.scalajs.dom

object Main{

  def main(args: Array[String]): Unit = {
    renderOnDomContentLoaded(dom.document.querySelector("#app"), appElement())
  }

  def appElement(): HtmlElement = {
    h1("Hello Vite / Scala!")
  }
}
