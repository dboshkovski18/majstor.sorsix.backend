package com.sorsix.majstor_backend.service

import com.sorsix.majstor_backend.domain.Booking
import com.sorsix.majstor_backend.domain.dtos.BookingDto
import com.sorsix.majstor_backend.repository.BookingRepo
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class BookingService(private val bookingRepo: BookingRepo) {

    fun listAllBookings(): List<Booking> = bookingRepo.findAll()

    fun getABookingById(id: Long): Booking? = bookingRepo.findByIdOrNull(id)

    fun createBooking(bookingDto: BookingDto) = bookingRepo.save(
        Booking(
            date = bookingDto.date,
            master = bookingDto.master_id,
            client = bookingDto.client_id
        )
    )

    fun editABooking(id: Long, bookingDto: BookingDto): Booking {

        if (bookingRepo.existsById(id)) {
            bookingRepo.deleteById(id)
        }

        return bookingRepo.save(
            Booking(
                date = bookingDto.date,
                master = bookingDto.master_id,
                client = bookingDto.client_id
            )
        )
    }

    fun removeBooking(id: Long) = bookingRepo.deleteById(id)

    fun listAllBookingByMaster(id: Long) : List<Booking> = bookingRepo.getBookingsByMaster(id)

    fun listAllBookingByClient(id: Long) : List<Booking> = bookingRepo.getBookingsByClient(id)
}