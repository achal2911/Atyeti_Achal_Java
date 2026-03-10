package Test.config_test;

import config.DataConfig;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DataConfigTest {

    @Test
    void testValidDatabaseConnectionFromDataConfig() {
        try (Connection connection = DataConfig.getConnection()) {
            assertNotNull(connection, "Connection should not be null");

        } catch (SQLException e) {
            fail("Connection threw SQLException: " + e.getMessage());
        }
    }

    @Test
    void shouldThrowSQLExceptionForInvalidConnection() {
        assertThrows(SQLException.class, () -> {
            DriverManager.getConnection("jdbc:mysql://localhost:3306/logger_db", "wrong_username", "wrong_password");
        });
    }
}