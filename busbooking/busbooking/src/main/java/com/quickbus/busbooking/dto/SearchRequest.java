package com.quickbus.busbooking.dto;

import com.quickbus.busbooking.entity.enums.BusType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class SearchRequest {
    private String source;
    private String destination;
    private LocalDate travelDate;
    private String sortBy; // "fare", "departureTime"
    private BusType busType;
}
