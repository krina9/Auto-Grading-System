package com.example.CodeHat.Services;

import java.sql.DriverManager;

public class Connection {

    private static java.sql.Connection dbConnection = null;

    private Connection() {
        ;
    }

    public static java.sql.Connection getInstance() {
        if (dbConnection == null) {
            try {
                dbConnection = DriverManager.getConnection("jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_10_DEVINT", "CSCI5308_10_DEVINT_USER", "Xyv9jJ8em6");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dbConnection;
    }
}
