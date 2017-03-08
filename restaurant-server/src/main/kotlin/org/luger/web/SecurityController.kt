package org.luger.app.web

import org.luger.app.domain.User
import org.luger.app.domain.UserRepository
import org.luger.app.security.UserDetailsImpl
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by gerardo8.
 */
@RestController
class SecurityController {

    @GetMapping("/principal")
    fun currentPrincipal(@AuthenticationPrincipal userDetails: UserDetailsImpl): ResponseEntity<UserDetailsImpl> {
        return ResponseEntity.ok(userDetails)
    }
}