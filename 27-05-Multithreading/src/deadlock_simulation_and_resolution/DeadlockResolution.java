package deadlock_simulation_and_resolution;

public class DeadlockResolution {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new LockTask("Thread 1");
        Thread thread2 = new LockTask("Thread 2");

        thread1.start();
        thread2.start();

    }
}
