package utils;

import config.ValidationConfig;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class ErrorWriter {
    public static void writeErrorToFile(String fileName, String errorMessage) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ValidationConfig.ERROR_LOG_FILE_PATH, true))) {
            writer.write(LocalDateTime.now() + " - File: " + fileName + " - Error: " + errorMessage);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
