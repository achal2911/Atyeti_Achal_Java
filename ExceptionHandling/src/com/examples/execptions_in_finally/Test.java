package com.examples.execptions_in_finally;

public class Test {
    public static void main(String[] args) {

//        try {
//            throw new RuntimeException(" exception From try");
//
//        } catch (RuntimeException e) {
//            System.out.println("caught:" + e.getMessage());
//            throw e;
//        } finally {
//            throw new RuntimeException(" exception From try");
//        }

        //if we want to preserve both exception from try and finally then we can use below approach
        //using addSuppressed method
        try {
            throw new RuntimeException("try");
        } catch (Exception e) {
            RuntimeException finalEx = new RuntimeException("finally");
            finalEx.addSuppressed(e);
            throw finalEx;
        }
    }
}


/*

If both try and finally throw exceptions:

The exception from finally suppresses the one from try.

JVM discards the first exception.*/