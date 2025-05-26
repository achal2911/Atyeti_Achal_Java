package producer_consumer_problem.com.model;

import producer_consumer_problem.com.service.Buffer;

public class Consumer implements Runnable {
    private final Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int item = buffer.removeItem();
                System.out.println("Consumed: " + item);
                Thread.sleep(1500); //  time taken to consume an item
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
