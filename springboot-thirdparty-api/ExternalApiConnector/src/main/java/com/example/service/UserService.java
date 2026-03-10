package com.example.service;

import com.example.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {

    // In-memory storage
    private final List<User> users = new ArrayList<>();

    // Save user
    public void save(User incomingUser) {
        users.add(incomingUser);
        System.out.println("User saved: " + incomingUser);
    }

    // Find user by username
    public User findByUsername(String username) {
        // Search the list manually
        for (User user : users) {
            if (user.getUserName().equalsIgnoreCase(username)) { // case-insensitive match
                return user;
            }
        }
        return null; // not found
    }

    // Get all users
    public List<User> findAll() {
        return new ArrayList<>(users); // Return a copy to avoid external modification
    }
}

