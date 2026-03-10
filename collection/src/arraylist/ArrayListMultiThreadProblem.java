package arraylist;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMultiThreadProblem {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> integerList = new ArrayList<>();

        Runnable r = () -> {
            for (int i = 0; i < 100; i++) {
                integerList.add(i);//arraylist is not thread safe
            }

        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("Expected size: 200 ");
        System.out.println("Actual size: " + integerList.size());
    }
}
