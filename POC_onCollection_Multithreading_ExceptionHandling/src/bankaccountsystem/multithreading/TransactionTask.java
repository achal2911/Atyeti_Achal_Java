package bankaccountsystem.multithreading;

import bankaccountsystem.entity.Bank;
import bankaccountsystem.exception.InsufficientBalanceException;

import javax.security.auth.login.AccountNotFoundException;

public class TransactionTask implements Runnable {
    private final Bank bank;
    private final int accountNumver;
    private final double amount;
    private final boolean isDeposit;

    public TransactionTask(Bank bank, int accNo, double amount, boolean isDeposit) {
        this.bank = bank;
        this.accountNumver = accNo;
        this.amount = amount;
        this.isDeposit = isDeposit;
    }

    @Override
    public void run() {
        try {
            if (isDeposit) {
                bank.depositMoney(accountNumver, amount);
            } else {
                bank.withdrawMoney(accountNumver, amount);
            }
        } catch (InsufficientBalanceException | AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
