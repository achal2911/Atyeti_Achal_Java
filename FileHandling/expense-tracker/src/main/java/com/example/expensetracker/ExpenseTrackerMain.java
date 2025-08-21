package com.example.expensetracker;

import com.example.expensetracker.ui.ExpenseTrackerAppUI;

public class ExpenseTrackerMain {
    public static void main(String[] args) {
        try {
            ExpenseTrackerAppUI app = new ExpenseTrackerAppUI();

            Thread t1=new Thread(app);t1.start();

        } catch (Exception e) {
            System.err.println("Application failed to start: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
