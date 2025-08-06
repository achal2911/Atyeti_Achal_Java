package task_04_concurrent_modification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConcurrentModificationDemo
{
    public static void main(String[] args) {
        List<User> users = new ArrayList<>(Arrays.asList(
                new User("Active User", true),
                new User("Inactive User", false),
                new User("Another Active", true)
        ));

        UserManagerFixed.removeInactiveUsers(users);
        System.out.println("Users after cleanup: " + users.size());
    }
}
