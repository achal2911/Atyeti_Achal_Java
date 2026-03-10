package synchronized_vs_reentrantlocks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockResource {
    private final ReentrantLock lock = new ReentrantLock();

    public void accessWithTimeOut() {
        boolean acquired = false;
        try {
            acquired = lock.tryLock(2, TimeUnit.SECONDS);
            if (acquired) {
                System.out.println(Thread.currentThread().getName() + " acquired lock (ReentrantLock)");
                Thread.sleep(5000);
            } else {
                System.out.println(Thread.currentThread().getName() + " could NOT acquire lock (timeout)");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();

        } finally {
            if (acquired) {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + " released lock (ReentrantLock)");
            }
        }
    }
}
