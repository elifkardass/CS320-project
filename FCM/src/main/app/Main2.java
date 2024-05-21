package app;

import control.DBConnection;

import java.sql.Connection;

public class Main2 {
    public static void main(String[] args) {
        DBConnection DBconnection = new DBConnection();
        Connection c = DBconnection.getConnection();
    }
}
