package log_file_analyzer;

import log_file_analyzer.com.logs_filereader.LogParser;
import log_file_analyzer.com.module.LogEntry;
import log_file_analyzer.com.service.LogsAnalyzer;

import java.util.HashSet;
import java.util.List;

import static log_file_analyzer.com.service.LogsAnalyzer.*;

public class FileAnalyzerMain {
    public static void main(String[] args) {
        String logsFilePath = "C:\\Users\\Achal Tikale\\IdeaProjects\\Atyeti_Achal_Java\\15-05-CoreJavaBasics\\src\\log_file_analyzer\\com\\util\\logEntries.txt";

        //reading of logs
        List<LogEntry> logEntryList = LogParser.readingLogsFile(logsFilePath);
        logEntryList.forEach(System.out::println);

        System.out.println("--------------------------------------");

        //finding unique users
        HashSet<LogEntry> logEntries = findingUniqueUser(logsFilePath);
        logEntries.forEach(System.out::println);

        System.out.println("--------------------------------------");

        //maxUser with given action
        LogsAnalyzer.findUserWithMaxAction(logEntryList, "DOWNLOAD");

        System.out.println("--------------------------------------");

        //minimumUser with given action
        LogsAnalyzer.findUserWithMinAction(logEntryList, "DOWNLOAD");


    }
}
