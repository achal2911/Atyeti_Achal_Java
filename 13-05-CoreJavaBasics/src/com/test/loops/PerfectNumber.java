package com.test.loops;

import java.util.Scanner;

//Check whether a number is a perfect number.
//perfect number=a positive integer where the sum of its proper divisors
// (divisors excluding the number itself) equals the number itself
//e.6 6, 28, 496, 8128, and 33550336
public class PerfectNumber {
    public static boolean isPerfectNumber(int num)
    {
        int sum=0;
        for(int i=1;i<num;i++)
        {
            if( num%i==0)
            {
               sum+=i;
            }
        }
        if(sum==num){
            return true;
        }
        return false;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Number:");
        int number =sc.nextInt();

        if(isPerfectNumber(number))
        {
            System.out.println("It is perfect Number.");
        }
        else
        {
            System.out.println("It is not a perfect Number.");
        }

    }
}
