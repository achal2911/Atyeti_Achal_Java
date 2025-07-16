package services;

import exception.InvalidFileException;
import model.CurrencyType;
import model.Status;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class FileFieldsValidator {
    public static boolean isValidFields(String line, String fileName) {
        String[] split = line.split(",");

        String txnId = split[0];
        String accountNo = split[1];
        LocalDate txnDate = LocalDate.parse(split[2], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        double amount = Double.parseDouble(split[3]);
        String currency = split[4];
        String status = split[5];

        //TXN_ID validations
        Set<String> stringSet = new HashSet<>();
        Pattern txnPattern = Pattern.compile("^[A-Za-z]{3}[0-9]+$");

        if (!txnPattern.matcher(txnId).matches()) {
            throw new InvalidFileException("Invalid TXN_ID format: " + txnId +" in file "+fileName);
        }
        if (!stringSet.add(txnId)) {
            throw new InvalidFileException("Duplicate TXN_ID found: " + txnId+" in file "+fileName);
        }

        //ACCOUNT_NO validations
        if (!accountNo.matches("\\d{10}")) {
            throw new InvalidFileException("Account should be 10-digit numeric: " + accountNo+" in file "+fileName);
        }

        //TXN_DATE validations
        String dateInFile = fileName.substring(fileName.lastIndexOf("_") + 1, fileName.indexOf(".csv"));
        String formattedTxnDate = txnDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        if (!formattedTxnDate.equals(dateInFile)) {
            throw new InvalidFileException("Invalid TXN_DATE: " + formattedTxnDate + " does not match file date: " + dateInFile+" in file "+fileName);
        }

        //AMOUNT validations
        if (!(amount >= 0)) {
            throw new InvalidFileException("Amount should be positive decimal number "+" in file "+fileName);
        }

        //Currency validation
        try {
            CurrencyType.valueOf(currency.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidFileException("Invalid currency: " + currency+" in file "+fileName);
        }

        //Status validation
        try {
            Status.valueOf(status.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidFileException("Invalid Status: " + status+" in file "+fileName);
        }
        return true;

    }
}
