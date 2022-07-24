package com.sorsix.majstor_backend.repository

import com.sorsix.majstor_backend.domain.City
import com.sorsix.majstor_backend.domain.Master
import com.sorsix.majstor_backend.domain.enum.MasterStatus
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MasterRepo : JpaRepository<Master, Long> {

    fun findAllByStatus(status: MasterStatus = MasterStatus.APPROVED): List<Master>

    fun findAllByCity(city_id: City): List<Master>

}