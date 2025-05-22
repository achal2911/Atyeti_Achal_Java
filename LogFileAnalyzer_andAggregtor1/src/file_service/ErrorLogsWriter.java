package file_service;

import config.FileConfig;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ErrorLogsWriter {

    public static void writeErrorLogs(String message) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FileConfig.ERROR_FILE_PATH, true))) {
            bufferedWriter.write(message);
            bufferedWriter.newLine();

        } catch (IOException ex) {
            System.out.println("Unable to write error msg " + ex.getMessage());
        }

    }

}
