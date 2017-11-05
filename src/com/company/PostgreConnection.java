package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

class PostgreConnection {
    static Connection execute() {
        Connection postgreConnection = null;
        String url = "jdbc:postgresql://localhost/java";
        Properties props = new Properties();
        props.setProperty("user", "javabase");
        props.setProperty("password", "dbms");
        try {
            postgreConnection = DriverManager.getConnection(url, props);
            System.out.println("Connection successful with postgres");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        return postgreConnection;
    }
}