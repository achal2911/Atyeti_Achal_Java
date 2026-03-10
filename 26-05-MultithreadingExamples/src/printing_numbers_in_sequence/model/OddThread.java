package printing_numbers_in_sequence.model;

import printing_numbers_in_sequence.service.Printer;

public class OddThread implements Runnable {

    private final Printer printer;

    public OddThread(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.printOdd();
    }
}
