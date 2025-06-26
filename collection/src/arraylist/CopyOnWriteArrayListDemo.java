package arraylist;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> integerList = new CopyOnWriteArrayList<>();

        Thread writer = new Thread(() -> {
            for (int i = 0; i <=10; i++) {
                integerList.add(i);
            }
        });

        Thread reader = new Thread(() -> {
            for (Integer i : integerList) {
                System.out.println(i);
            }
        });

        writer.start();
        writer.join();
        reader.start();
        reader.join();
    }
}
