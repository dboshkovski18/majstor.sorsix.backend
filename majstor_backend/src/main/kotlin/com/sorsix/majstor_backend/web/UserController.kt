package com.sorsix.majstor_backend.web

import com.sorsix.majstor_backend.domain.dtos.ClientDto
import com.sorsix.majstor_backend.domain.dtos.ClientRegistrationDto
import com.sorsix.majstor_backend.domain.dtos.MasterDto
import com.sorsix.majstor_backend.domain.dtos.MasterRegistrationDto
import com.sorsix.majstor_backend.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
class UserController(private val userService: UserService) {

    @PostMapping("/registerClient")
    fun registerUser(@RequestBody client: ClientRegistrationDto): Any {
        return userService.register(clientRegistrationDto = client)
    }

    @PostMapping("/registerMaster")
    fun registerMaster(@RequestBody master : MasterRegistrationDto) : Any {
        return userService.register(masterRegistrationDto = master)
    }
}