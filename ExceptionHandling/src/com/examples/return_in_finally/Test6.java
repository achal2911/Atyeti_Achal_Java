package com.examples.return_in_finally;
public class Test6
{
    public static int compute() {
        try {
            int x = 10 / 0; // ArithmeticException
            return 1;
        } catch (ArithmeticException e) {
            return 2;
        } finally {
            return 3;
        }
    }

    public static void main(String[] args) {
        System.out.println(compute());
    }
}

//finally block always runs, even if try/catch has return or throw
// return in finally overrides return/throw from try or catch
//throw in finally overrides return from try/catch and throws new exception
//If try/catch throws but finally returns → original exception is lost
//Avoid return in finally – can silently mask bugs

