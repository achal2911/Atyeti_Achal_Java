package com.example.expensetracker.ui;

import com.example.expensetracker.manager.ExpenseManager;
import com.example.expensetracker.manager.FileManager;
import com.example.expensetracker.service.InputDataValidator;
import com.example.expensetracker.service.ReportGenerator;
import java.util.Scanner;

public class ExpenseTrackerAppUI implements Runnable{
    private final Scanner scanner;
    private final ExpenseManager expenseManager;
    private final FileManager fileManager;
    private final ReportGenerator reportGenerator;
    private final InputDataValidator validator;

    public ExpenseTrackerAppUI() {
        this.scanner = new Scanner(System.in);
        this.expenseManager = new ExpenseManager();
        this.fileManager = new FileManager();
        this.reportGenerator = new ReportGenerator();
        this.validator = new InputDataValidator();
    }
@Override
    public void run() {
        loadExistingData();
        printHeader();

        boolean active = true;
        while (active) {
            printMenu();
            int option = validator.getValidChoice(1, 8);

            switch (option) {
                case 1 -> addExpense();
                case 2 -> listExpenses();
                case 3 -> listByCategory();
                case 4 -> updateExpense();
                case 5 -> removeExpense();
                case 6 -> createReports();
                case 7 -> saveBackup();
                case 8 -> active = quit();
            }
        }
    }

    private boolean quit() {
        return false;
    }

    private void saveBackup() {
    }

    private void createReports() {
    }

    private void removeExpense() {
    }

    private void updateExpense() {

    }

    private void listByCategory() {

    }

    private void listExpenses() {
    }

    private void addExpense() {

    }

    private void printHeader() {
        System.out.println("=======================================");
        System.out.println("        PERSONAL EXPENSE APP           ");
        System.out.println("=======================================");
        System.out.printf("Loaded %d records.%n", expenseManager.getAllExpenses().size());
    }

    private void printMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Add Expense");
        System.out.println("2. View All");
        System.out.println("3. View by Category");
        System.out.println("4. Edit Expense");
        System.out.println("5. Delete Expense");
        System.out.println("6. Reports");
        System.out.println("7. Backup");
        System.out.println("8. Exit");
        System.out.print("Choose (1-8): ");
    }

    private void loadExistingData() {
        fileManager.load(expenseManager);
    }


}
