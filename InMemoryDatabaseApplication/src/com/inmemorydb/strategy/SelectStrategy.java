package com.inmemorydb.strategy;

import com.inmemorydb.entity.User;

import java.util.Map;

public class SelectStrategy implements QueryStrategy {


    @Override
    public void execute(Map<Integer, User> table) {
        table.values().forEach(System.out::println);
    }
}
