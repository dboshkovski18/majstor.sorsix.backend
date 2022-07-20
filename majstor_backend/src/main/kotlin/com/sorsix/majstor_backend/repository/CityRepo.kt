package com.sorsix.majstor_backend.repository

import com.sorsix.majstor_backend.domain.City
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CityRepo: JpaRepository<City, Long> {
}