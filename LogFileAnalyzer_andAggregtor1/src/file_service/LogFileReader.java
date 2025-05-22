package file_service;


import java.io.*;
import java.util.logging.Logger;

public class LogFileReader {

    private static int error_count = 0;
    private static int warning_count = 0;
    private static int info_count = 0;

    public static int getError_count() {
        return error_count;
    }

    public static int getWarning_count() {
        return warning_count;
    }

    public static int getInfo_count() {
        return info_count;
    }

    private static final Logger logger = Logger.getLogger(LogFileReader.class.getName());


    public static void readLogFile(File logFile) {

        try (BufferedReader br = new BufferedReader(new FileReader(logFile))) {
            String line = "";

            while ((line = br.readLine()) != null) {
                if (line.contains("ERROR")) {
                    error_count++;
                } else if (line.contains("WARNING")) {
                    warning_count++;
                } else if (line.contains("INFO")) {
                    info_count++;
                }


            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            ErrorLogsWriter.writeErrorLogs(e.getMessage());
        }


    }
}
