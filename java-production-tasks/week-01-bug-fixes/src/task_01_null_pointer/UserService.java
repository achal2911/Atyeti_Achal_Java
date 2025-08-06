package task_01_null_pointer;

import java.util.Optional;

public class UserService {
    public static String getUserName(User user) {
        if (user == null) {
            return "UNKNOWN";
        }
        String name = user.getName();
        if (name == null || name.trim().isEmpty()) {
            return "UNKNOWN";
        }

        /*using optional class

        return Optional.ofNullable(user)
                      .map(User::getName)
                      .filter(name -> !name.trim().isEmpty())
                      .map(String::toUpperCase)
                      .orElse("UNKNOWN");*/

        return user.getName().toUpperCase();
    }

    public static int getUserAge(User user) {

        if (user == null) {
            return -1;
        }
        int age = user.getAge();
        if (age < 0) {
            return -1;
        }
        return age;

//        return Optional.ofNullable(user)
//                .map(User::getAge)
//                .filter(a -> a >= 0)
//                .orElse(-1);

    }

    public static void main(String[] args) {


        System.out.println(UserService.getUserName(null));
        User user = new User("achal", -9);
        System.out.println(UserService.getUserName(user) + "," + UserService.getUserAge(user));

    }
}
