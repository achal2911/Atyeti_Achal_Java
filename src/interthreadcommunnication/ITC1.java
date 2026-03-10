package interthreadcommunnication;

class A {
    int num;
    boolean valueSet = false;


    public synchronized void put(int num) {
        while (valueSet) {

            try {
                wait();
            } catch (Exception e) {
            }
        }

        System.out.println("put:" + num);
        this.num = num;
        valueSet = true;
        notify();
    }

    public synchronized void get() {
        while(!valueSet)
        {
            try{
                wait();
            }
            catch (Exception e){}
        }
        System.out.println("get:" + num);
        valueSet=false;
        notify();
    }


}

class Producer implements Runnable {
    A a;

    public Producer(A a) {
        this.a = a;
        Thread producer = new Thread(this, "Producer");
        producer.start();
    }

    public void run() {
        int i = 0;
        while (true) {
            a.put(i++);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }
}

class Consumer implements Runnable {
    A a;

    public Consumer(A a) {
        this.a = a;
        Thread consumer = new Thread(this, "Consumer");
        consumer.start();
    }

    public void run() {

        while (true) {
            a.get();
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }


        }
    }
}

public class ITC1 {
    public static void main(String[] args) {
        A a=new A();
        new Producer(a);
        new Consumer(a);

    }
}
