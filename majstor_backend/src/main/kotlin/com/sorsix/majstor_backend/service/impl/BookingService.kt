package com.sorsix.majstor_backend.service.impl

import com.sorsix.majstor_backend.domain.Booking
import com.sorsix.majstor_backend.domain.dtos.BookingDto
import com.sorsix.majstor_backend.repository.BookingRepo
import com.sorsix.majstor_backend.repository.ClientRepo
import com.sorsix.majstor_backend.repository.MasterRepo
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class BookingService(
    private val bookingRepo: BookingRepo,
    private val masterRepo: MasterRepo,
    private val clientRepo: ClientRepo
) {

    fun listAllBookings(): List<Booking> = bookingRepo.findAll()

    fun getABookingById(id: Long): Booking? = bookingRepo.findByIdOrNull(id)

    fun createBooking(bookingDto: BookingDto) = bookingRepo.save(
        Booking(
            date = bookingDto.date,
            master = masterRepo.findById(bookingDto.master_id).get(),
            client = clientRepo.findById(bookingDto.client_id).get()
        )
    )

    fun editABooking(id: Long, bookingDto: BookingDto): Booking {

        if (bookingRepo.existsById(id)) {
            bookingRepo.deleteById(id)
        }

        return bookingRepo.save(
            Booking(
                date = bookingDto.date,
                master = masterRepo.findById(bookingDto.master_id).get(),
                client = clientRepo.findById(bookingDto.client_id).get()
            )
        )
    }

    fun removeBooking(id: Long) = bookingRepo.deleteById(id)

    fun listAllBookingByMaster(id: Long): List<Booking> = bookingRepo.getBookingsByMasterId(id)

    fun listAllBookingByClient(id: Long): List<Booking> = bookingRepo.getBookingsByClientId(id)
}