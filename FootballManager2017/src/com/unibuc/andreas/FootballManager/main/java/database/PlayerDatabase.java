package com.unibuc.andreas.FootballManager.main.java.database;

import com.unibuc.andreas.FootballManager.main.java.model.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author andreasa
 * Created by antoneandreas on 5/23/17.
 */
public class PlayerDatabase {

    public static void addPlayer(Player player) {
        try {
            String SQL = "INSERT INTO PLAYERS (ID_CLUB, NAME, NUMBER, POSITION, AGE, MP, GS, YC, RC) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement myStatement = ConnectToDatabase.getConnection().prepareStatement(SQL);
            myStatement.setInt(1, ClubDatabase.getIdByClub(player.getClub()));
            myStatement.setString(2, player.getName());
            myStatement.setInt(3, player.getNumber());
            myStatement.setString(4, player.getPosition());
            myStatement.setInt(5, player.getAge());
            myStatement.setInt(6, player.getMP());
            myStatement.setInt(7, player.getGS());
            myStatement.setInt(8, player.getYC());
            myStatement.setInt(9, player.getRC());
            myStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void editPlayer(byte number, Player player) {
        String SQL = "UPDATE PLAYERS SET ID_CLUB=?, NAME=?, NUMBER=?, POSITION =?, AGE=?, MP=?, GS=?, YC=?, RC=? WHERE NUMBER=?";
        try {
            PreparedStatement myStatement = ConnectToDatabase.getConnection().prepareStatement(SQL);
            myStatement.setInt(1, ClubDatabase.getIdByClub(player.getClub()));
            myStatement.setString(2, player.getName());
            myStatement.setInt(3, player.getNumber());
            myStatement.setString(4, player.getPosition());
            myStatement.setInt(5, player.getAge());
            myStatement.setInt(6, player.getMP());
            myStatement.setInt(7, player.getGS());
            myStatement.setInt(8, player.getYC());
            myStatement.setInt(9, player.getRC());
            myStatement.setInt(10, number);
            myStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deletePlayer(byte number) {
        String SQL="DELETE FROM PLAYERS WHERE NUMBER=?";
        try {
            PreparedStatement myStatement = ConnectToDatabase.getConnection().prepareStatement(SQL);
            myStatement.setInt(1, number);
            myStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Player> getPlayers() {
        List<Player> temp = new ArrayList<Player>();
        String SQL = "SELECT * FROM PLAYERS";
        try {
            Statement myStatement = ConnectToDatabase.getConnection().createStatement();
            ResultSet myResultSet = myStatement.executeQuery(SQL);
            while (myResultSet.next()) {
                temp.add(new Player(myResultSet.getString("NAME"), myResultSet.getByte("NUMBER"),
                        myResultSet.getByte("AGE"), ClubDatabase.getClubByID(myResultSet.getByte("ID_CLUB")),
                        myResultSet.getString("POSITION"), myResultSet.getByte("MP"),
                        myResultSet.getByte("GS"), myResultSet.getByte("YC"), myResultSet.getByte("RC")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }

    public static boolean existPlayer(String name) {
        String SQL = "SELECT * FROM PLAYERS WHERE NAME='"+name+"';";
        try {
            Statement myStatement = ConnectToDatabase.getConnection().createStatement();
            ResultSet myResultSet = myStatement.executeQuery(SQL);
            if (myResultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<Player> search(String query) {
        List<Player> temp = new ArrayList<Player>();
        String SQL = "SELECT * FROM PLAYERS WHERE name like '%"+query+"%'";
        try {
            Statement myStatement = ConnectToDatabase.getConnection().createStatement();
            ResultSet myResultSet = myStatement.executeQuery(SQL);
            while (myResultSet.next()) {
                temp.add(new Player(myResultSet.getString("NAME"), myResultSet.getByte("NUMBER"),
                        myResultSet.getByte("AGE"), ClubDatabase.getClubByID(myResultSet.getByte("ID_CLUB")),
                        myResultSet.getString("POSITION"), myResultSet.getByte("MP"),
                        myResultSet.getByte("GS"), myResultSet.getByte("YC"), myResultSet.getByte("RC")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }
}
