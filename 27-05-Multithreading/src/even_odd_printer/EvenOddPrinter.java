package even_odd_printer;

public class EvenOddPrinter {
    private int num = 1;
    private final int limit = 20;

    public synchronized void printOdd() {
        while (num <= limit) {
            while (num % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            if (num <= limit) {
                System.out.println(Thread.currentThread().getName() + " -> Odd: " + num++);
                notify();
            }
        }
    }

    public synchronized void printEven() {
        while (num <= limit) {
            while (num % 2 == 1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            if (num <= limit) {
                System.out.println(Thread.currentThread().getName() + " -> Even: " + num++);
                notify();
            }
        }
    }

    public static void main(String[] args) {
        EvenOddPrinter printer = new EvenOddPrinter();

        Thread oddThread = new Thread(printer::printOdd, "Odd-Thread");
        Thread evenThread = new Thread(printer::printEven, "Even-Thread");

        oddThread.start();
        evenThread.start();

    }
}
