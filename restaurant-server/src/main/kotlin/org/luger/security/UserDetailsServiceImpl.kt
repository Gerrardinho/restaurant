package org.luger.app.security

import org.luger.app.domain.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

/**
 * Created by gerardo8.
 */
@Service
class UserDetailsServiceImpl(val userRepository: UserRepository) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {

        val user = userRepository.findByUsername(username)
                ?: userRepository.findByEmail(username)
                ?: throw UsernameNotFoundException("Could not find user $username")

        return UserDetailsImpl(user)
    }
}