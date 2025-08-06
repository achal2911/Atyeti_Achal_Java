package task_04_concurrent_modification;

import java.util.Iterator;
import java.util.List;

public class UserManagerFixed
{
    public static void removeInactiveUsers(List<User> users) {
        users.removeIf(user -> !user.isActive());
    }

    //or

    public  static void removeInactive(List<User>users)
    {
        Iterator<User>iterator=users.iterator();
        while(iterator.hasNext())
        {
            User user=iterator.next();
            if(!user.isActive())
            {
                iterator.remove();
            }
        }
    }
}
