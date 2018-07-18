name := "PCR1-LR_Decoder"

version := "0.1"

scalaVersion := "2.12.6"

libraryDependencies ++= {
  Seq(
    "io.spray" %% "spray-json" % "1.3.4",
    "commons-codec" % "commons-codec" % "1.11",
    "ch.qos.logback" % "logback-classic" % "1.2.3",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.0",
    "org.scalatest" %% "scalatest" % "3.0.5" % "test"
  )
}