package com.examples.return_in_finally;

public class Test5 {
    public static String test() {
        try {
            throw new RuntimeException("Try");
        } finally {
            return "From finally";
        }
    }
    public static void main(String[] args) {
        System.out.println(test());
    }
    //A return in finally overwrites everything—including:
    //thrown exceptions
    //returned values from try

    //note:-Never use return in finally unless absolutely required—it can hide bugs silently.
}
