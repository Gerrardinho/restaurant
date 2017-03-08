package org.luger.app.security

import com.fasterxml.jackson.annotation.JsonIgnore
import org.luger.app.domain.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails

/**
 * Created by gerardo8.
 */
class UserDetailsImpl(
        val user: User? = null,
        var authorities: List<GrantedAuthority> = listOf()
) : UserDetails {

    init {
        authorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList(user?.authorities?.joinToString{ it.authority })
    }

    override fun getUsername() = this.user?.username

    override fun isCredentialsNonExpired() = true

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun getAuthorities(): Collection<GrantedAuthority> = this.authorities

    override fun isEnabled() = true

    @JsonIgnore
    override fun getPassword() = this.user?.password
}
