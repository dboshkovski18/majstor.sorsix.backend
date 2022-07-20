package com.sorsix.majstor_backend.domain.dtos

import java.time.LocalDateTime

data class BookingDto(

    val date: LocalDateTime,

    val master_id: Long,

    val client_id: Long
)
