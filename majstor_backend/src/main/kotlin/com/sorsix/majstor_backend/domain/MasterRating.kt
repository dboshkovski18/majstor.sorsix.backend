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

    @OneToOne
    @JoinColumn(name = "client_id")
    val client: Client,

    @OneToOne
    @JoinColumn(name = "master_id")
    val master: Master
    )