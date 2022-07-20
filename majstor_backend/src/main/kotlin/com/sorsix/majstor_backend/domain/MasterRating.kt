package com.sorsix.majstor_backend.domain

import com.sorsix.majstor_backend.domain.enum.Recommendation
import javax.persistence.*

@Entity
@Table(name = "rated_masters")
data class MasterRating (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long = 0,

    @Enumerated(value = EnumType.STRING)
    val recommendation: Recommendation,

    val client: Long,

    val master: Long
        )