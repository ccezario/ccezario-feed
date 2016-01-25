import play.PlayImport.PlayKeys
import play.PlayJava
import com.typesafe.sbteclipse.core.EclipsePlugin.EclipseKeys

EclipseKeys.skipParents in ThisBuild := false

name := """ccezario-feed"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

Keys.fork in (Test) := false

libraryDependencies ++= Seq(
  "mysql" % "mysql-connector-java" % "5.1.33",
  "org.mindrot" % "jbcrypt" % "0.3m" withSources() withJavadoc(),
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
  filters
)