package task_04_concurrent_modification;

import java.util.List;

public class UserManager
{

    public void removeInactiveUsers(List<User> users) {
        for (User user : users) {
            if (!user.isActive()) {
                users.remove(user); // Exception here!
            }
        }
    }
}
