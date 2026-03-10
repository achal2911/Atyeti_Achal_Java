package threadcreation.usingrunnable;

class MyRunnable implements Runnable  {

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Runnable running: "
                    + Thread.currentThread().getName() + " -> " + i);
        }
    }
}

public class RunnableDemo {

    public static void main(String[] args) {

        Thread t1 = new Thread(new MyRunnable());
        Thread t2 = new Thread(new MyRunnable());

        t1.start();
        t2.start();

        //we can use functional programming (lambda ) with runnable
        Thread t = new Thread(() -> {
            System.out.println("Lambda Runnable: "
                    + Thread.currentThread().getName());
        });
        t.start();

    }
}
