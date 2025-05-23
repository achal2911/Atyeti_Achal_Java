package src.file_service;


import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class LogFileReader {

    private static final AtomicInteger errorCount = new AtomicInteger(0);
    // private AtomicInteger errorCount;
    private static final AtomicInteger warnCount = new AtomicInteger(0);
    // private int warnCount = 0;
    //private int infoCount = 0;
    private static final AtomicInteger infoCount = new AtomicInteger(0);

    public static int getErrorCount() {
        return errorCount.get();
    }

    public static int getWarnCount() {
        return warnCount.get();
    }

    public static int getInfoCount() {
        return infoCount.get();
    }

    private static final Logger logger = Logger.getLogger(LogFileReader.class.getName());


    public static void readLogFile(File logFile) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(logFile))) {
            String line = "";

            while ((line = br.readLine()) != null) {
                if (line.contains("INFO")) {
                    infoCount.incrementAndGet();
                } else if (line.contains("WARNING")) {
                    warnCount.incrementAndGet();
                } else if (line.contains("ERROR")) {
                    errorCount.incrementAndGet();
                }

            }
        } catch (IOException e) {
            logger.warning("File not found!!");
            ErrorLogsWriter.writeErrorLogs(e.getMessage());
        }
    }

}
