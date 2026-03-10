package threadcreation.threadlifecycle;

public class ThreadLifeCycleDemo {

    static final Object lock = new Object();

    public static void main(String[] args) throws Exception {

        Thread t1 = new Thread(() -> {
            try {
                synchronized (lock) {

                    System.out.println("T1 acquired lock");

                    // TIMED_WAITING
                    Thread.sleep(20000);

                    // WAITING
                    System.out.println("T1 going to wait()");
                    lock.wait();

                    System.out.println("T1 resumed after notify");

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("T2 acquired lock");
                lock.notify();
                System.out.println("T2 sent notify");
            }
        });

        // NEW
        System.out.println("T1 State (NEW): " + t1.getState());

        t1.start(); // RUNNABLE

        Thread.sleep(5000);
        System.out.println("T1 State after start (RUNNABLE/TIMED_WAITING): " + t1.getState());

        t2.start();

        Thread.sleep(5000);
        System.out.println("T1 State (WAITING/BLOCKED): " + t1.getState());

        Thread.sleep(30000);
        System.out.println("T1 Final State: " + t1.getState());
    }
}

