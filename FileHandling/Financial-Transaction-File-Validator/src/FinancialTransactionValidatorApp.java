import config.ValidationConfig;
import utils.FileProcessor;

import java.io.File;

public class FinancialTransactionValidatorApp {
    public static void main(String[] args) {

        File inputDirectory = new File(ValidationConfig.DIRECTORY_PATH);

        if (!inputDirectory.exists() || !inputDirectory.isDirectory()) {
            System.out.println("Input folder not found.");
            return;
        }

        File[] files = inputDirectory.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("No files found.");
            return;
        }
        for (File file : files) {
            String fileName = file.getName();
            FileProcessor.processingOfFile(file);

        }


    }
}