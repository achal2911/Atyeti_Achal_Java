package com.test.conditionalstatements;


import java.util.*;

public class MovieTicketBooking {

    static final double REGULAR_PRICE = 200.0;

    static final double PREMIUM_MULTIPLIER = 1.5;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of seats to book: ");
        int seats = sc.nextInt();

        System.out.println("Select Show Timing:");

        System.out.println("1. 10:00 AM");
        System.out.println("2. 1:00 PM");
        System.out.println("3. 6:00 PM");
        System.out.print("Enter choice (1-3): ");

        int choice = sc.nextInt();
        String showTime = "";
        switch (choice) {

            case 1:
                showTime = "10:00 AM";
                break;

            case 2:
                showTime = "1:00 PM";
                break;

            case 3:
                showTime = "6:00 PM";
                break;

            default:

                System.out.println("Invalid show timing selected!");

                return;

        }


        System.out.println("Select Seat Class:");
        System.out.println("1. Regular");
        System.out.println("2. Premium");
        System.out.print("Enter choice (1-2): ");

        int classChoice = sc.nextInt();
        String seatClass = "";
        double pricePerSeat = 0.0;

        switch (classChoice) {

            case 1:

                seatClass = "Regular";

                pricePerSeat = REGULAR_PRICE;

                break;

            case 2:

                seatClass = "Premium";

                pricePerSeat = REGULAR_PRICE * PREMIUM_MULTIPLIER;

                break;

            default:

                System.out.println("Invalid seat class selected!");

                return;

        }


        System.out.println(" Booking Details:");

        System.out.println("Show Time: " + showTime);

        System.out.println("Seat Class: " + seatClass);

        System.out.println("Number of Seats: " + seats);

        System.out.println("Price per Seat: ₹" + pricePerSeat);

        System.out.println("Total Cost: ₹" + (pricePerSeat * seats));

        System.out.println("Seat Numbers:");

        for (int i = 1; i <= seats; i++) {

            System.out.print(seatClass.charAt(0) + "" + (100 + i) + " ");

        }

        System.out.println(" Booking Successful! Enjoy your movie.");

        sc.close();

    }

}

