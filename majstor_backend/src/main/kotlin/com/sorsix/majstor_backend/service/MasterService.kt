package com.sorsix.majstor_backend.service

import com.sorsix.majstor_backend.domain.Master
import com.sorsix.majstor_backend.repository.MasterRepo
import org.springframework.stereotype.Service

@Service
class MasterService(val repo: MasterRepo) {

    fun listAllMasters(): List<Master> = repo.findAll()
}