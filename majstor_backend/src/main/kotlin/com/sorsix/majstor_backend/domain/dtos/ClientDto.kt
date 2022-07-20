package com.sorsix.majstor_backend.domain.dtos

import com.sorsix.majstor_backend.domain.enum.Gender
import javax.persistence.EnumType
import javax.persistence.Enumerated

data class ClientDto(
    val name: String,
    val surname: String,
    val email: String,
    val phone_number: String,
    val gender: String,
    val address: String
)
