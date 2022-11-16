package $package$

import be.doeraene.webcomponents.ui5.*
import be.doeraene.webcomponents.ui5.configkeys.*
import com.raquo.laminar.api.L.*
import org.scalajs.dom

import java.time.LocalDateTime

object Main{

  def main(args: Array[String]): Unit = {
    renderOnDomContentLoaded(dom.document.querySelector("#app"), appElement())
  }

  def appElement(): HtmlElement = {
    div(
      h1("Hello Vite / Scala!"),
      p(s"\${LocalDateTime.now()}"),
      Badge(_.colourScheme := ColourScheme._1, _.slots.icon := Icon(_.name := IconName.add), "Add")
    )
  }
}
