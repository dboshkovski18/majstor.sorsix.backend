package com.sorsix.majstor_backend.domain

import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name= "bookings")
data class Booking(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val date: LocalDateTime,

    @ManyToOne()
    val master: Master

)
