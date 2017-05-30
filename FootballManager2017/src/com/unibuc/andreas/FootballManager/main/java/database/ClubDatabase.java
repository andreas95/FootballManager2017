package com.unibuc.andreas.FootballManager.main.java.database;

import com.unibuc.andreas.FootballManager.main.java.model.Club;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author andreas antone
 * Created by antoneandreas on 5/23/17.
 */
public class ClubDatabase {

    public static void addClub(Club club) {
        try {
            String SQL = "INSERT INTO CLUBS (NAME, COUNTRY, MP, W, D, L, GF, GA, GD, PTS) VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement myStatement = ConnectToDatabase.getConnection().prepareStatement(SQL);
            myStatement.setString(1, club.getName());
            myStatement.setString(2, club.getCountry());
            myStatement.setInt(3, club.getMP());
            myStatement.setInt(4, club.getW());
            myStatement.setInt(5, club.getD());
            myStatement.setInt(6, club.getL());
            myStatement.setInt(7, club.getGF());
            myStatement.setInt(8, club.getGA());
            myStatement.setInt(9, club.getGD());
            myStatement.setInt(10, club.getPTS());
            myStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void editClub(String oldName, Club club) {
        String SQL = "UPDATE CLUBS SET NAME=?, COUNTRY=?, MP=?, W=?, D=?, L=?, GF=?, GA=?, GD=?, PTS=? WHERE NAME=?";
        try {
            PreparedStatement myStatement = ConnectToDatabase.getConnection().prepareStatement(SQL);
            myStatement.setString(1, club.getName());
            myStatement.setString(2, club.getCountry());
            myStatement.setInt(3, club.getMP());
            myStatement.setInt(4, club.getW());
            myStatement.setInt(5, club.getD());
            myStatement.setInt(6, club.getL());
            myStatement.setInt(7, club.getGF());
            myStatement.setInt(8, club.getGA());
            myStatement.setInt(9, club.getGD());
            myStatement.setInt(10, club.getPTS());
            myStatement.setString(11, oldName);
            myStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteClub(String name) {
        String SQL="DELETE FROM CLUBS WHERE NAME=?;";
        try {
            PreparedStatement myStatement = ConnectToDatabase.getConnection().prepareStatement(SQL);
            myStatement.setString(1, name);
            myStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Club> getClubs() {
        List<Club> temp = new ArrayList<Club>();
        String SQL = "SELECT * FROM CLUBS";
        try {
            Statement myStatement = ConnectToDatabase.getConnection().createStatement();
            ResultSet myResultSet = myStatement.executeQuery(SQL);
            while (myResultSet.next()) {
                temp.add(new Club(myResultSet.getString("NAME"), myResultSet.getString("COUNTRY"),
                        myResultSet.getByte("MP"), myResultSet.getByte("W"),
                        myResultSet.getByte("D"), myResultSet.getByte("L"),
                        myResultSet.getByte("GF"), myResultSet.getByte("GA"),
                        myResultSet.getByte("GD"), myResultSet.getByte("PTS")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }

    public static List<Club> search(String query) {
        List<Club> temp = new ArrayList<Club>();
        String SQL = "SELECT * FROM CLUBS WHERE name like '%"+query+"%' or country like '%"+query+"%';";
        try {
            Statement myStatement = ConnectToDatabase.getConnection().createStatement();
            ResultSet myResultSet = myStatement.executeQuery(SQL);
            while (myResultSet.next()) {
                temp.add(new Club(myResultSet.getString("NAME"), myResultSet.getString("COUNTRY"),
                        myResultSet.getByte("MP"), myResultSet.getByte("W"),
                        myResultSet.getByte("D"), myResultSet.getByte("L"),
                        myResultSet.getByte("GF"), myResultSet.getByte("GA"),
                        myResultSet.getByte("GD"), myResultSet.getByte("PTS")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }

    public static List<String> getNameClubs() {
        List<String> temp = new ArrayList<>();
        String SQL = "SELECT * FROM CLUBS";
        try {
            Statement myStatement = ConnectToDatabase.getConnection().createStatement();
            ResultSet myResultSet = myStatement.executeQuery(SQL);
            while (myResultSet.next()) {
                temp.add(myResultSet.getString("NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }

    public static boolean existClub(String name) {
        String SQL = "SELECT * FROM CLUBS WHERE NAME='"+name+"';";
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

    public static String getClubByID(byte id) {
        String SQL = "SELECT NAME FROM CLUBS where id="+id;
        try {
            Statement myStatement = ConnectToDatabase.getConnection().createStatement();
            ResultSet myResultSet = myStatement.executeQuery(SQL);
            if (myResultSet.next()) {
                return myResultSet.getString("NAME");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static byte getIdByClub(String name) {
        String SQL = "SELECT id FROM CLUBS where name='"+name+"'";
        try {
            Statement myStatement = ConnectToDatabase.getConnection().createStatement();
            ResultSet myResultSet = myStatement.executeQuery(SQL);
            if (myResultSet.next()) {
                return (byte) myResultSet.getInt("ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
