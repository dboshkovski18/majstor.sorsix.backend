package com.sorsix.majstor_backend.repository

import com.sorsix.majstor_backend.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepo : JpaRepository<User, Long> {

    fun findUserByUsername(username: String): User?

    fun existsByUsername(username: String): Boolean
}