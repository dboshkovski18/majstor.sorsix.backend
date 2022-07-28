package com.sorsix.majstor_backend.config

import com.sorsix.majstor_backend.service.UserService
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class CustomUsernameAndPasswordAuthenticationProvider(private val userService: UserService,private val passwordEncoder: PasswordEncoder) : AuthenticationProvider {

    override fun authenticate(authentication: Authentication?): Authentication {

        val username : String? = authentication?.name
        val password : String = authentication?.credentials.toString()

        val userDetails : UserDetails = this.userService.loadUserByUsername(username)

        return UsernamePasswordAuthenticationToken(userDetails,userDetails.password,userDetails.authorities)
    }

    override fun supports(authentication: Class<*>?): Boolean {
        return authentication!!.equals(UsernamePasswordAuthenticationToken::class.java)
    }
}