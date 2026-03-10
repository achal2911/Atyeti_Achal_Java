package synchronized_vs_reentrantlocks;

public class LockVsSynchronizedDemo {
    public static void main(String[] args) {
        System.out.println("=== synchronized demo ===");
        SynchronizedResource synchronizedResource = new SynchronizedResource();
        new Thread(synchronizedResource::access, "Thread-A").start();
        new Thread(synchronizedResource::access, "Thread-B").start();


        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
        }


        System.out.println("=== ReentrantLock demo ===");
        ReentrantLockResource reentrantLockResource = new ReentrantLockResource();
        new Thread(reentrantLockResource::accessWithTimeOut, "Thread-C").start();
        new Thread(reentrantLockResource::accessWithTimeOut, "Thread-D").start();

    }

}
