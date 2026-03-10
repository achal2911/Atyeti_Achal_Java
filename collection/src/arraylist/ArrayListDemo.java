package arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Mango");
        fruits.add("Banana");
        fruits.add("Mango");

        System.out.println("All Fruits: " + fruits);
        System.out.println("Index of Mango: " + fruits.indexOf("Mango"));
        System.out.println("Contains Banana? " + fruits.contains("Banana"));

        fruits.remove("Mango");
        fruits.set(1, "Grapes");

        Collections.sort(fruits);
        System.out.println("Sorted Fruits: " + fruits);

    }
}
