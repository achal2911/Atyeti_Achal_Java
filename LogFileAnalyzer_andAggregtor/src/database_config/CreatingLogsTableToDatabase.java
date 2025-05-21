package database_config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class CreatingLogsTableToDatabase {


    public static void createTable(String query) throws SQLException {
        Connection connection= GetConnectionToDB.getConnection();
        Statement statement = connection.createStatement();

        Logger logger=Logger.getLogger(CreatingLogsTableToDatabase.class.getName());
        try {
            statement.execute(query);
            logger.info("Table created successfully.");
        } catch (SQLException e) {
            logger.warning("Failed to create table: " + e.getMessage());
            throw e;
        } finally {
            statement.close();
            connection.close();
        }
    }

}


