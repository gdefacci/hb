import sbt._
import Keys._

object build extends Build {
	val sharedSettings = Defaults.defaultSettings ++ Seq(
		organization := "org.obl",
		version := "0.1",
		scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature"),
		resolvers += "sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
        scalaVersion := "2.10.0",
		libraryDependencies <+= (scalaVersion)(sv => "org.scala-lang" % "scala-reflect" % sv),
        libraryDependencies += "com.novocode" % "junit-interface" % "0.8" % "test",
        testOptions += Tests.Argument(TestFrameworks.JUnit,  "-v")
	)

	val hbProject = Project(
		id = "hb",
		base = file("."),
		settings = sharedSettings
	) 
    
}
