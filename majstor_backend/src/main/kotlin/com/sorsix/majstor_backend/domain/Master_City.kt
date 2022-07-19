package com.sorsix.majstor_backend.domain

import javax.persistence.*

@Entity
@Table(name = "masters_cities")
data class Master_City(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @OneToOne
    val master_id: Master,

    @OneToOne
    val city_id: City

)
