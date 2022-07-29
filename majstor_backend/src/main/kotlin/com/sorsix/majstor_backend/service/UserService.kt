package com.sorsix.majstor_backend.service

import com.sorsix.majstor_backend.domain.User
import com.sorsix.majstor_backend.domain.dtos.AdminDto
import com.sorsix.majstor_backend.domain.dtos.ClientRegistrationDto
import com.sorsix.majstor_backend.domain.dtos.MasterRegistrationDto
import com.sorsix.majstor_backend.domain.enum.Role
import org.springframework.security.core.userdetails.UserDetailsService

interface UserService : UserDetailsService {

    fun findUserById(id: Long): User?

    fun existsByUsername(username: String): Boolean

    fun register(
        adminDto: AdminDto? = null,
        masterRegistrationDto: MasterRegistrationDto? = null,
        clientRegistrationDto: ClientRegistrationDto? = null
    ): Any
}