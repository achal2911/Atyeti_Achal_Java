package producer_consumer.queue;

public class ProducerConsumerExample {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(5);
        Thread producer = new Thread(() -> {
            for (int i = 0; i <= 10; i++) {

                try {
                    buffer.produce(i);
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    buffer.consume();
                    Thread.sleep(300); // simulate consumption delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
