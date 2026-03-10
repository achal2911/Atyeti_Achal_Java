package com.test.loops;

import java.util.Scanner;

public class FirstNPrimeNumbers {
    public static boolean isPrime(int num) {
        if (num < 2) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }

        }
        return true;


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter how many prime numbers you want: ");
        int n = scanner.nextInt();

        int count = 0;
        int num = 2;

        System.out.println("\nFirst " + n + " prime numbers:");
        while (count < n) {
            if (isPrime(num)) {
                System.out.print(num + " ");
                count++;
            }
            num++;
        }

    }
}
