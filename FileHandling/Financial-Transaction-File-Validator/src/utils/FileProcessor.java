package utils;

import exception.InvalidFileException;
import services.FileContentValidator;
import services.FileFieldsValidator;
import services.FileNameValidator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;


public class FileProcessor {
    static Logger logger = Logger.getLogger(FileProcessor.class.getName());

    public static void processingOfFile(File file)
    {
        String fileName = file.getName();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String header = reader.readLine();

            if (!FileNameValidator.isValidFileName(fileName)) {
                throw new InvalidFileException("Invalid filename: " + fileName);
            }
            if (!FileContentValidator.isValidHeader(header)) {
                throw new InvalidFileException("Invalid header in file: " + fileName);
            }

            String line;
            while ((line = reader.readLine()) != null) {
                if (!FileContentValidator.isValidRow(line)) {
                    throw new InvalidFileException("Invalid row in file: " + fileName);
                }
                FileFieldsValidator.isValidFields(line, fileName);
            }

            logger.info("File processed successfully!! " + fileName);

        } catch (InvalidFileException e) {
            logger.warning(e.getMessage());
            ErrorWriter.writeErrorToFile(fileName, e.getMessage());

        } catch (IOException e) {
            logger.warning("I/O Error: " + e.getMessage());
            ErrorWriter.writeErrorToFile(fileName, "I/O error: " + e.getMessage());
        }
    }
}