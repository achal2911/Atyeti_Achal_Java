package collections_and_streams.transaction_analyzer_system;

import collections_and_streams.transaction_analyzer_system.model.Transactions;
import collections_and_streams.transaction_analyzer_system.service.TransactionAnalyzer;
import collections_and_streams.transaction_analyzer_system.service.TransactionsReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static collections_and_streams.transaction_analyzer_system.service.TransactionAnalyzer.*;

public class TransactionsAnalyzerMain {
    public static void main(String[] args) throws IOException {
        String transactionsFilepath = "C:\\Users\\Achal Tikale\\IdeaProjects\\Atyeti_Achal_Java\\19-05-CollectionsAndStream\\src\\collections_and_streams\\transaction_analyzer_system\\util\\transactions_lot (1).csv";
        List<Transactions> transactionsList = TransactionsReader.readTransactionData(transactionsFilepath);

        //Calculate total transaction amount per user.
        System.out.println("total transaction amount per user:");
        Map<String, Integer> mappedListWithTotalAmounts = totalTransactionAmountOfUser(transactionsList);
        mappedListWithTotalAmounts.forEach((userId, totalAmount) -> System.out.println("User ID: " + userId + ", Total Amount: " + totalAmount));

        System.out.println("---------------------------------------------------------------------------------");

        //Filter out transactions below INR 100.
        System.out.println("transactions below Rs 100:");
        TransactionAnalyzer.filteredTransactionsBelowRs100(transactionsList);
        System.out.println("---------------------------------------------------------------------------------");

        //Find top 3 users with the highest total transaction amounts.
        System.out.println("top 3 users with the highest total transaction amounts:");
        TransactionAnalyzer.top3UsersWithHighestTransactionsAmount(transactionsList);

    }
}
