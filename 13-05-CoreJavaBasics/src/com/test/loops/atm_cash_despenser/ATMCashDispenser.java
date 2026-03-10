package com.test.loops.atm_cash_despenser;


public class ATMCashDispenser {

    public static void dispenseCash(int amount) {
        if (amount % 100 != 0) {
            System.out.println("Invalid amount.");
            return;
        }

        int note2000 = 0;
        int note500 = 0;
        int note100 = 0;


        while (amount >= 2000) {
            amount = amount - 2000;
            note2000++;
        }

        while (amount >= 500) {
            amount = amount - 500;
            note500++;
        }

        while (amount >= 100) {
            amount = amount - 100;
            note100++;
        }

        System.out.println("Cash Dispensed:");
        if (note2000 > 0) {
            System.out.println("Rs.2000 notes: " + note2000);
        }
        if (note500 > 0) {
            System.out.println("Rs.500 notes: " + note500);
        }
        if (note100 > 0) {
            System.out.println("Rs.100 notes: " + note100);
        }
    }

    public static void main(String[] args) {
        int amount = 8700;
        dispenseCash(amount);
    }
}
