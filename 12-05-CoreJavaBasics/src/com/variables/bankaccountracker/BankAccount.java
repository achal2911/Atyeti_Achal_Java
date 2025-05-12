package com.variables.bankaccountracker;

public class BankAccount {

    private static  int totalAccounts;
    private final int accountId;
    private double balance;

    public BankAccount(double balance) {

        totalAccounts++;
        //final variable initialization  using constructor
        this.accountId = totalAccounts; // Assign unique ID
        this.balance = balance;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public int getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public String deposit(int amount)
    {
        if(amount>0)
        {
            double bal = balance + amount;
            System.out.println("Amount of "+amount +"rupees deposited successfully to account with id "+getAccountId());
            System.out.println("Available Balance:"+bal);
        }
        return "Invalid Input";

    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountId=" + accountId +
                ", balance=" + balance +
                '}';
    }

    public static void main(String[] args) {

        BankAccount b1 = new BankAccount(100.0);
        BankAccount b2 = new BankAccount(700.0);
        BankAccount b3 = new BankAccount(20.0);
        BankAccount b4 = new BankAccount(1200.0);
        BankAccount b5 = new BankAccount(1400.0);

        System.out.println(b1+"\n"+b2+"\n"+b3+"\n"+b4+"\n"+b1+"\n"+b5);
        System.out.println("---------------------------");


        b1.deposit(205);
        System.out.println("---------------------------");
        b2.deposit(300);
        System.out.println("---------------------------");


        System.out.println("Total Accounts Created: " + BankAccount.getTotalAccounts());
    }


}
