package com.sorsix.majstor_backend.service.impl

import com.sorsix.majstor_backend.domain.Client
import com.sorsix.majstor_backend.domain.Master
import com.sorsix.majstor_backend.domain.User
import com.sorsix.majstor_backend.domain.dtos.AdminDto
import com.sorsix.majstor_backend.domain.dtos.ClientRegistrationDto
import com.sorsix.majstor_backend.domain.dtos.MasterRegistrationDto
import com.sorsix.majstor_backend.domain.enum.Gender
import com.sorsix.majstor_backend.domain.enum.MasterStatus
import com.sorsix.majstor_backend.domain.enum.MasterType
import com.sorsix.majstor_backend.domain.enum.Role
import com.sorsix.majstor_backend.repository.CityRepo
import com.sorsix.majstor_backend.repository.ClientRepo
import com.sorsix.majstor_backend.repository.MasterRepo
import com.sorsix.majstor_backend.repository.UserRepo
import com.sorsix.majstor_backend.service.UserService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepo: UserRepo, private val passwordEncoder: PasswordEncoder,
    private val masterRepo: MasterRepo, private val clientRepo: ClientRepo,private val cityRepo: CityRepo
) : UserService {

    override fun findUserById(id: Long): User? {
        return this.userRepo.findById(id).get()
    }

    override fun existsByUsername(username: String): Boolean {
        return this.userRepo.existsByUsername(username)
    }

    override fun register(
        adminDto: AdminDto?,
        masterRegistrationDto: MasterRegistrationDto?,
        clientRegistrationDto: ClientRegistrationDto?
    ): Any {
        masterRegistrationDto?.let {
            val master = this.masterRepo.save(
                Master(
                    name=it.name,
                    surname = it.surname,
                    phone_number = it.phone_number,
                    embg = it.embg,
                    gender = Gender.valueOf(it.gender),
                    type = MasterType.valueOf(it.type),
                    email = it.email,
                    status = MasterStatus.PENDING,
                    city = cityRepo.findById(it.city).get()
                )
            )
            return this.userRepo.save(User(username = it.username!!, password = passwordEncoder.encode(it.password), role = it.role!!,master=master))
        }
        clientRegistrationDto?.let {
            val client = this.clientRepo.save(
                Client(
                    name = it.name,
                    surname = it.surname,
                    phone_number = it.phone_number,
                    gender = Gender.valueOf(it.gender),
                    email = it.email,
                    address = it.address
                )
            )
            return this.userRepo.save(User(username = it.username!!, password = passwordEncoder.encode(it.password), role = it.role!!,client=client))
        }

        adminDto.let{
            if (it != null) {
                return this.userRepo.save(User(username = it.username!!, password = passwordEncoder.encode(it.password), role = it.role!!))
            }
        }
        return "error"
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        return this.userRepo.findUserByUsername(username!!)!!
    }
}