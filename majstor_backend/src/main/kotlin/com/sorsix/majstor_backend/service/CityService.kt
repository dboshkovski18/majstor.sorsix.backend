package com.sorsix.majstor_backend.service

import com.sorsix.majstor_backend.domain.City
import com.sorsix.majstor_backend.repository.CityRepo
import org.springframework.stereotype.Service

@Service
class CityService(private val cityRepo: CityRepo) {


    fun listAllCities() : List<City> = cityRepo.findAll()

    fun getCity(id: Long) : City? = cityRepo.findById(id).get()

}