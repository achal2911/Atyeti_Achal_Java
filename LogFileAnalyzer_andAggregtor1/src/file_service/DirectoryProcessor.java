package file_service;

import config.FileConfig;

import java.io.File;
import java.io.IOException;

public class DirectoryProcessor {

    public static void ReadingOfLogsFile() throws IOException {

        File file = new File(FileConfig.DIRECTORY_PATH);
        File[] listOfFiles = file.listFiles((dir, name) -> name.endsWith(".log"));


        for (File logFile : listOfFiles) {
            LogFileReader.readLogFile(logFile);
        }

    }
}
