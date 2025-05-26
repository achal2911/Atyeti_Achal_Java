package producer_consumer_problem;

import producer_consumer_problem.com.model.Consumer;
import producer_consumer_problem.com.model.Producer;
import producer_consumer_problem.com.service.Buffer;

public class ProducerConsumerMain {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(5); // Buffer capacity of 5

        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerThread = new Thread(new Consumer(buffer));
        producerThread.start();
        consumerThread.start();

    }


}
