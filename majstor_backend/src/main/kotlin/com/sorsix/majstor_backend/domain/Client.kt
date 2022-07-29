package com.sorsix.majstor_backend.domain

import com.sorsix.majstor_backend.domain.enum.Gender
import javax.persistence.*


@Entity
@Table(name = "clients")
data class Client(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    var name: String,
    var surname: String,
    var email: String,
    var phone_number: String,
    var address: String,

    @Enumerated(value = EnumType.STRING)
    var gender: Gender
)
