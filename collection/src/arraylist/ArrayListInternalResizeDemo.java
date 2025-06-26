package arraylist;

import java.util.ArrayList;

public class ArrayListInternalResizeDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            list.add(i);
            System.out.println("Added: " + i + " | Size: " + list.size());
        }
    }
}
