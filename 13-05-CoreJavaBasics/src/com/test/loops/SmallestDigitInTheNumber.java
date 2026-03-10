package com.test.loops;
/*Find the smallest digit in a number**

 * Input: `85934`
 * Output: `3`*/
public class SmallestDigitInTheNumber {

    public static int findingSmallestDigit(int num)
    {
        int smallest=9;
        if(num==0)
        {
            smallest=0;
        }
        else{
            while(num>0)
            {
                int digit=num%10;
                if(digit<smallest)
                {
                    smallest=digit;
                }
                num=num/10;
            }
        }

        return smallest;
    }
    public static void main(String[] args) {

        int num=85934;
        int abs = Math.abs(num);
        System.out.println("Smallest digit in given number "+num +" is "+findingSmallestDigit(abs));


    }
}
