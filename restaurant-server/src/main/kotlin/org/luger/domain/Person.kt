package org.luger.domain

import org.hibernate.validator.constraints.Email
import org.hibernate.validator.constraints.NotEmpty
import org.jetbrains.annotations.NotNull
import org.springframework.data.jpa.domain.AbstractPersistable
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import javax.persistence.Column
import javax.persistence.MappedSuperclass

/**
 * Created by gerardo8.
 */
@MappedSuperclass
abstract class Person(

    @NotEmpty(message = "First name is required.")
    @Column(nullable = false, columnDefinition = "text")
    var firstName: String = "",

    @NotEmpty(message = "Last name is required.")
    @Column(nullable = false, columnDefinition = "text")
    var lastName: String = "",

    @Email(message = "Please provide a valid email address.")
    @NotEmpty(message = "Email is required.")
    @Column(unique = true, nullable = false, columnDefinition = "text")
    var email: String = "",

    @NotNull
    @Column(name = "BIRTH_DATE", nullable = false)
    var birthDate: LocalDate? = null

) : AbstractPersistable<Long>() {

    fun getAge() : Int = ChronoUnit.YEARS.between(birthDate, LocalDate.now()).toInt()

}
