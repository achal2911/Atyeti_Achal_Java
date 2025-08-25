package synchronized_vs_reentrantlocks;

public class SynchronizedResource {
    public synchronized void access() {
        System.out.println(Thread.currentThread().getName() + " acquired lock (synchronized)");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() + " released lock (synchronized)");
    }
}
