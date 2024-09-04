# zio-quill-macro-test

Minimal compiling example that uses Scala 3 macros to help generate boilerplate quill code for a `Repository[T]`.
Reason for building this test repo: see [thread on twitter](https://x.com/polentino911/status/1831086796991844635).


## Rationale

In quite some personal projects im working on, I noticed a recurring pattern regarding the structure of Repositories to
perform CRUD operations on given entities, especially when the operations are relatively simple (upsert, find,
delete, ..).

This gave me the idea to create a generic `Repository[T]` which, with the help of Scala 3 macros, would generate the
code for each of these methods: the idea is that I would simply write something like

```scala 3
final case class MyCustomRepositoryLive(/*some deps here*/)
  extends Repository[DummyEntity]
```

and the compiler would do the rest of the magic, without any extra intervention by the developer.

In this project I've only implemented for brevity only one
[macro](src/main/scala/io/github/polentino/zqmt/repository/Macros.scala), `count`, and then
defined a [DummyMacroRepository](src/main/scala/io/github/polentino/zqmt/repository/DummyMacroRepository.scala) to count
the occurrencies of `DummyEntity`.

It would be nicer if the query was generated at compile time but, no matter how I tried, only dynamic ones were
generated so far:

```
[info] 17 |    Macros.count[DbItem[T]](quillContext, dataSource)
[info]    |    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
[info]    |    Dynamic Query Detected (compiled in 5ms)
```
