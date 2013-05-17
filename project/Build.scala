import sbt.{Node => _, _}

import Keys._
import scala.xml._
import ScriptedPlugin._
import std.TaskExtra._

object PluginBuild extends Build {

	def sharedSettings = Seq[Setting[_]](
		organization := "com.earldouglas",
		credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
	)

	def rootSettings: Seq[Setting[_]] = sharedSettings ++ scriptedSettings ++ Seq(
		sbtPlugin := true,
		name := "xsbt-web-plugin",
		version := "0.2.13-SNAPSHOT",
    crossScalaVersions := Seq("2.9.2", "2.10.0", "2.10.1"),
		libraryDependencies ++= Seq(
			"org.mortbay.jetty" % "jetty" % "6.1.22" % "optional",
			"org.mortbay.jetty" % "jetty-plus" % "6.1.22" % "optional",
			"org.eclipse.jetty" % "jetty-webapp" % "7.5.1.v20110908" % "optional",
			"org.eclipse.jetty" % "jetty-plus" % "7.5.1.v20110908" % "optional",
			"org.apache.tomcat.embed" % "tomcat-embed-core" % "7.0.22" % "optional",
			"org.apache.tomcat.embed" % "tomcat-embed-logging-juli" % "7.0.22" % "optional",
			"org.apache.tomcat.embed" % "tomcat-embed-jasper" % "7.0.22" % "optional"
		),
		scalacOptions += "-deprecation",
		scriptedBufferLog := false
	)

	lazy val root = Project("root", file(".")) settings(rootSettings :_*)
}
