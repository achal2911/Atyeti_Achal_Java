package interthreadcommunnication;

import java.util.LinkedList;
import java.util.Queue;

public  class CorrectProducerConsumer {

    private static final Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {

        Thread consumer = new Thread(() -> {
            synchronized (queue) {
                try {
                    while (queue.isEmpty()) {
                        System.out.println("Queue empty, waiting...");
                        queue.wait();
                    }

                    System.out.println("Consumed: " + queue.poll());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread producer = new Thread(() -> {
            synchronized (queue) {
                System.out.println("Producing item...");
                queue.add(100);
                queue.notify();
            }
        });

        consumer.start();

        try { Thread.sleep(1000); } catch (Exception e) {}

        producer.start();
    }
}
