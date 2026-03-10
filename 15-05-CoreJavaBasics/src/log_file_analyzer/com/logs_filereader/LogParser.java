package log_file_analyzer.com.logs_filereader;

import log_file_analyzer.com.module.LogEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class LogParser {

    public static List<LogEntry> readingLogsFile(String filePath) {

        List<LogEntry> logEntries = new ArrayList<>();

        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

            String line;

            while ((line = bufferedReader.readLine()) != null) {

                String[] listOfLog = line.trim().split(",");

                if (listOfLog.length >= 3) {


                    Timestamp timestamp = Timestamp.valueOf(listOfLog[0].trim());
                    String userId = listOfLog[1];

                    String action = listOfLog[2];

                    LogEntry logEntry = new LogEntry(timestamp, userId, action);

                    logEntries.add(logEntry);

                } else {

                    System.err.println("Invalid log entry: " + line);

                }

            }

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

        return logEntries;

    }


}


