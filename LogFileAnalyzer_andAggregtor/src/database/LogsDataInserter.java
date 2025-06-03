package database;


import config.DataConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class LogsDataInserter {

    public static void insertingData(int error_count, int waring_count, int info_count) throws SQLException {

        Connection con = DataConfig.getConnection();
        PreparedStatement preparedStatement = con.prepareStatement(DataConfig.query_to_insertData);
        preparedStatement.setInt(1, error_count);
        preparedStatement.setInt(2, waring_count);
        preparedStatement.setInt(3, info_count);
        int n = preparedStatement.executeUpdate();

        if (n > 0) {
            System.out.println("data inserted successfully to the table ");
        }


    }
}
