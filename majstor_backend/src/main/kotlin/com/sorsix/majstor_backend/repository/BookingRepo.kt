package com.sorsix.majstor_backend.repository

import com.sorsix.majstor_backend.domain.Booking
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookingRepo : JpaRepository<Booking, Long> {

    fun getBookingsByMasterId(id : Long) : List<Booking>

    fun getBookingsByClientId(id : Long) : List<Booking>

}