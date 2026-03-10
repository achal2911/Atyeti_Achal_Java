package com.inmemorydb.service;

import com.inmemorydb.entity.User;
import com.inmemorydb.strategy.QueryStrategy;

import java.util.*;

//singleton class
public class InMemoryDB
{
    private static InMemoryDB instance;

    private Map<Integer, User> userTable;

    private InMemoryDB(String type)
    {
        switch (type.toLowerCase()) {
            case "linked":
                userTable = new LinkedHashMap<>();
                break;
            case "sorted":
                userTable = new TreeMap<>();
                break;
            default:
                userTable = new HashMap<>();
        }
    }

    public static InMemoryDB getInstance(String type) {
        if (instance == null) {
            instance = new InMemoryDB(type);
        }
        return instance;
    }

    public void execute(QueryStrategy strategy) {
        strategy.execute(userTable);
    }

    public Map<Integer, User> getUserTable() {
        return userTable;
    }
}
