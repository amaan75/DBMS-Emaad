package com.company;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Controller {
    public static void execute(String sqlQuery, int ch) throws IOException, SQLException {
        System.out.println("Enter the dbms to connect to: \n1.MySQL\n2.PostGre");
        switch (ch) {
            case 1:
                System.out.println("You have chosen Connection to MySql.");
                Connection mSqlConn = MysqlConnection.execute();
                Statement stmt = null;
                try {
                    stmt = mSqlConn.createStatement();
                    stmt.executeUpdate(sqlQuery);
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    if (stmt != null) {
                        stmt.close();
                    }
                    if (mSqlConn != null) {
                        mSqlConn.close();
                    }
                }
                break;
            case 2:
                System.out.println("You have chosen Connection to PostGre.");
                PostgreConnection.execute();
                break;
            default:
                System.out.println("Don't choose an option other than 1 or 2 ");
        }
    }
}
