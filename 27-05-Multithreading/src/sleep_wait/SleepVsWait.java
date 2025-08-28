package sleep_wait;

public class SleepVsWait {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (lock) {

                try {
                    System.out.println("Thread is sleeping");
                    Thread.sleep(2000);
                    System.out.println("Thread woke up after sleep");
                } catch (InterruptedException e) {

                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Thread is waiting..");
                    lock.wait();
                } catch (InterruptedException e) {

                }
            }

        });

        t1.start();
        Thread.sleep(500);
        t2.start();
        Thread.sleep(3000);

        synchronized (lock) {
            lock.notify();
        }
    }
}
