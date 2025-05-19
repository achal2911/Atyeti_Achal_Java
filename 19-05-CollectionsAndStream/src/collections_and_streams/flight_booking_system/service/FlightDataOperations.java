package collections_and_streams.flight_booking_system.service;

import collections_and_streams.flight_booking_system.model.FlightDetails;
import collections_and_streams.transaction_analyzer_system.model.Transactions;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlightDataOperations {
    public static void totalRevenuePerFlight(List<FlightDetails> flightDetails) {
        Map<String, Double> totalRevenuePerFlight = flightDetails.stream()
                .collect(Collectors.groupingBy(
                        FlightDetails::getFlightId,
                        Collectors.summingDouble(FlightDetails::getFare)
                ));


        totalRevenuePerFlight.forEach((flightName, totalRevenue) ->
                System.out.println("Flight Name: " + flightName + ", Total Revenue: " + totalRevenue));

    }

    public static void findListOfPassengerByDate(List<FlightDetails> flightDetails) {

    }
}
