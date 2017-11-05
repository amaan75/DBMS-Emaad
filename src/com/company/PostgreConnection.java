package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

class PostgreConnection {
    static void execute() {
        String url = "jdbc:postgresql://localhost/java";
        Properties props = new Properties();
        props.setProperty("user", "javabase");
        props.setProperty("password", "dbms");
        try {
            Connection postgreConnection = DriverManager.getConnection(url, props);
            System.out.println("Connection successful with postgres");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}