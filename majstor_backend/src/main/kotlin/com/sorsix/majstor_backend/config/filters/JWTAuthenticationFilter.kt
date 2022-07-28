package com.sorsix.majstor_backend.config.filters

import com.fasterxml.jackson.databind.ObjectMapper
import com.sorsix.majstor_backend.config.generateJwtToken
import com.sorsix.majstor_backend.domain.dtos.UserDto
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class JWTAuthenticationFilter(
    private val aManager: AuthenticationManager,
    private val userDetailsService: UserDetailsService,
    private val passwordEncoder: PasswordEncoder
) : UsernamePasswordAuthenticationFilter() {

    override fun attemptAuthentication(request: HttpServletRequest?, response: HttpServletResponse?): Authentication {
//        val username = request!!.getParameter("username")
//        val password = request.getParameter("password")

        var bulder = ""
        request!!.reader.lines().forEach { bulder += it.toString() }
        val userDTO : UserDto = ObjectMapper().readValue(bulder.trim(), UserDto::class.java)
        println(userDTO.username)

        val username = userDTO.username
        val password = userDTO.password

        val userDetails: UserDetails = userDetailsService.loadUserByUsername(username)
        if (!passwordEncoder.matches(password, userDetails.password)) {
            throw java.lang.RuntimeException("creds is not matched")
        }
        return aManager.authenticate(
            UsernamePasswordAuthenticationToken(
                userDetails.username,
                userDetails.password,
                userDetails.authorities
            )
        )
    }

    override fun successfulAuthentication(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        chain: FilterChain?,
        authResult: Authentication?
    ) {
        val user = authResult?.principal as UserDetails
        val token = generateJwtToken(user)
        response?.contentType = APPLICATION_JSON_VALUE
        ObjectMapper().writeValue(response?.outputStream, mapOf("access_token" to token, "user" to user))
    }

}