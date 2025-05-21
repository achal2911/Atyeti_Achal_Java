import database_config.CreatingLogsTableToDatabase;
import reading_files_from_directory.ProcessingDirectory;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, IOException {

        //creating table to db
        String query_to_createTable = "CREATE TABLE logger (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                "error INT, " +
                "warning INT, " +
                "info INT)";
       // CreatingLogsTableToDatabase.createTable(query_to_createTable);

       String directoryFilePath ="C:\\Users\\AchalTikale\\PairProgramming\\LogFileAnalyzer_andAggregtor\\src\\resource_directory";
               ProcessingDirectory.ReadingOfLogsFile(directoryFilePath);
    }
}