package com.sorsix.majstor_backend.domain.dtos

import com.sorsix.majstor_backend.domain.enum.Role

data class MasterRegistrationDto(
    val username: String? = null,

    val password: String? = null,

    val role: Role? = null,

    val name: String,

    val surname: String,

    val phone_number: String,

    val embg: Long,

    val gender: String,

    val type: String,

    val city: Long,

    val email: String
)
