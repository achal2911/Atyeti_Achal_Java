package duplication;

import config.FileConfig;
import file_service.ErrorLogsWriter;

import java.io.*;

public class LogsFileDuplicator {


    public static void writeDataToDuplicateFile(File logFile) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(logFile));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FileConfig.DUPLICATE_FILE_PATH, true));
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e) {
            ErrorLogsWriter.writeErrorLogs(e.getMessage());
        }
    }


}
