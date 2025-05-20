package collections_and_streams.flight_booking_system.model;

import java.util.Date;

public class FlightBookings {
    private String flightId;
    private String passengerName;
    private Date date;
    private double fare;

    public FlightBookings(String flightId, String passengerName, Date date, double fare) {
        this.flightId = flightId;
        this.passengerName = passengerName;
        this.date = date;
        this.fare = fare;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    @Override
    public String toString() {
        return
                "flightId=" + flightId +
                ", passengerName='" + passengerName +
                ", date=" + date +
                ", fare=" + fare ;
    }
}
