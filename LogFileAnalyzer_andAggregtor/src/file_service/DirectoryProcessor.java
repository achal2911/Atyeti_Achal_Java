package file_service;

import config.FileConfig;

import java.io.File;
import java.io.IOException;

public class DirectoryProcessor {
    private final LogFileReader logFileReader;

    public DirectoryProcessor(LogFileReader logFileReader) {
        this.logFileReader = logFileReader;
    }

    public void ReadingOfLogsFile() throws IOException, InterruptedException {
        File file = new File(FileConfig.DIRECTORY_PATH);
        File[] listOfFiles = file.listFiles((dir, name) -> name.endsWith(".log"));

        if (listOfFiles == null || listOfFiles.length == 0) {
            System.out.println("No log files found.");
            return;
        }

        Thread[] threads = new Thread[listOfFiles.length];
        for (int i = 0; i < listOfFiles.length; i++) {
            final int index = i;
            threads[i] = new Thread(() ->
            {

                try {
                    logFileReader.readLogFile(listOfFiles[index]);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            });
            threads[i].start();
            threads[i].join();
        }

//        for (Thread thread : threads) {
//            thread.join(1000);
//        }

//        for (File logFile : listOfFiles) {
//            LogFileReader.readLogFile(logFile);
//            //duplication of file
//            //LogsFileDuplicator.writeDataToDuplicateFile(logFile);
//        }

    }
}
