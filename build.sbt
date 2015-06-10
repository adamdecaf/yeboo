name := "yeboo"

organization := "org.decaf"

scalaVersion := "2.11.6"

crossScalaVersions ++= Seq("2.10.5", "2.11.6")

// needed for specs2
scalacOptions in Test ++= Seq("-Yrangepos")

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-core" % "3.6.1" % "test"
)
