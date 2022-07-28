package com.sorsix.majstor_backend.web

import com.sorsix.majstor_backend.domain.City
import com.sorsix.majstor_backend.domain.Master
import com.sorsix.majstor_backend.domain.dtos.MasterDto
import com.sorsix.majstor_backend.domain.enum.MasterType
import com.sorsix.majstor_backend.service.impl.MasterCityService
import com.sorsix.majstor_backend.service.impl.MasterRatingService
import com.sorsix.majstor_backend.service.impl.MasterService
import org.springframework.web.bind.annotation.*
import javax.annotation.security.RolesAllowed

@RestController
@RequestMapping("/api/masters")
class MasterController(
    val master_service: MasterService,
    val master_city_service: MasterCityService,
    val master_rating_service: MasterRatingService
) {

    @GetMapping
    fun getAllMasters(): List<Master> = master_service.listAllMasters()

    @GetMapping("/approved")
    fun getApprovedMasters(): List<Master> = master_service.listAllApprovedMasters()

    @GetMapping("/{id}")
    fun getAMaster(@PathVariable id: Long): Master? {
        return master_service.getMaster(id)
    }

    @PostMapping("/add")
    fun saveAMaster(@RequestBody masterDto: MasterDto): Master {
        return master_service.saveMaster(masterDto)
    }

    @PutMapping("/edit/{id}")
    fun editAMaster(@PathVariable id: Long, @RequestBody masterDto: MasterDto): Any {
        println(id)
        return master_service.editMaster(id, masterDto)
    }

    @DeleteMapping("/delete/{id}")
    fun removeAMaster(@PathVariable id: Long) = master_service.deleteMaster(id)


    @GetMapping("/fromCity/{id}")
    fun listMastersByCity(@PathVariable id: Long): List<Master> {
        return master_city_service.listMastersByCity(id)
    }

    @GetMapping("/recommendations/{id}")
    fun getRecommendationsByMaster(@PathVariable id: Long): Int {
        return master_rating_service.getRecommendationsByMaster(id)
    }

    @GetMapping("/types")
    fun getMasterTypes(): List<MasterType> = MasterType.values().toList()


    @GetMapping("/filter")
    fun filterMastersByProfessionAndCity(@RequestParam city_id: Long, @RequestParam master_type: String): List<Master> {
        return master_service.filterMasters(city_id,master_type)
    }

    @GetMapping("/approve/{id}")
    fun approveMaster(@PathVariable id: Long): Master? = master_service.approveMaster(id)

    @GetMapping("/disapprove/{id}")
    fun disapproveMaster(@PathVariable id: Long): Master? = master_service.disapproveMaster(id)

    @GetMapping("{id}/city")
    fun getCitiesOfMaster(@PathVariable id: Long): List<City> = master_city_service.getCitiesByMaster(id)

    @GetMapping("/search")
    fun searchMastersByName(@RequestParam query: String):List<Master>{
        return master_service.searchMasterByName(query)
    }

}