package com.test.loops.patternProblems;

//*
//**
//***
//****
//*****
//******

public class HalfPyramid {
    public static void main(String[] args) {
        int row=5;

        for(int i=1;i<=row;i++)
        {
            for(int j=1;j<=i;j++)
            {
                System.out.print("*");


            }
            System.out.println();
        }


        /*
        * Inverted Half pyramid
        * for(int i=row;i>=row;i--)
        {
            for(int j=1;j<=i;j++)
            {
                System.out.print("*");


            }
            System.out.println();
        }*/

    }
}
