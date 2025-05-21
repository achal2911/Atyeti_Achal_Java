package database_config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface GetConnectionToDB {

    static String db_url = "jdbc:mysql://localhost:3306/logs_db";
    static String user = "root";
    static String password = "Pass@123";

    static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(db_url, user, password);
    }
}
