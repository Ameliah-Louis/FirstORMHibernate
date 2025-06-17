package com.hb.cours;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        try {
            Connection connection= DriverManager.getConnection("jdbc:mysql://root:1234@localhost:3306/hb_cda_jdbc");
            System.out.println( "DB connection Ok!" );
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
