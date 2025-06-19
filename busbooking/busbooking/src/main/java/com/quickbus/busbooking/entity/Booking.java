package com.quickbus.busbooking.entity;

import com.quickbus.busbooking.entity.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int seatsBooked;

    private double totalFare;

    @Enumerated(EnumType.STRING) // Store as string in DB (e.g., "BOOKED")
    private BookingStatus status;

    private LocalDateTime bookingTime;

    @ManyToOne
    private User user;

    @ManyToOne
    private Schedule schedule;
}
