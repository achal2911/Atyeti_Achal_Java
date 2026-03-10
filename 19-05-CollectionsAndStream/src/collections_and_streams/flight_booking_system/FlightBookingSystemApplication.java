package collections_and_streams.flight_booking_system;

import collections_and_streams.flight_booking_system.model.FlightBookings;
import collections_and_streams.flight_booking_system.service.FlightBookingDataReader;
import collections_and_streams.flight_booking_system.service.FlightDataOperations;

import java.io.IOException;
import java.util.List;

public class FlightBookingSystemApplication {
    public static void main(String[] args) throws IOException {

        String flightBookingDetailsFilepath="C:\\Users\\Achal Tikale\\IdeaProjects\\Atyeti_Achal_Java\\19-05-CollectionsAndStream\\src\\collections_and_streams\\flight_booking_system\\util\\bookings.csv";

        List<FlightBookings> flightDetails = FlightBookingDataReader.readFlightBookingsData(flightBookingDetailsFilepath);

        //Find the total revenue generated per flight.
        System.out.println("Total Revenue generated per Flight:");
        FlightDataOperations.totalRevenuePerFlight(flightDetails);
        System.out.println("--------------------------------------------------------");

        //List passengers flying on a specific date.
        System.out.println("List passengers flying on a specific date:");
        FlightDataOperations.passengersFlyingOnSpecificDate(flightDetails);
        System.out.println("--------------------------------------------------------");

        //Detect duplicate bookings using passenger name + flightId.
        System.out.println("duplicate bookings using passenger name  and flightId:");
        FlightDataOperations.findDuplicateBookings(flightDetails);



    }
}
