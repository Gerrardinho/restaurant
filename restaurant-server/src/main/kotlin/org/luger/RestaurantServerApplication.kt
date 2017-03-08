package org.luger

import org.luger.app.domain.Authority
import org.luger.app.domain.User
import org.luger.app.domain.UserRepository
import org.luger.domain.MexicanFoodRestaurant
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import java.time.LocalDate

@Controller
@SpringBootApplication
class RestaurantServerApplication {

    @GetMapping("/{path:[^\\.]*}")
    fun redirect() = "forward:/"

    @Bean
    internal fun runner(userRepository: UserRepository, passwordEncoder: PasswordEncoder) = CommandLineRunner {

        val authorities = setOf(Authority("ROLE_USER"), Authority("ROLE_ADMIN"))

        userRepository.deleteAll()
        userRepository.save(User("gerardo8", passwordEncoder.encode("pass"), authorities, "Gerardo", "López", "gerardo.lopezre@gmail.com", LocalDate.of(1993, 8, 26)))

    }
}

fun main(args: Array<String>) {
    SpringApplication.run(RestaurantServerApplication::class.java, *args)
}
