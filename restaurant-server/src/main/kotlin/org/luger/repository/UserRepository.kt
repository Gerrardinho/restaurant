package org.luger.app.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param

/**
 * Created by gerardo8.
 */
interface UserRepository : JpaRepository<User, Long> {

    fun findByEmail(@Param("email")  email: String): User?

    fun findByUsername(@Param("username") username: String) : User?
}
