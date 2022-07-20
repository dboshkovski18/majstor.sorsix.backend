package com.sorsix.majstor_backend.domain

import javax.persistence.*

@Entity
@Table(name = "masters_cities")
data class MasterCity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,


    val master: Long,


    val city: Long

)
