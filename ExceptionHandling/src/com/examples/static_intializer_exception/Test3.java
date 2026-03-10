package com.examples.static_intializer_exception;

import java.io.IOException;

public class Test3 {


    // In a static block:
// 1. Throwing an unchecked exception (like RuntimeException) will compile,
//    but the JVM will halt class loading with ExceptionInInitializerError exception.
//    So main() will not be executed.
//
// 2. Throwing a checked exception (like IOException) without catching it
//    will cause a **compile-time error**.
//    To allow class loading and main() execution, you must **catch** the checked exception
//    inside the static block.


    static {
        if (true)

            throw new RuntimeException("static block failed");

    }


    public static void main(String[] args) {
        System.out.println("Main");


    }
}
