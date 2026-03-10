package interthreadcommunnication;

class SharedResource {
    private int data;
    private boolean hasData = false;

    public synchronized void consume() {
        while (!hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Consumed Data" + data);
        hasData = false;
        notify();//tells producer is it ok to produce more data

    }

    public synchronized void produce(int value) {
        while ((hasData)) {

            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        System.out.println("Produced data:" + data);
        hasData = true;
        notify();//tells consumer data is ready

    }
}

public class ClassicITC {
    public static void main(String[] args) {
        System.out.println("Program started");

        SharedResource obj = new SharedResource();

        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) obj.produce(i);
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) obj.consume();
        });

        t1.start();
        t2.start();


    }
}
