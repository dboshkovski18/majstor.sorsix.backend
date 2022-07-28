package com.sorsix.majstor_backend.service.impl

import com.sorsix.majstor_backend.domain.*
import com.sorsix.majstor_backend.domain.dtos.ClientDto
import com.sorsix.majstor_backend.domain.dtos.MasterDto
import com.sorsix.majstor_backend.domain.enum.Gender
import com.sorsix.majstor_backend.domain.enum.MasterType
import com.sorsix.majstor_backend.repository.ClientRepo
import org.springframework.stereotype.Service

@Service
class ClientService(private val clientRepo: ClientRepo) {


    fun listAllClients() : List<Client> = clientRepo.findAll()

    fun getAClientById(id : Long): Client? = clientRepo.findById(id).get()

    fun saveClient(
        clientDto: ClientDto
    ): Client {


        val client: Client = clientRepo.save(
            Client(
                name = clientDto.name,
                surname = clientDto.surname,
                phone_number = clientDto.phone_number,
                gender = Gender.valueOf(clientDto.gender),
                email = clientDto.email,
                address = clientDto.address
            )
        )

        return client
    }

    fun editClient(
        id: Long, clientDto: ClientDto
    ): Client {
        if (clientRepo.existsById(id)) {
            clientRepo.deleteById(id)
        }

        val client: Client = clientRepo.save(
            Client(
                name = clientDto.name,
                surname = clientDto.surname,
                phone_number = clientDto.phone_number,
                gender = Gender.valueOf(clientDto.gender),
                email = clientDto.email,
                address = clientDto.address
            )
        )

        return client
    }

    fun deleteClient(id: Long) {
        if (clientRepo.existsById(id)) {
            clientRepo.deleteById(id)
        }
    }
}