package com.inmemorydb.strategy;

import com.inmemorydb.entity.User;

import java.util.Map;
import java.util.function.Predicate;

public class FilterStrategy implements QueryStrategy {
    private final Predicate<User> condition;

    public FilterStrategy(Predicate<User> condition) {
        this.condition = condition;
    }

    public void execute(Map<Integer, User> table) {
        table.values().stream()
                .filter(condition)
                .forEach(System.out::println);
    }
}