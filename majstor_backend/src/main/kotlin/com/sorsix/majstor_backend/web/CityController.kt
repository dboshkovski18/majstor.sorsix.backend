package com.sorsix.majstor_backend.web

import com.sorsix.majstor_backend.domain.City
import com.sorsix.majstor_backend.service.impl.CityService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/cities")
class CityController(val city_service: CityService){

    @GetMapping
    fun listAllCities(): List<City> = city_service.listAllCities()

    @GetMapping("/{id}")
    fun getCityById(@PathVariable id: Long): City?= city_service.getCity(id)

}