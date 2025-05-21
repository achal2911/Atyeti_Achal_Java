package reading_files_from_directory;

import java.io.File;
import java.io.IOException;

public class ProcessingDirectory {
    public static void ReadingOfLogsFile(String directoryPath) throws IOException {
        File file=new File(directoryPath);
        File[] listOfFiles= file.listFiles((dir, name) -> name.endsWith(".log"));
        LogFileReader logsFileReader = new LogFileReader();
        for(File logFile:listOfFiles)
        {
            logsFileReader.readLogFile(logFile);
        }

    }
}
