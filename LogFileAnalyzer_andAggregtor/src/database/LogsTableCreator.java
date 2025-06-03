package database;

import config.DataConfig;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class LogsTableCreator {


    public static void createTable(String query) throws SQLException {
        Connection connection = DataConfig.getConnection();

        Logger logger = Logger.getLogger(LogsTableCreator.class.getName());

        try (connection; Statement statement = connection.createStatement()) {
            statement.execute(query);
            logger.info("Table created successfully.");
        } catch (SQLException e) {
            logger.warning("Failed to create table: " + e.getMessage());
            throw e;
        }

    }

}


