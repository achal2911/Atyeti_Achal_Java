package interthreadcommunnication;

class SharedBuffer {

    private int data;
    private boolean hasData = false;

    public synchronized void produce(int value) throws InterruptedException {

        while (hasData) {
            wait();  // Wait if data not consumed
        }

        data = value;
        System.out.println("Produced: " + value);

        hasData = true;
        notify();   // Notify consumer
    }

    public synchronized void consume() throws InterruptedException {

        while(!hasData) {
            wait();  // Wait if no data
        }

        System.out.println("Consumed: " + data);

        hasData = false;
        notify();   // Notify producer
    }
}
public class WaitNotifyDemo
{
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    buffer.produce(i);
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    buffer.consume();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();

    }
}
