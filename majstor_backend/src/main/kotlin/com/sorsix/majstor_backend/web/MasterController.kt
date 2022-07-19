package com.sorsix.majstor_backend.web

import com.sorsix.majstor_backend.domain.Master
import com.sorsix.majstor_backend.service.MasterService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/masters")
class MasterController (val service: MasterService){

    @GetMapping
    fun getAllMasters(): List<Master> = service.listAllMasters()


}