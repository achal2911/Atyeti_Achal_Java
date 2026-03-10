package deadlock_simulation_and_resolution;

public class DeadlockSimulation {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() ->
        {
            synchronized (lock1) {
                System.out.println("Thread 1: Holding lock1...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                synchronized (lock2) {
                    System.out.println("Thread 1: Acquired lock2.");
                }
            }


        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2: Holding lock2...");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }

                synchronized (lock1) {
                    System.out.println("Thread 2: Acquired lock1.");
                }
            }

        });

        thread1.start();
        thread2.start();


    }
}
