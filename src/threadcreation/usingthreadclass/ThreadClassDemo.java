package threadcreation.usingthreadclass;


class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread class running: "
                    + Thread.currentThread().getName() + " -> " + i);
        }
    }
}

public class ThreadClassDemo {

    public static void main(String[] args) {

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.start();   // creates new thread
        t2.start();   // creates another thread
    }
}

