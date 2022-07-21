package com.sorsix.majstor_backend.domain

import javax.persistence.*

@Entity
@Table(name = "masters_cities")
data class MasterCity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @OneToOne
    @JoinColumn(name = "master_id")
    val master: Master,

    @OneToOne
    @JoinColumn(name = "city_id")
    val city: City

)
