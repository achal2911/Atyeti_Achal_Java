package com.example.controller;

import com.example.api.response.WeatherResponse;
import com.example.entity.User;
import com.example.service.UserService;
import com.example.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private WeatherService weatherService;

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody User incomingUser) {
        if (incomingUser.getUserName() == null || incomingUser.getEmail() == null || incomingUser.getPassword() == null) {
            return new ResponseEntity<>("Missing user fields!", HttpStatus.BAD_REQUEST);
        }

        userService.save(incomingUser);
        return new ResponseEntity<>("User details saved successfully!", HttpStatus.CREATED);
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable String username) {
        User user = userService.findByUsername(username);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found!", HttpStatus.NOT_FOUND);
        }
    }


    // Get all users
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAll();
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
//
@GetMapping("/weather/{city}")
public ResponseEntity<?> greeting(@PathVariable String city) {

    // Get username from the in-memory list
    List<User> users = userService.findAll(); // your List<User>
    String username;
    if (!users.isEmpty()) {
        username = users.get(0).getUserName(); // take the first user
    } else {
        username = "Guest"; // fallback if list is empty
    }

    try {
        // Get weather from API
        WeatherResponse weather = weatherService.getWeather(city);
        WeatherResponse.Current current = weather.getCurrent();

        int feelsLike = current.getFeelslike();
        int temperature = current.getTemperature();
//        String description = current.getWeatherDescriptions().isEmpty() ? ""
//                : current.getWeatherDescriptions().get(0);

        String msg = String.format(
                "Hi %s, Weather in %s is %d°C, feels like %d°C ",
                username, city, temperature, feelsLike
        );

        return new ResponseEntity<>(msg, HttpStatus.OK);

    } catch (Exception e) {
        return new ResponseEntity<>("Unable to fetch weather: " + e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}







}
