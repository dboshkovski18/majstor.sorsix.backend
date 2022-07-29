package com.sorsix.majstor_backend.domain.dtos

import com.sorsix.majstor_backend.domain.enum.Role

data class AdminDto(
    val username: String? = null,

    val password: String? = null,

    val role: Role? = null,

    )
