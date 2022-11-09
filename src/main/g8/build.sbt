import org.scalajs.linker.interface.ModuleSplitStyle

val publicDev  = taskKey[String]("output directory for `npm run dev`")
val publicProd = taskKey[String]("output directory for `npm run build`")

lazy val root = project
  .in(file("."))
  .enablePlugins(ScalaJSPlugin)
  .enablePlugins(ScalablyTypedConverterExternalNpmPlugin)
  .settings(
    name         := "$name$",
  )
  .settings(
    scalaVersion := "3.2.1",
    scalacOptions ++= Seq(
      "-deprecation",     // emit warning and location for usages of deprecated APIs
      "-explain",         // explain errors in more detail
      "-explain-types",   // explain type errors in more detail
      "-feature",         // emit warning and location for usages of features that should be imported explicitly
      "-indent",          // allow significant indentation.
      "-new-syntax",      // require `then` and `do` in control expressions.
      "-print-lines",     // show source code line numbers.
      "-unchecked",       // enable additional warnings where generated code depends on assumptions
      "-Ykind-projector", // allow `*` as wildcard to be compatible with kind projector
      "-Xfatal-warnings", // fail the compilation if there are any warnings
      "-Xmigration"       // warn about constructs whose behavior may have changed since version
    )
  )
  .settings(
    libraryDependencies ++= Seq(
      // https://laminar.dev/ https://github.com/raquo/Laminar/tags
      "com.raquo" %%% "laminar" % "0.14.2",
      // https://github.com/kitlangton/animus https://github.com/kitlangton/animus/releases
      "io.github.kitlangton" %%% "animus" % "0.2.2",
      // https://github.com/raquo/Waypoint https://github.com/raquo/Waypoint/tags
      "com.raquo" %%% "waypoint" % "0.5.0",
      // https://github.com/cquiroz/scala-java-time https://github.com/cquiroz/scala-java-time/tags
      "io.github.cquiroz" %%% "scala-java-time" % "2.4.0",
      // https://github.com/softwaremill/sttp https://github.com/softwaremill/sttp/releases
      "com.softwaremill.sttp.client3" %%% "core" % "3.8.3",
      // https://github.com/zio/zio-json https://github.com/zio/zio-json/releases
      "dev.zio" %%% "zio-json" % "0.3.0"
    )
  )
  .settings(
    scalaJSUseMainModuleInitializer := true,
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.ESModule)
        .withModuleSplitStyle(ModuleSplitStyle.SmallModulesFor(List("$package$")))
    },
    externalNpm := {
      baseDirectory.value
    },
    publicDev := linkerOutputDirectory((Compile / fastLinkJS).value).getAbsolutePath,
    publicProd := linkerOutputDirectory((Compile / fullLinkJS).value).getAbsolutePath
  )


def linkerOutputDirectory(v: Attributed[org.scalajs.linker.interface.Report]): File =
  v.get(scalaJSLinkerOutputDirectory.key).getOrElse {
    throw new MessageOnlyException(
      "Linking report was not attributed with output directory. " +
        "Please report this as a Scala.js bug."
    )
  }
