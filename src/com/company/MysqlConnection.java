package com.company;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class MysqlConnection {

    static Connection execute() {
        String url = "jdbc:mysql://localhost:3306/javabase";
        String username = "java";
        String password = "password";
        Connection mySqlConnection = null;
        System.out.println("Connecting database...");
        try {
            mySqlConnection = DriverManager.getConnection(url, username, password);
            System.out.println("Mysql Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }

        return mySqlConnection;
    }
}
