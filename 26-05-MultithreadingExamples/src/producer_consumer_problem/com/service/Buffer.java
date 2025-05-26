package producer_consumer_problem.com.service;

public class Buffer {
    private final int[] buffer;
    private int count = 0;
    private int in = 0;
    private int out = 0;

    public Buffer(int size) {
        buffer = new int[size];
    }

    public synchronized void addItem(int item) throws InterruptedException {
        while (count == buffer.length) {
            wait(); // Wait if buffer is full
        }
        buffer[in] = item;
        in = (in + 1) % buffer.length;
        count++;
        notify(); // Notify consumer that buffer is not empty
    }

    public synchronized int removeItem() throws InterruptedException {
        while (count == 0) {
            wait(); // Wait if buffer is empty
        }
        int item = buffer[out];
        out = (out + 1) % buffer.length;
        count--;
        notify(); // Notify producer that buffer is not full
        return item;
    }
}