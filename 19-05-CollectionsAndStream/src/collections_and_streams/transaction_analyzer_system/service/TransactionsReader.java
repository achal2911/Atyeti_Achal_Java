package collections_and_streams.transaction_analyzer_system.service;

import collections_and_streams.transaction_analyzer_system.model.Transactions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TransactionsReader {
    public static List<Transactions> readTransactionData(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        ArrayList<Transactions> transactionsArrayList = new ArrayList<>();
        String line = "";

        line = reader.readLine();
        while ((line = reader.readLine()) != null) {
            String[] split = line.split(",");
            Transactions transactions = new Transactions(split[0], Integer.parseInt(split[1]), Timestamp.valueOf(split[2]));
            transactionsArrayList.add(transactions);

        }

        return transactionsArrayList;

    }
}
