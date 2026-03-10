package interthreadcommunnication;

import java.util.LinkedList;
import java.util.Queue;

public class IfFailureDemo {

    private static final Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {

        Runnable consumerTask = () -> {
            synchronized (queue) {
                try {
                    if (queue.isEmpty()) {
                        queue.wait();
                    }

                    System.out.println(Thread.currentThread().getName() +
                            " consumed: " + queue.poll());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread consumer1 = new Thread(consumerTask, "Consumer-1");
        Thread consumer2 = new Thread(consumerTask, "Consumer-2");

        Thread producer = new Thread(() -> {
            synchronized (queue) {
                queue.add(100);
                queue.notifyAll();  // Wake both consumers
            }
        });

        consumer1.start();
        consumer2.start();

        try { Thread.sleep(100); } catch (Exception e) {}

        producer.start();
    }
}