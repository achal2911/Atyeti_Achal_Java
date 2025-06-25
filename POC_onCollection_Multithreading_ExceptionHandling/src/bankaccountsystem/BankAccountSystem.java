package bankaccountsystem;

import bankaccountsystem.entity.Bank;
import bankaccountsystem.multithreading.TransactionTask;

public class BankAccountSystem {
    public static void main(String[] args) {
        Bank bank = new Bank();

        Thread t1 = new Thread(new TransactionTask(bank, 111, 500, true));   // Deposit
        Thread t2 = new Thread(new TransactionTask(bank, 111, 1200, false)); // Withdraw
        Thread t3 = new Thread(new TransactionTask(bank, 222, 1000, false)); // Withdraw
        Thread t4 = new Thread(new TransactionTask(bank, 222, 8000, false)); // Withdraw more than balance


        t1.start();
        t2.start();
        t3.start();
        t4.start();


        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }

        bank.printAllBalances();
    }
}
