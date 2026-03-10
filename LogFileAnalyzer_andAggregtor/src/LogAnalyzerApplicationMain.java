

import config.DataConfig;
import database.LogsDataInserter;
import database.LogsTableCreator;
import file_service.DirectoryProcessor;
import file_service.ErrorLogsWriter;
import file_service.LogFileReader;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class LogAnalyzerApplicationMain {




    public static void main(String[] args) throws SQLException, IOException, InterruptedException {

        LogFileReader logFileReader=new LogFileReader();
        DirectoryProcessor processor=new DirectoryProcessor(logFileReader);

        try {
            LogsTableCreator.createTable(DataConfig.query_to_createTable);

        } catch (SQLException e) {
            ErrorLogsWriter.writeErrorLogs(e.getMessage());
            System.out.println(e.getMessage());
        }


        //processing logs file from directory
        processor.ReadingOfLogsFile();


        //inserting analyzed data to db
        LogsDataInserter.insertingData(logFileReader.getErrorCount(), logFileReader.getWarnCount(), logFileReader.getInfoCount());


    }
}