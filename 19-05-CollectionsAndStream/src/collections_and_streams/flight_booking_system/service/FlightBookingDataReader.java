package collections_and_streams.flight_booking_system.service;

import collections_and_streams.flight_booking_system.model.FlightBookings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class FlightBookingDataReader {
    public static List<FlightBookings> readFlightBookingsData(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        ArrayList<FlightBookings> FlightBookingsArrayList = new ArrayList<>();
        String line = "";

        line = reader.readLine();
        while ((line = reader.readLine()) != null) {
            String[] split = line.split(",");
            FlightBookings FLightBookings = new FlightBookings(split[0], split[1], Date.valueOf(split[2]),Double.parseDouble(split[3]));
            FlightBookingsArrayList.add(FLightBookings);

        }

        return FlightBookingsArrayList;

    }
}
