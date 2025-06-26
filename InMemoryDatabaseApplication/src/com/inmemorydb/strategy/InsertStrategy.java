package com.inmemorydb.strategy;

import com.inmemorydb.entity.User;

import java.util.Map;

public class InsertStrategy implements QueryStrategy{
    private final User user;

    public InsertStrategy(User user) {
        this.user = user;
    }

    public void execute(Map<Integer, User> table) {
        table.put(user.getId(), user);
        System.out.println("Inserted: " + user);
    }
}
