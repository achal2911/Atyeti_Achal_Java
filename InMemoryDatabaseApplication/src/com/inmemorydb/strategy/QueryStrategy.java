package com.inmemorydb.strategy;

import com.inmemorydb.entity.User;

import java.util.Map;

@FunctionalInterface
public interface QueryStrategy {
    void execute(Map<Integer, User> table);
}