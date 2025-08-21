package com.example.expensetracker.manager;

import com.example.expensetracker.exception.ValidationException;
import com.example.expensetracker.model.Category;
import com.example.expensetracker.model.Expense;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ExpenseManager {
    private List<Expense> expenses;
    private AtomicInteger idGenerator;

    public ExpenseManager() {
        this.expenses = new ArrayList<>();
        this.idGenerator = new AtomicInteger(1);
    }

    public void addExpense(Expense expense) throws ValidationException {
        validateExpense(expense);
        expense.setId(idGenerator.getAndIncrement());
        expenses.add(expense);
    }

    public boolean updateExpense(int id, Expense updatedExpense) throws ValidationException {
        validateExpense(updatedExpense);
        for (int i = 0; i < expenses.size(); i++) {
            if (expenses.get(i).getId() == id) {
                updatedExpense.setId(id);
                expenses.set(i, updatedExpense);
                return true;
            }
        }
        return false;
    }

    public boolean deleteExpense(int id) {
        return expenses.removeIf(expense -> expense.getId() == id);
    }

    public List<Expense> getAllExpenses() {
        return new ArrayList<>(expenses);
    }

    public List<Expense> getExpensesByCategory(Category category) {
        return expenses.stream()
                .filter(expense -> expense.getCategory() == category)
                .collect(Collectors.toList());
    }

    public List<Expense> getExpensesByDateRange(LocalDate start, LocalDate end) {
        return expenses.stream()
                .filter(expense -> {
                    LocalDate date = expense.getDate();
                    return !date.isBefore(start) && !date.isAfter(end);
                })
                .sorted(Comparator.comparing(Expense::getDate).reversed())
                .collect(Collectors.toList());
    }

    public double getTotalExpenses() {
        return expenses.stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    public Map<Category, Double> getCategoryWiseExpenses() {
        return expenses.stream()
                .collect(Collectors.groupingBy(
                        Expense::getCategory,
                        Collectors.summingDouble(Expense::getAmount)
                ));
    }

    private void validateExpense(Expense expense) throws ValidationException {
        if (expense.getDescription() == null || expense.getDescription().trim().isEmpty()) {
            throw new ValidationException("Description cannot be empty");
        }
        if (expense.getAmount() <= 0) {
            throw new ValidationException("Amount must be positive");
        }
        if (expense.getDate() == null) {
            throw new ValidationException("Date cannot be null");
        }
        if (expense.getCategory() == null) {
            throw new ValidationException("Category cannot be null");
        }
    }

    public void loadExpenses(List<Expense> expenseList) {
        this.expenses = new ArrayList<>(expenseList);
        int maxId = expenseList.stream()
                .mapToInt(Expense::getId)
                .max()
                .orElse(0);
        this.idGenerator.set(maxId + 1);
    }



}
