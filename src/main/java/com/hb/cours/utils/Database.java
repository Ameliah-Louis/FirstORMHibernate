package com.hb.cours.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class externalisation connexion db
 */
public class Database {

    private static final String URL = "jdbc:mysql://localhost:3306/hb_cda_jdbc";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    /**
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        System.out.println( "DB connection!" );
        return DriverManager.getConnection(URL, USER, PASSWORD);

    }
}
