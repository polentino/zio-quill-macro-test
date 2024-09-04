package io.github.polentino.zqmt

import io.github.polentino.zqmt.repository.DummyMacroRepository
import zio.*

object Main extends ZIOAppDefault {

  private val app =
    ZIO
      .serviceWith[DummyMacroRepository](_.count)
      .unit

  override def run: ZIO[ZIOAppArgs & Scope, Throwable, Unit] =
    app.provideLayer(DummyMacroRepository.layer)
}
