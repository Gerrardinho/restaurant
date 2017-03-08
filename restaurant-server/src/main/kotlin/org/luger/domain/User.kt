package org.luger.app.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.validator.constraints.Email
import org.hibernate.validator.constraints.NotEmpty
import org.luger.domain.Person
import org.springframework.data.jpa.domain.AbstractPersistable
import java.io.Serializable
import java.time.LocalDate
import javax.persistence.*

/**
 * Created by gerardo8.
 */
@Entity
class User(

    @NotEmpty(message = "Username is required.")
    @Column(unique = true, nullable = false, columnDefinition = "TEXT")
    var username: String = "",

    @NotEmpty(message = "Password is required.")
    @Column(nullable = false, columnDefinition = "TEXT")
    @JsonIgnore
    var password: String = "",

    @ManyToMany(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_authority",
        joinColumns = arrayOf(JoinColumn(name = "user_id")),
        inverseJoinColumns = arrayOf(JoinColumn(name = "authority_id"))
    )
    var authorities: Set<Authority> = setOf(),

    firstName: String = "",

    lastName: String = "",

    email: String = "",

    birthDate: LocalDate? = null


) : Person(firstName, lastName, email, birthDate)
