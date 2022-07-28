package com.sorsix.majstor_backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@SpringBootApplication
class MajstorBackendApplication{
    @Bean
    fun passwordEncoder() : PasswordEncoder {
        return BCryptPasswordEncoder(10)
    }

}

fun main(args: Array<String>) {
    runApplication<MajstorBackendApplication>(*args)
}
