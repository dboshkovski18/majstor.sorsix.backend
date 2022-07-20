package com.sorsix.majstor_backend.domain.dtos

data class MasterDto(val name: String,

                     val surname: String,

                     val phone_number: String,

                     val embg: Long,

                     val gender: String,

                     val rating: Float,

                     val type: String,

                     val city: Long,

                     val email: String
)
