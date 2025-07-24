package utils;

import config.ValidationConfig;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DailySummaryLogger {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter TIMESTAMP_FORMAT = DateTimeFormatter.ofPattern("hh:mm a");

    public static synchronized void logSummary(String fileName, String status, String error) {
        String today = LocalDate.now().format(DATE_FORMAT);
        String timestamp = LocalDateTime.now().format(TIMESTAMP_FORMAT);

        File logDir = new File(ValidationConfig.SUMMARY_LOG_DIRECTORY_PATH);
        if (!logDir.exists()) {
            logDir.mkdirs();
        }

        File logFile = new File(logDir + File.separator + "daily_summary_for_" + today + ".csv");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true))) {
            if (logFile.length() == 0) {
                writer.write("File Name,Status,Error,Timestamp\n");
            }

            writer.write(String.format("%s,%s,\"%s\",%s\n", fileName, status, error == null ? "-" : error, timestamp));
        } catch (IOException e) {
            System.err.println("Summary log error: " + e.getMessage());
        }
    }
}

