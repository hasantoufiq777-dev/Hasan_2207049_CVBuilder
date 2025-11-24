package com.example.cvbuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String URL = "jdbc:sqlite:cvbuilder.db";

    static {
        try {
            // ensure SQLite JDBC driver is loaded (not strictly required with modern drivers)
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ignored) {}
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
