package com.sorsix.majstor_backend.domain.dtos

import com.sorsix.majstor_backend.domain.enum.Role

class UserDto(val username:String? = null , val password:String? = null , val role: Role?=null) {
}