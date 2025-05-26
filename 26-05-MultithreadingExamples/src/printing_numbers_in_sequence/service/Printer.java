package printing_numbers_in_sequence.service;

public class Printer {
    private int number = 1;
    private final int max;

    public Printer(int max) {
        this.max = max;
    }

    public void printOdd() {
        while (number <= max) {
            synchronized (this) {
                while (number % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (number <= max) {
                    System.out.println("OddThread: " + number++);
                }
                notify();
            }
        }
    }

    public void printEven() {
        while (number <= max) {
            synchronized (this) {
                while (number % 2 != 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (number <= max) {
                    System.out.println("EvenThread: " + number++);
                }
                notify();
            }
        }
    }
}
