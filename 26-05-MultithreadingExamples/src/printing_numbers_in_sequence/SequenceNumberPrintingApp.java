package printing_numbers_in_sequence;

import printing_numbers_in_sequence.model.EvenThread;
import printing_numbers_in_sequence.model.OddThread;
import printing_numbers_in_sequence.service.Printer;

import java.util.Scanner;

public class SequenceNumberPrintingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the max number upto which you want sequence:");
        int maxNumber = sc.nextInt();

        Printer printer = new Printer(maxNumber);

        Thread oddThread = new Thread(new OddThread(printer), "OddThread");
        Thread evenThread = new Thread(new EvenThread(printer), "EvenThread");

        oddThread.start();
        evenThread.start();
    }
}
