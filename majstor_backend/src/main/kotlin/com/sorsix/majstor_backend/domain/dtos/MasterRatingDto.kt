package com.sorsix.majstor_backend.domain.dtos

import com.sorsix.majstor_backend.domain.enum.Recommendation

data class MasterRatingDto(
    val recommendation: String,

    val client: Long,

    val master: Long
)
