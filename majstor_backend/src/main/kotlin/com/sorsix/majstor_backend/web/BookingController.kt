package com.sorsix.majstor_backend.web

import com.sorsix.majstor_backend.domain.Booking
import com.sorsix.majstor_backend.domain.dtos.BookingDto
import com.sorsix.majstor_backend.service.BookingService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin("http://localhost:4200")
class BookingController(val booking_service : BookingService) {

    @GetMapping
    fun listAllBookings() : List<Booking> = booking_service.listAllBookings()

    @GetMapping("/{id}")
    fun getABooking(@PathVariable id: Long): Booking? = booking_service.getABookingById(id)

    @PostMapping("/add")
    fun createABooking(@RequestBody bookingDto: BookingDto): Booking{
        return booking_service.createBooking(bookingDto)
    }

    @PutMapping("/edit/{id}")
    fun editABooking(@PathVariable id: Long, @RequestBody bookingDto: BookingDto): Booking{
        return booking_service.editABooking(id,bookingDto)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteBooking(@PathVariable id: Long) = booking_service.removeBooking(id)

    @GetMapping("/forMaster/{id}")
    fun getAllBookingsForMaster(@PathVariable id: Long): List<Booking> = booking_service.listAllBookingByMaster(id)

    @GetMapping("/forClient/{id}")
    fun getAllBookingsForClient(@PathVariable id: Long): List<Booking> = booking_service.listAllBookingByClient(id)
}