package Test.file_service_test;

import file_service.DirectoryProcessor;
import file_service.LogFileReader;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.mockito.Mockito.*;

class DirectoryProcessorTest {


    @Test
    void readLogFiles_directoryDoesNotExist() throws Exception {
        LogFileReader mockReader = mock(LogFileReader.class);
        DirectoryProcessor processor = new DirectoryProcessor(mockReader);

        File nonExistingDirectory = new File("non_existing_dir");
        if (nonExistingDirectory.exists()) nonExistingDirectory.delete();

        processor.ReadingOfLogsFile();
        verify(mockReader, times(4)).readLogFile(any(File.class));

    }

}