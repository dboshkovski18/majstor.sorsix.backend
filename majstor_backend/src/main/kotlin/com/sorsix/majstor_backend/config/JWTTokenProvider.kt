package com.sorsix.majstor_backend.config

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.sorsix.majstor_backend.config.JWTAuthConstants.Companion.EXPIRATION_TIME
import com.sorsix.majstor_backend.config.JWTAuthConstants.Companion.HEADER_STRING
import com.sorsix.majstor_backend.config.JWTAuthConstants.Companion.SECRET
import org.springframework.security.core.userdetails.UserDetails
import java.util.*

fun generateJwtToken(user: UserDetails): String {
    val algorithm = Algorithm.HMAC256(SECRET)
    return JWT.create()
        .withSubject(user.username)
        .withExpiresAt(Date(System.currentTimeMillis() + EXPIRATION_TIME))
        .withIssuer(HEADER_STRING)
        .withClaim("roles", user.authorities.map { it.authority }.toList())
        .sign(algorithm)
}