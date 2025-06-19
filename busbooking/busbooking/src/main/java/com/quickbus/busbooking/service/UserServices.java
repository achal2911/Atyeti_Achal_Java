package com.quickbus.busbooking.service;

import com.quickbus.busbooking.entity.User;
import com.quickbus.busbooking.exception.UserNotFoundException;
import com.quickbus.busbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> login(String email, String password) {
        Optional<User> user1 = userRepository.findByEmail(email);
        if (user1.isPresent() && user1.get().getPassword().equals(password) && user1.get().getEmail().equals(email)) {
            return user1;
        } else {
            throw new UserNotFoundException("User not found with given mail :- " + email);
        }
    }

}
