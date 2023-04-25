/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.db;


import java.sql.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author a1397
 */
public class DB {
    private final String URL;
    private final String USERNAME;
    private final String PASSWORD;
    
    public static final String MEMBER = "member";
    public static final String STAFF = "staff";
    public static final String SENIOR_MANAGEMENT = "senior_management";

    
    public DB() {
        this.URL = "jdbc:mysql://localhost:3306/itp4511_db";
        this.USERNAME = "root";
        this.PASSWORD = "";
    }

    public Connection getConnection() throws SQLException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("success");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
