package com.sorsix.majstor_backend.config

class JWTAuthConstants(
) {
    companion object {
        const val EXPIRATION_TIME : Long = 864_000_000 // 10 days
        const val SECRET : String = "s3cr3tk3y"
        const val HEADER_STRING : String = "Authorization"
        const val TOKEN_PREFIX : String = "Bearer "
    }
}