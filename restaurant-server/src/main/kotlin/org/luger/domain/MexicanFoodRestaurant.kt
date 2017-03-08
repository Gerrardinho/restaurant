package org.luger.domain

import javax.persistence.AttributeOverride
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

/**
 * Created by gerardo8.
 */
@Entity
@Table(name = "mexican_food_restaurant")
class MexicanFoodRestaurant(
    name: String = "",
    employees: Set<Employee> = setOf(),
    menus: Set<Menu> = setOf()

) : Restaurant(name, employees, menus)
