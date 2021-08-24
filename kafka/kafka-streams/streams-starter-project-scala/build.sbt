name := "streams-starter-project-scala"

version := "0.1"

scalaVersion := "3.0.1"

idePackagePrefix := Some("com.github.muhdlaziem.udemy.kafka.streams")

// https://mvnrepository.com/artifact/org.apache.kafka/kafka-streams
libraryDependencies += "org.apache.kafka" % "kafka-streams" % "2.8.0"
// https://mvnrepository.com/artifact/org.slf4j/slf4j-api
libraryDependencies += "org.slf4j" % "slf4j-api" % "1.7.32"
// https://mvnrepository.com/artifact/org.slf4j/slf4j-log4j12
libraryDependencies += "org.slf4j" % "slf4j-log4j12" % "1.7.32"

 assembly / assemblyMergeStrategy:= {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}

//assembly / assemblyJarName := "count" + version + ".jar"
//// leverage java 8
//javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")
//scalacOptions := Seq("-target:jvm-1.8")
//initialize := {
//  val _ = initialize.value
//  if (sys.props("java.specification.version") != "1.8")
//    sys.error("Java 8 is required for this project.")
//}