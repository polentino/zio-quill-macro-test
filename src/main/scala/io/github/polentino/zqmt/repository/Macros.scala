package io.github.polentino.zqmt.repository

import io.getquill.*
import io.getquill.NamingStrategy
import io.getquill.context.qzio.ZioJdbcContext
import io.getquill.context.sql.idiom.SqlIdiom
import zio.*

import javax.sql.DataSource
import scala.quoted.*

object Macros {
  type ZioQuillContext = ZioJdbcContext[? <: SqlIdiom, ? <: NamingStrategy]

  inline def count[T](inline ctx: ZioQuillContext, inline ds: DataSource): ZIO[Any, Throwable, Long] =
    ${ countImpl[T]('ctx, 'ds) }

  private def countImpl[T: Type](ctx: Expr[ZioQuillContext], ds: Expr[DataSource])(using Quotes) =
    '{
      ${ ctx }
        .run(query[T].size)
        .provideEnvironment(ZEnvironment(${ ds }))
    }
}
