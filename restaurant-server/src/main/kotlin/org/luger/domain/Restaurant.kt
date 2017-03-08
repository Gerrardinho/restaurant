package org.luger.domain

import org.hibernate.validator.constraints.NotEmpty
import org.springframework.data.jpa.domain.AbstractPersistable
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.MappedSuperclass
import javax.persistence.OneToMany

/**
 * Created by gerardo8.
 */
@MappedSuperclass
abstract class Restaurant(

    @NotEmpty
    @Column(nullable = false, columnDefinition = "text")
    val name: String = "",

    @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
    var employees: Set<Employee> = setOf(),

    @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
    var menus: Set<Menu> = setOf()

) : AbstractPersistable<Short>()
