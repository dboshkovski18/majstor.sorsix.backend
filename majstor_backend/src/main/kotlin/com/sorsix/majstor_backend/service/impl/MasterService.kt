package com.sorsix.majstor_backend.service.impl

import com.sorsix.majstor_backend.domain.City
import com.sorsix.majstor_backend.domain.Master
import com.sorsix.majstor_backend.domain.MasterCity
import com.sorsix.majstor_backend.domain.dtos.MasterDto
import com.sorsix.majstor_backend.domain.enum.Gender
import com.sorsix.majstor_backend.domain.enum.MasterStatus
import com.sorsix.majstor_backend.domain.enum.MasterType
import com.sorsix.majstor_backend.repository.CityRepo
import com.sorsix.majstor_backend.repository.MasterRepo
import com.sorsix.majstor_backend.repository.MasterCityRepo
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class MasterService(val masterRepo: MasterRepo, val master_city_repo: MasterCityRepo, val cityRepo: CityRepo) {

    fun listAllApprovedMasters(): List<Master> = masterRepo.findAllByStatus()

    fun listAllMasters(): List<Master> = masterRepo.findAll()

    fun getMaster(id: Long): Master? {
        if (masterRepo.existsById(id)) {
            return masterRepo.findById(id).get()
        }
        return null
    }

    fun saveMaster(
        masterDto: MasterDto
    ): Master {


        val master: Master = masterRepo.save(
            Master(
                name = masterDto.name,
                surname = masterDto.surname,
                phone_number = masterDto.phone_number,
                embg = masterDto.embg,
                gender = Gender.valueOf(masterDto.gender),
                type = MasterType.valueOf(masterDto.type),
                email = masterDto.email,
                status = MasterStatus.PENDING,
                city = cityRepo.findById(masterDto.city).get()
            )
        )

        val city: City = cityRepo.findById(masterDto.city).get()

        master_city_repo.save(MasterCity(master = master, city = city))

        return master
    }

    fun editMaster(
        id: Long, masterDto: MasterDto
    ): Any {
        if (masterRepo.existsById(id)) {
            val master: Master? = masterRepo.findByIdOrNull(id)


            master?.let {
                master.name = masterDto.name
                master.surname = masterDto.surname
                master.phone_number = masterDto.phone_number
                master.email = masterDto.email
                master.embg = masterDto.embg
                master.gender = Gender.valueOf(masterDto.gender)
                master.type = MasterType.valueOf(masterDto.type)
                master.status = MasterStatus.PENDING
                master.city = cityRepo.findById(masterDto.city).get()

                return masterRepo.save(master)
            }



        }
        return "error"
    }

    fun deleteMaster(id: Long) {
        if (masterRepo.existsById(id)) {
            masterRepo.deleteById(id)
        }
    }

    fun filterMasters(city_id: Long, master_type: String): List<Master> {
//        val master_cities: List<MasterCity> = master_city_repo.getMasterCitiesByCityId(city_id)
        val masters: List<Master> = masterRepo.findAllByCity(cityRepo.findById(city_id).get())
        return masters.filter { it.type.name == master_type && it.status == MasterStatus.APPROVED }
    }

    fun approveMaster(id: Long): Master? {

        val master: Master? = masterRepo.findByIdOrNull(id)
        master?.status = MasterStatus.APPROVED

        master?.let {
            masterRepo.save(master)
        }


        return master
    }

    fun disapproveMaster(id: Long): Master? {

        val master: Master? = masterRepo.findByIdOrNull(id)
        master?.status = MasterStatus.PENDING

        master?.let {
            masterRepo.save(master)
        }

        return master
    }

    fun searchMasterByName(query: String):List<Master>{
        return if(query.isEmpty()){
            masterRepo.findAll()
        }else {
            masterRepo.findAllByNameIsContaining(query)
        }
    }
}