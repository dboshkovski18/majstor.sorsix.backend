package com.sorsix.majstor_backend.repository


import com.sorsix.majstor_backend.domain.Client
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClientRepo : JpaRepository<Client,Long>{
}