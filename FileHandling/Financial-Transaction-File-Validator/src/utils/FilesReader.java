package utils;

import exception.InvalidFileException;
import services.FileContentValidator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;


public class FilesReader {
    static Logger logger = Logger.getLogger(FilesReader.class.getName());

    public static void readingOfFile(File file) {
        String fileName = file.getName();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String header = reader.readLine();

            if (!FileContentValidator.isValidHeader(header)) {
                throw new InvalidFileException("Invalid header in file: " + fileName);
            }
            logger.info("Header is valid for file: " + fileName);

            String line;
            int lineNumber = 2; // Header is line 1
            while ((line = reader.readLine()) != null) {
                if (!FileContentValidator.isValidRow(line)) {
                    throw new InvalidFileException("Invalid row at line " + lineNumber + " in file: " + fileName);
                }
                lineNumber++;
            }

            logger.info("All rows are valid for file: " + fileName);

        } catch (InvalidFileException e) {
            logger.warning(e.getMessage());
            ErrorWriter.writeErrorToFile(fileName, e.getMessage());

        } catch (IOException e) {
            logger.warning("I/O Error: " + e.getMessage());
            ErrorWriter.writeErrorToFile(fileName, "I/O error: " + e.getMessage());
        }
    }
}