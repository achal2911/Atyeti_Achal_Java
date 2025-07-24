package utils;
import org.junit.Test;
import utils.FileProcessor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileProcessorTest {

    @Test
    public void testValidFileProcessing() throws IOException {

        File tempFile = File.createTempFile("BANK_TXN_20250722", ".csv");
        tempFile.deleteOnExit();

        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write("ID,Name,Amount,Date,Type,Status\n"); // valid header
            writer.write("1,John,1000,2025-07-22,CREDIT,APPROVED\n"); // valid row
        }


        FileProcessor.processingOfFile(tempFile);

    }
}

