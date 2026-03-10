package com.inmemorydb;

import com.inmemorydb.entity.User;
import com.inmemorydb.service.InMemoryDB;
import com.inmemorydb.strategy.DeleteStrategy;
import com.inmemorydb.strategy.FilterStrategy;
import com.inmemorydb.strategy.InsertStrategy;
import com.inmemorydb.strategy.SelectStrategy;

public class DatabaseClient {
    public static void main(String[] args) {
        InMemoryDB db = InMemoryDB.getInstance("linked"); // or "sorted", "hash"

        db.execute(new InsertStrategy(new User(1, "Alice", "alice@example.com")));
        db.execute(new InsertStrategy(new User(2, "Bob", "bob@example.com")));
        db.execute(new InsertStrategy(new User(3, "Charlie", "charlie@example.com")));

        System.out.println("\n--- All Users ---");
        db.execute(new SelectStrategy());

        System.out.println("\n--- Filter: name starts with B ---");
        db.execute(new FilterStrategy(user -> user.getName().startsWith("B")));

        System.out.println("\n--- Delete user 2 ---");
        db.execute(new DeleteStrategy(2));

        System.out.println("\n--- Final Table ---");
        db.execute(new SelectStrategy());
    }
}
