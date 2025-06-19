package com.quickbus.busbooking.entity;


import com.quickbus.busbooking.entity.enums.BusType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bus
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String busName;

    @Enumerated(EnumType.STRING)  // Store enum as String in DB (recommended)
    private BusType busType;

    private int totalSeats;
}


