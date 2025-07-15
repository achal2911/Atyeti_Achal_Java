package model;

public record Transaction(
        String txnId,
        String accountNo,
        String txnDate,
        double amount,
        String currency,
        String status
) {}
