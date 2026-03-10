package Test.file_service_test;

import config.FileConfig;
import file_service.ErrorLogsWriter;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ErrorLogsWriterTest {

    @Test
    void testWriteErrorLogs() throws IOException {
        String testMessage = "Test error message";


        ErrorLogsWriter.writeErrorLogs(testMessage);

        // Check if the message was written to the file
        File file = new File(FileConfig.ERROR_FILE_PATH);
        assertTrue(file.exists());

        boolean messageFound = false;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.equals(testMessage)) {
                messageFound = true;
                break;
            }
        }
        reader.close();

        assertTrue(messageFound, "Error message should be found in the file");
    }
}