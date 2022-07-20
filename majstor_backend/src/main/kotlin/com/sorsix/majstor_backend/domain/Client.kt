package com.sorsix.majstor_backend.domain

import com.sorsix.majstor_backend.domain.enum.Gender
import javax.persistence.*


@Entity
@Table(name = "clients")
data class Client(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    val surname: String,
    val email: String,
    val phone_number: String,
    val address: String,

    @Enumerated(value = EnumType.STRING)
    val gender: Gender
)
