package com.sorsix.majstor_backend.domain.dtos

import com.sorsix.majstor_backend.domain.enum.Role

data class ClientRegistrationDto(
    val username: String? = null,
    val password: String? = null,
    val role: Role? = null,
    val name: String,
    val surname: String,
    val email: String,
    val phone_number: String,
    val gender: String,
    val address: String
)
