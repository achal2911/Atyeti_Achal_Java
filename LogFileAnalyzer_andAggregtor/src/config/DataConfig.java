package src.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface DataConfig {

    String db_url = "jdbc:mysql://localhost:3306/logs_db";
    String user = "root";
    String password = "Pass@123";
    String query_to_createTable = "CREATE TABLE if not exists logger (" +
            "id INT AUTO_INCREMENT PRIMARY KEY, " +
            "timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
            "error INT, " +
            "warning INT, " +
            "info INT)";

    String query_to_insertData = "INSERT INTO logger (error, warning, info) VALUES (?, ?, ?)";

    static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(db_url, user, password);
    }
}
