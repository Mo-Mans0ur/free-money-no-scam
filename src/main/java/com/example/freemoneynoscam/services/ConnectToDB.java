package com.example.freemoneynoscam.services;

import java.sql.*;


public class ConnectToDB {

    static Connection con;
    static Statement statement;
    static ResultSet resultSet;

    private String url;
    private String password;
    private String user;

    public ConnectToDB(String url, String user, String password) {
        try {
            this.url =url;
            con = DriverManager.getConnection(url, "root", "Moha2300");
            System.out.println("connection is true");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("connection is a no no");
        }
    }

    public void connectionToDataBase(String email) {

        try {
            statement = con.createStatement();
        } catch (SQLException s) {
            s.printStackTrace();
        }

        //insert into the table
        String insertInto = "INSERT INTO emails (email)" + "VALUES(\'" + email + "\');";

        try {
            statement = con.createStatement();
            statement.executeUpdate(insertInto);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
