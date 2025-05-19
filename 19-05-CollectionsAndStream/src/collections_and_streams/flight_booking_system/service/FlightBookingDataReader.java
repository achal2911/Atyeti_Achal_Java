package collections_and_streams.flight_booking_system.service;

import collections_and_streams.flight_booking_system.model.FlightDetails;
import collections_and_streams.transaction_analyzer_system.model.Transactions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class FlightBookingDataReader {
    public static List<FlightDetails> readFlightBookingsData(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        ArrayList<FlightDetails> flightDetailsArrayList = new ArrayList<>();
        String line = "";

        line = reader.readLine();
        while ((line = reader.readLine()) != null) {
            String[] split = line.split(",");
            FlightDetails flightDetails = new FlightDetails(split[0], split[1], Date.valueOf(split[2]),Double.parseDouble(split[3]));
            flightDetailsArrayList.add(flightDetails);

        }

        return flightDetailsArrayList;

    }
}
