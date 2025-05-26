package producer_consumer_problem.com.model;

import producer_consumer_problem.com.service.Buffer;

public class Producer implements Runnable {
    private final Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {

        while (true) {
            try {
                int item = (int) (Math.random() * 100);
                buffer.addItem(item);
                System.out.println("Produced: " + item);
                Thread.sleep(1000); // Simulate time taken to produce an item

            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
