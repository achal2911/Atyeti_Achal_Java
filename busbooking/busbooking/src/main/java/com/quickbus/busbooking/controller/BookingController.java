package com.quickbus.busbooking.controller;

import com.quickbus.busbooking.entity.Booking;
import com.quickbus.busbooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/book")
    public Booking bookTicket(
            @RequestParam Long userId,
            @RequestParam Long scheduleId,
            @RequestParam int seats
    ) {
        return bookingService.bookTicket(userId, scheduleId, seats);
    }

    @DeleteMapping("/cancel/{bookingId}")
    public String cancelBooking(@PathVariable Long bookingId) {
        return bookingService.cancelBooking(bookingId);
    }

    @GetMapping("/user/{userId}")
    public List<Booking> getBookings(@PathVariable Long userId) {
        return bookingService.getBookingsByUser(userId);
    }
}
