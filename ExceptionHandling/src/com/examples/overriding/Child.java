package com.examples.overriding;

import java.io.FileNotFoundException;

public class Child extends Parent {
    @Override
    void test() throws FileNotFoundException
    {
    } // valid
//    void test() throws Exception
//    {
//    } // invalid
}


//Java allows overridden methods to:
//Throw fewer or narrower checked exceptions
//
//Throw unchecked exceptions (or none at all)
//
//But throwing broader checked exceptions causes a compile error.
//Java enforces exception compatibility in overriding.