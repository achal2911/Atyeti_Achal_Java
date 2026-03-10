package bankaccountsystem.entity;

import bankaccountsystem.exception.InsufficientBalanceException;
import bankaccountsystem.exception.InvalidAmountException;

import javax.security.auth.login.AccountNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final Map<Integer, Double> accounts = new HashMap<>();


    public Bank() {
        accounts.put(111, 4000.0);
        accounts.put(222, 5000.0);
        accounts.put(333, 6000.0);

    }

    public synchronized void depositMoney(int accountNumber, double amount) throws AccountNotFoundException {

        if (accounts.get(accountNumber) == null) {
            throw new AccountNotFoundException("Account " + accountNumber + " does not exist");
        }
        if (amount > 0) {
            accounts.put(accountNumber, accounts.getOrDefault(accountNumber, 0.0) + amount);
            System.out.println("Deposited Rs." + amount + " to Account " + accountNumber);
        } else {
            throw new InvalidAmountException("Please provide a valid amount to deposit");
        }
    }

    public synchronized void withdrawMoney(int accountNumber, double amount) throws AccountNotFoundException {
        if (Double.isNaN(amount) || Double.isInfinite(amount) || amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be positive: " + amount);
        }
        Double currentBalance = accounts.get(accountNumber);
        if (currentBalance == null) {
            throw new AccountNotFoundException("Account " + accountNumber + " does not exist");
        }

        if (amount > currentBalance) {
            throw new InsufficientBalanceException("Insufficient balance in account " + accountNumber);

        }

        accounts.put(accountNumber, currentBalance - amount);
        System.out.println("Amount withdrawn successfully from account " + accountNumber);

    }

    public void printAllBalances() {
        System.out.println("Final Account Balances:");
        for (Map.Entry<Integer, Double> entry : accounts.entrySet()) {
            System.out.println("Account " + entry.getKey() + ": Rs" + entry.getValue());
        }
    }


}
