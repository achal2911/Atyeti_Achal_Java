package com.inmemorydb.strategy;

import com.inmemorydb.entity.User;

import java.util.Map;

public class DeleteStrategy implements QueryStrategy {
    private final int userId;

    public DeleteStrategy(int userId) {
        this.userId = userId;
    }

    public void execute(Map<Integer, User> table) {
        table.remove(userId);
        System.out.println("Deleted user with ID: " + userId);
    }
}
