package misk.hibernate

import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Table

@Entity
@Table(name = "actors")
class DbActor() : DbEntity<DbActor> {
  @javax.persistence.Id
  @GeneratedValue
  override lateinit var id: Id<DbActor>

  @Column(nullable = false)
  lateinit var name: String

  @Column
  var birth_date: LocalDate? = null

  constructor(name: String, birthDate: LocalDate?) : this() {
    this.name = name
    this.birth_date = birthDate
  }
}