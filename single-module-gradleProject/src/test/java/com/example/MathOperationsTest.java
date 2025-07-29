
package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathOperationsTest {

    MathOperations math = new MathOperations();

    @Test
    public void testAddition() {
        assertEquals(5, math.addition(2, 3));
        assertEquals(0, math.addition(-2, 2));
    }

    @Test
    public void testSubtraction() {
        assertEquals(1, math.subtraction(3, 2));
        assertEquals(-4, math.subtraction(-2, 2));
    }

    @Test
    public void testMultiplication() {
        assertEquals(6, math.multiplication(2, 3));
        assertEquals(-10, math.multiplication(-2, 5));
    }

    @Test
    public void testDivision() {
        assertEquals(2, math.division(10, 5));
        assertEquals(-3, math.division(-9, 3));
    }


}
