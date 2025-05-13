package com.test.conditionalstatements;

import java.util.Scanner;

//Water Bill Generator Based on Usage Type Write a program to calculate water bill: -
// Input: Water usage in liters and usage type
// (Domestic/Commercial) - Domestic: Rs. 3/ltr for <500, 5 rs. ltr
// for>500 - Commercial: Rs. 8/ltr flat
// Apply surcharge of 10% if bill exceeds Rs. 5000.
// Use if-else and arithmetic operators.
public class WaterBillGenerator {


    public static  void billGenerator(int usage,String usageType){

        double bill=0.0;
        if (usageType.equalsIgnoreCase("Domestic")) {
            if (usage <= 500) {
                bill = usage * 3;
            } else {
                bill = usage * 5;
            }
        } else if (usageType.equalsIgnoreCase("Commercial")) {
            bill = usage * 8;
        } else {
            System.out.println("Invalid usage type entered.");
        }

        // Apply surcharge of 10% if bill > 5000
        if (bill > 5000) {
            double surcharge = bill * 0.10;
            bill += surcharge;
        }

        System.out.println("Total Water Bill: Rs. " + bill);

    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter water usage in ltr :");
        int usage=sc.nextInt();
        System.out.println("Enter water usage type (Domestic/Commercial):");
        String usageType=sc.next();


        billGenerator(usage,usageType);
    }
}
