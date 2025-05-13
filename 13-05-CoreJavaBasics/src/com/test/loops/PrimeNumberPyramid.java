package com.test.loops;

public class PrimeNumberPyramid {

    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int rows = 4;

        int currentNumber = 2;
        for (int i = 1; i <= rows; i++) {
            int count = 0;
            while (count < i) {
                if (isPrime(currentNumber)) {
                    System.out.print(currentNumber + " ");
                    count++;
                }
                currentNumber++;
            }
            System.out.println();
        }
    }
}