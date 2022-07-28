package com.sorsix.majstor_backend.config.filters

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.sorsix.majstor_backend.config.JWTAuthConstants
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtAuthorizationFilter(private val authManager: AuthenticationManager,private val userDetailsService: UserDetailsService) :
    BasicAuthenticationFilter(authManager) {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {

        val header: String? = request.getHeader(JWTAuthConstants.HEADER_STRING)
        if (header == null || !header.startsWith(JWTAuthConstants.TOKEN_PREFIX)) {
            chain.doFilter(request, response)
            return
        }
        val username: String = JWT.require(Algorithm.HMAC256(JWTAuthConstants.SECRET.encodeToByteArray()))
            .build()
            .verify(header.replace(JWTAuthConstants.TOKEN_PREFIX, ""))
            .subject ?: return

       val userDetails : UserDetails = this.userDetailsService.loadUserByUsername(username)
        val token = UsernamePasswordAuthenticationToken(
            userDetails.username,
            userDetails.authorities
        )
        SecurityContextHolder.getContext().authentication = token
        chain.doFilter(request, response)
    }
}