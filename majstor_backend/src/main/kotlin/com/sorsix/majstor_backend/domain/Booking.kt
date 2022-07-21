package com.sorsix.majstor_backend.domain

import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name= "bookings")
data class Booking(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val date: LocalDateTime,

    @OneToOne
    @JoinColumn(name = "master_id")
    val master: Master,

    @OneToOne
    @JoinColumn(name="client_id")
    val client: Client

)
