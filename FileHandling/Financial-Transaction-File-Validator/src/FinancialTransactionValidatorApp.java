import config.ValidationConfig;
import utils.FileProcessor;
import services.FileEncryptorValidator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.logging.Logger;

public class FinancialTransactionValidatorApp {
    private static final Logger logger = Logger.getLogger(FinancialTransactionValidatorApp.class.getName());

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


        ExecutorService executorService = Executors.newFixedThreadPool(files.length);
        List<Future> futures = new ArrayList<>();
        try {
            for (File file : files) {
                Future<?> submit = executorService.submit(() -> FileProcessor.processingOfFile(file));
                futures.add(submit);
            }

            executorService.shutdown();
            for (Future f : futures) {
                f.get();
            }
            FileEncryptorValidator.encryptAllValidatedFiles();
            logger.info("all validated files are successfully encrypted and moved to archived directory");
        } catch (ExecutionException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
        logger.info("All files submitted for processing.");

    }
}