package io.github.polentino.zqmt.repository

import io.github.polentino.zqmt.repository.Macros.ZioQuillContext
import javax.sql.DataSource
import zio.*
import io.getquill.*

trait DummyMacroRepository extends Repository[DummyEntity]

object DummyMacroRepository {

  final case class Live() extends DummyMacroRepository {
    protected val dataSource: DataSource = null // should be injected in a real, working application
    protected val quillContext: ZioQuillContext = null // should be injected in a real, working application
  }

  val layer: ULayer[DummyMacroRepository] = ZLayer.succeed(Live())
}
