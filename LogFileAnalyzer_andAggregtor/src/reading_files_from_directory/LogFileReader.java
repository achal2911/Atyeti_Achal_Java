package reading_files_from_directory;

import java.io.*;

public class LogFileReader {

    public void readLogFile(File logFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(logFile));
        String line ="";
        while ((line= reader.readLine())!=null)
        {
            System.out.println(line);
        }
    }
}
