package com.company;

import java.io.IOException;
import java.sql.*;

public class Controller {
    public static void execute(String sqlQuery, int ch, boolean hasResultSet) throws IOException, SQLException {
        System.out.println("Enter the dbms to connect to: \n1.MySQL\n2.PostGre");
        Connection sqlConn = null;
        Statement stmt = null;
        switch (ch) {
            case 1:
                System.out.println("You have chosen Connection to MySql.");
                sqlConn = MysqlConnection.execute();
                break;
            case 2:
                System.out.println("You have chosen Connection to PostGre.");
                sqlConn = PostgreConnection.execute();
                break;
            default:
                System.out.println("Don't choose an option other than 1 or 2 ");
        }

        try {
            stmt = sqlConn.createStatement();
            if (hasResultSet) {
                ResultSet resultSet = stmt.executeQuery(sqlQuery);
                ResultSetMetaData rsmd = resultSet.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                while (resultSet.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = resultSet.getString(i);
                        System.out.print(columnValue + " " + rsmd.getColumnName(i));
                    }
                    System.out.println("");
                }
            } else {
                stmt.executeUpdate(sqlQuery);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (sqlConn != null) {
                sqlConn.close();
            }
        }
    }
}
