package com.sorsix.majstor_backend.web

import com.sorsix.majstor_backend.domain.Client
import com.sorsix.majstor_backend.domain.MasterRating
import com.sorsix.majstor_backend.domain.dtos.ClientDto
import com.sorsix.majstor_backend.domain.dtos.MasterRatingDto
import com.sorsix.majstor_backend.service.ClientService
import com.sorsix.majstor_backend.service.MasterRatingService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/clients")
class ClientController(val client_service: ClientService, val master_rating_service: MasterRatingService){


    @GetMapping
    fun listAllClients(): List<Client> = client_service.listAllClients()

    @GetMapping("/{id}")
    fun getClientById(@PathVariable id: Long) : Client? = client_service.getAClientById(id)

    @PostMapping("/add")
    fun addClient(@RequestBody clientDto: ClientDto): Client{
        return client_service.saveClient(clientDto)
    }

    @PutMapping("/edit/{id}")
    fun editClient(@PathVariable id: Long, @RequestBody clientDto: ClientDto): Client{
        return client_service.editClient(id, clientDto)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteClient(@PathVariable id: Long) = client_service.deleteClient(id)

    @PostMapping("/rate")
    fun rateMaster(@RequestBody rateDto: MasterRatingDto): MasterRating{
        return master_rating_service.rate(rateDto)
    }
}