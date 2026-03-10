package Test.file_service_test;

import file_service.LogFileReader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LogFileReaderTest {


    private static File logFile;
    private static LogFileReader reader;


    @BeforeAll
    public static void setup() {
        logFile = new File("resources_directory/app2.log");
        reader = new LogFileReader();
    }


    @Test
    void testEmptyFile() throws IOException {
        File emptyFile = new File("resources_directory/testEmptylogFile.log");
        reader.readLogFile(emptyFile);
        assertEquals(0, reader.getInfoCount());
        assertEquals(0, reader.getWarnCount());
        assertEquals(0, reader.getErrorCount());
    }

    @Test
    void validateErrorCount() throws IOException {
        reader.readLogFile(logFile);
        assertEquals(4, reader.getErrorCount());

    }

    @Test
    void validateWarnCount() throws IOException {
        reader.readLogFile(logFile);
        assertEquals(2, reader.getWarnCount());
    }

    @Test
    void validateInfoCount() throws IOException {
        reader.readLogFile(logFile);
        assertEquals(10, reader.getInfoCount());
    }

    @Test
    void validateTotalCounts() throws IOException {
        reader.readLogFile(logFile);
        assertEquals(4, reader.getErrorCount());
        assertEquals(2, reader.getWarnCount());
        assertEquals(10, reader.getInfoCount());
    }
}