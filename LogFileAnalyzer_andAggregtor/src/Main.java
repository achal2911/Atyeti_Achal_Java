import config.DataConfig;
import database.LogsTableCreator;
import database.LogsDataInserter;
import file_service.ErrorLogsWriter;
import file_service.LogFileReader;
import file_service.DirectoryProcessor;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, IOException {

        try {
            LogsTableCreator.createTable(DataConfig.query_to_createTable);
        } catch (SQLException e) {
            ErrorLogsWriter.writeErrorLogs(e.getMessage());
            System.out.println(e.getMessage());
        }

        //processing logs file from directory
        DirectoryProcessor.ReadingOfLogsFile();

        //inserting analyzed data to db
        LogsDataInserter.insertingData(LogFileReader.getError_count(), LogFileReader.getWarning_count(), LogFileReader.getInfo_count());

    }
}