package deadlock_simulation_and_resolution;

public class LockTask extends Thread{

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public LockTask(String name) {
       super(name);
    }

    @Override
    public void run() {
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + ": Holding lock1...");
            try { Thread.sleep(100); } catch (InterruptedException ignored) {}
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + ": Acquired lock2.");
            }
        }
    }
}
