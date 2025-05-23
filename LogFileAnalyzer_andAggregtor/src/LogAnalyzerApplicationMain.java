package src;

import src.config.DataConfig;
import src.database.LogsDataInserter;
import src.database.LogsTableCreator;
import src.file_service.DirectoryProcessor;
import src.file_service.ErrorLogsWriter;
import src.file_service.LogFileReader;

import java.io.IOException;
import java.sql.SQLException;

public class LogAnalyzerApplicationMain {

    public static void main(String[] args) throws SQLException, IOException, InterruptedException {

        try {
            LogsTableCreator.createTable(DataConfig.query_to_createTable);

        } catch (SQLException e) {
            ErrorLogsWriter.writeErrorLogs(e.getMessage());
            System.out.println(e.getMessage());
        }


        //processing logs file from directory
        DirectoryProcessor.ReadingOfLogsFile();


        //inserting analyzed data to db
        LogsDataInserter.insertingData(LogFileReader.getErrorCount(), LogFileReader.getWarnCount(), LogFileReader.getInfoCount());


    }
}