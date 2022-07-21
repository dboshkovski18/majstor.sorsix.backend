package com.sorsix.majstor_backend.service

import com.sorsix.majstor_backend.domain.Master
import com.sorsix.majstor_backend.domain.MasterCity
import com.sorsix.majstor_backend.repository.MasterCityRepo
import com.sorsix.majstor_backend.repository.MasterRepo
import org.springframework.stereotype.Service

@Service
class MasterCityService (val masterCityRepo: MasterCityRepo, val masterRepo: MasterRepo){

    fun listMastersByCity(city: Long): List<Master> {
        val masters_cities: List<MasterCity> = masterCityRepo.getMasterCitiesByCityId(city)

        return masterRepo.findAllById(masters_cities.map { it.master.id }.toList())
    }
}