package log_file_analyzer.com.service;

import log_file_analyzer.com.logs_filereader.LogParser;
import log_file_analyzer.com.module.LogEntry;

import java.util.*;
import java.util.stream.Collectors;


public class LogsAnalyzer {

    public static HashSet<LogEntry> findingUniqueUser(String filePath) {
        List<LogEntry> logEntryList = LogParser.readingLogsFile(filePath);
        return new HashSet<>(logEntryList);

    }

    public static String findUserWithMaxAction(List<LogEntry> logEntryList, String action) {

        // Filtering entries with action and count
        Map<String, Long> count = logEntryList.stream()
                .filter(x -> action.equalsIgnoreCase(x.getAction()))
                .collect(Collectors.groupingBy(LogEntry::getUserId, Collectors.counting()));

        // Find the user with the maximum number of  actions
        Optional<Map.Entry<String, Long>> userWithMaxActions = count.entrySet().stream().max(Map.Entry.comparingByValue());

        if (userWithMaxActions.isPresent()) {
            System.out.println("User with most " + action + " actions: " + userWithMaxActions.get().getKey());
            System.out.println("Number of " + action + " actions: " + userWithMaxActions.get().getValue());
        } else {
            System.out.println("No DOWNLOAD actions found in the log.");
        }
        return userWithMaxActions.map(Map.Entry::getKey).orElse("No " + action + " actions found in the log.");
    }

    public static String findUserWithMinAction(List<LogEntry> logEntryList, String action) {

        // Filtering entries with action
        Map<String, Long> counts = logEntryList.stream()
                .filter(x -> action.equalsIgnoreCase(x.getAction()))
                .collect(Collectors.groupingBy(LogEntry::getUserId, Collectors.counting()));

        // Find the user with the maximum number of given actions
        Optional<Map.Entry<String, Long>> userWithMinActions = counts.entrySet().stream().min(Map.Entry.comparingByValue());

        if (userWithMinActions.isPresent()) {
            System.out.println("User with minimum " + action + " actions: " + userWithMinActions.get().getKey());
            System.out.println("Number of " + action + " actions: " + userWithMinActions.get().getValue());
        } else {
            System.out.println("No DOWNLOAD actions found in the log.");
        }
        return userWithMinActions.map(Map.Entry::getKey)
                .orElse("No " + action + " actions found in the log.");
    }


}
