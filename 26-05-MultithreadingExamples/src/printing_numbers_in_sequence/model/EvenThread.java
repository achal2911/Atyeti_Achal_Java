package printing_numbers_in_sequence.model;

import printing_numbers_in_sequence.service.Printer;

public class EvenThread implements Runnable {
    private final Printer printer;

    public EvenThread(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.printEven();
    }
}
