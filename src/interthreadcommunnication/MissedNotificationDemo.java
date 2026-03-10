package interthreadcommunnication;

public class MissedNotificationDemo {
    private static final Object lock = new Object();

    public static void main(String[] args) {

        Thread notifier = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Notifier sending notification...");
                lock.notify();
            }
        });

        Thread waiter = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Waiter going to wait...");
                    lock.wait();
                    System.out.println("Waiter resumed!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        notifier.start();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }

        waiter.start();
    }
}
