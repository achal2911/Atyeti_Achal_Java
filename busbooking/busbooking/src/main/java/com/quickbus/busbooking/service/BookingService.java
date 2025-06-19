package com.quickbus.busbooking.service;

import com.quickbus.busbooking.entity.Booking;
import com.quickbus.busbooking.entity.Schedule;
import com.quickbus.busbooking.entity.User;
import com.quickbus.busbooking.entity.enums.BookingStatus;
import com.quickbus.busbooking.exception.ScheduleNotFoundException;
import com.quickbus.busbooking.exception.SeatsNotAvailableException;
import com.quickbus.busbooking.exception.UserNotFoundException;
import com.quickbus.busbooking.repository.BookingRepository;
import com.quickbus.busbooking.repository.BusRepository;
import com.quickbus.busbooking.repository.ScheduleRepository;
import com.quickbus.busbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    public Booking bookTicket(Long userId, Long scheduleId, int seats) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found with given Id"));
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(() -> new ScheduleNotFoundException("Bus not found with Id " + scheduleId));

        if (schedule.getAvailableSeats() < seats) {
            throw new SeatsNotAvailableException("Not enough seats available.");
        }

        // Deduct seats
        schedule.setAvailableSeats(schedule.getAvailableSeats() - seats);
        scheduleRepository.save(schedule);

        double totalFare = schedule.getBusFare() * seats;

        Booking booking = Booking.builder()
                .user(user)
                .schedule(schedule)
                .seatsBooked(seats)
                .totalFare(totalFare)
                .status(BookingStatus.BOOKED)
                .bookingTime(LocalDateTime.now())
                .build();

        return bookingRepository.save(booking);
    }

    public String cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow();

        if (booking.getStatus().equals(BookingStatus.CANCELLED)) {
            return "Booking is already cancelled.";
        }

        booking.setStatus(BookingStatus.CANCELLED);

        // Restore seats
        Schedule schedule = booking.getSchedule();
        schedule.setAvailableSeats(schedule.getAvailableSeats() + booking.getSeatsBooked());

        scheduleRepository.save(schedule);
        bookingRepository.save(booking);

        return "Booking cancelled successfully.";
    }

    public List<Booking> getBookingsByUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return bookingRepository.findByUser(user);
    }
}
