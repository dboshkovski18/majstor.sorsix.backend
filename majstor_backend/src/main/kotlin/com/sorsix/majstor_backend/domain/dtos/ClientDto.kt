package com.sorsix.majstor_backend.domain.dtos

data class ClientDto(
    val name: String = "",
    val surname: String = "",
    val email: String = "",
    val phone_number: String = "",
    val gender: String="",
    val address: String =""
)
