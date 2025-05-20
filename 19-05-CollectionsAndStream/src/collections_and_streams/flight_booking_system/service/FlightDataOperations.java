package collections_and_streams.flight_booking_system.service;

import collections_and_streams.flight_booking_system.model.FlightBookings;

import java.util.*;
import java.util.stream.Collectors;

public class FlightDataOperations {
    public static void totalRevenuePerFlight(List<FlightBookings> flightDetails) {
        Map<String, Double> totalRevenuePerFlight = flightDetails.stream()
                .collect(Collectors.groupingBy(
                        FlightBookings::getFlightId,
                        Collectors.summingDouble(FlightBookings::getFare)
                ));


        totalRevenuePerFlight.forEach((flightName, totalRevenue) ->
                System.out.println("Flight Name: " + flightName + ", Total Revenue: " + totalRevenue));

    }

    public static void passengersFlyingOnSpecificDate(List<FlightBookings>bookings)
    {
        Map<Date, List<String>> listOfPassengersFlyingOnSpecificDate= bookings.stream()
                .collect(Collectors.groupingBy(FlightBookings::getDate, Collectors.mapping(FlightBookings::getPassengerName, Collectors.toList())));

        listOfPassengersFlyingOnSpecificDate.forEach((date,listOfPassenger)->
                System.out.println("Date :"+date +"\n listOfPassengers :"+listOfPassenger));
    }


    public static void findDuplicateBookings(List<FlightBookings> bookings) {
        Set<String> seen = new HashSet<>();
        List<FlightBookings> duplicatesBooking= bookings.stream()
                .filter(b -> !seen.add(b.getPassengerName() + "_" + b.getFlightId()))
                .toList();

        duplicatesBooking.forEach(System.out::println);
    }
}
