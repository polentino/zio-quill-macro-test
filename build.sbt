import sbt.Keys.libraryDependencies

import scala.collection.Seq

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / semanticdbEnabled := true
ThisBuild / semanticdbVersion := scalafixSemanticdb.revision
ThisBuild / scalaVersion := "3.3.3"

val zioVersion = "2.1.6"
val quillJdbcZioVersion = "4.8.4"

lazy val root = (project in file("."))
  .settings(
    name := "zio-quill-macro-test",
      libraryDependencies ++= Seq(
      "dev.zio"       %% "zio"                 % zioVersion,
      "io.getquill"   %% "quill-jdbc-zio"      % quillJdbcZioVersion,
      "dev.zio"       %% "zio-test"            % zioVersion % Test,
      "dev.zio"       %% "zio-test-sbt"        % zioVersion % Test,
      "dev.zio"       %% "zio-test-magnolia"   % zioVersion % Test
    )
  )
