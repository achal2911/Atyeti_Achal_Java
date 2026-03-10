package collections_and_streams.transaction_analyzer_system.service;

import collections_and_streams.transaction_analyzer_system.model.Transactions;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionAnalyzer {
    public static Map<String, Integer> totalTransactionAmountOfUser(List<Transactions> transactionsList) {

        Map<String, Integer> totalAmountPerUser = transactionsList.stream()
                .collect(Collectors.groupingBy(
                        Transactions::getUserId,
                        Collectors.summingInt(Transactions::getAmount)
                ));


        return totalAmountPerUser;
    }

    public static void filteredTransactionsBelowRs100(List<Transactions> transactionsList) {
        List<Transactions> filteredList = transactionsList.stream().filter(x -> x.getAmount() < 100).toList();
        filteredList.forEach(System.out::println);
    }

    public static void top3UsersWithHighestTransactionsAmount(List<Transactions> transactionsList) {

        Map<String, Integer> totalAmountPerUser = totalTransactionAmountOfUser(transactionsList);
        totalAmountPerUser.entrySet().stream().sorted();

        totalAmountPerUser.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .forEach(entry ->
                        System.out.println("User ID: " + entry.getKey() + ", Total Amount: " + entry.getValue()));


    }


}
