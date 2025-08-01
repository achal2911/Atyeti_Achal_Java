package com.example.service;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GreetingServiceTest {
    @Test
    void testGreet() {
        GreetingService service = new GreetingService();
        assertEquals("Hello, Achal!", service.greet("Achal"));
    }
}
