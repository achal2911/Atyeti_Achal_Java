package com.test.loops;

public class ArmstrongNumber {
    public static void isArmstrong(int num) {
        int original = num;
        int temp = num;
        int digit = 0;

        //counting digit in number
        while (temp > 0) {
            temp = temp / 10;
            digit++;
        }

        int sum = 0;
        temp = num;


        while (temp > 0) {
            int rem = temp % 10;
            sum += Math.pow(rem, digit);
            temp /= 10;
        }

        if (sum == original) {
            System.out.println(original + " is an Armstrong number.");
        } else {
            System.out.println(original + " is not an Armstrong number.");
        }
    }

    public static void main(String[] args) {
        isArmstrong(153);
    }
}
