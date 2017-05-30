package com.unibuc.andreas.FootballManager.main.java.database;

import com.unibuc.andreas.FootballManager.main.java.ui.AlertMessage;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by antoneandreas on 5/23/17.
 */
public class ConnectToDatabase {

    private static Connection myConnection;
    private String URL="jdbc:mysql://localhost:3306/fotballmanager?useSSL=false";
    private String USERNAME="root";
    private String PASWWORD="1234";

    public ConnectToDatabase() {
        try {
            ConnectToDatabase.myConnection= DriverManager.getConnection(URL,USERNAME,PASWWORD);
        } catch (SQLException e) {
            new AlertMessage("Error","The server could not be contacted. Please verify your connection.", Alert.AlertType.ERROR);
            System.exit(-1);
        }
    }

    public static Connection getConnection() {
        return myConnection;
    }
}
