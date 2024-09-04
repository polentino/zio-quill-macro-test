package io.github.polentino.zqmt.repository

import io.getquill.*
import io.github.polentino.zqmt.repository.Macros.ZioQuillContext
import zio.*

import javax.sql.DataSource

trait Repository[T: Tag] {
  protected val dataSource: DataSource
  // here should go a `Literal` that transforms the table name from `db_item` to whatever name `T` is
  protected val quillContext: ZioQuillContext

  import quillContext.*

  def count: ZIO[Any, Throwable, Long] =
    Macros.count[DbItem[T]](quillContext, dataSource)

  // rest of crud operations go here ...
}
