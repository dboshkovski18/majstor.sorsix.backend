package com.sorsix.majstor_backend.repository

import com.sorsix.majstor_backend.domain.MasterCity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MasterCityRepo: JpaRepository<MasterCity, Long> {

    fun getMasterCitiesByCityId(city: Long): List<MasterCity>

}