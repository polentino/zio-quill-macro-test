package io.github.polentino.zqmt

import java.time.LocalDateTime

package object repository {

  final case class DbItem[T](
    id: Long,
    item: T,
    version: Long,
    created: LocalDateTime,
    updated: LocalDateTime)

  final case class DummyEntity(score: Long, age: Int)
}
