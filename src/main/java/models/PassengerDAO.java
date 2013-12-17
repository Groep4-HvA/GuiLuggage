/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import DBUtil.ConnectionMySQL;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ChrisvanderHeijden
 */
public class PassengerDAO {

    ConnectionMySQL conn = new ConnectionMySQL();

    public PassengerDAO() {
        // initialization 
    }
   
    public List<Passenger> readAll() throws SQLException {

        List<Passenger> list = new LinkedList<Passenger>();
        ResultSet rs = null;
        PreparedStatement prdstmt = null;
        java.util.Date today = new java.util.Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String query = "SELECT `name`, `surname`, `homeAddress`, `homePostalCode`, `homeCity`,`residentAddress`,`residentPostalCode`, `residentCity`, `color`, `shape`, `additionalDetails`, `labelNumber` FROM `passengers` LIMIT 50";

        conn.startConnection();

        prdstmt = conn.getConnection().prepareStatement(query);
        rs = conn.performSelect(prdstmt);

        while (rs.next()) {
            Passenger tempPassenger = new Passenger();
            tempPassenger.setName(rs.getString("name"));
            tempPassenger.setSurname(rs.getString("surname"));
            tempPassenger.setAdres(rs.getString("homeAddress"));
            tempPassenger.setPostalCode(rs.getString("homePostalCode"));
            tempPassenger.setCity(rs.getString("homeCity"));
            tempPassenger.setResidentAdres(rs.getString("residentAddress"));
            tempPassenger.setResidentPostalCode(rs.getString("residentPostalCode"));
            tempPassenger.setResidentCity(rs.getString("residentCity"));
            tempPassenger.setColor(rs.getString("color"));
            tempPassenger.setShape(rs.getString("shape"));
            tempPassenger.setDetails(rs.getString("additionalDetails"));
            tempPassenger.setLabel(rs.getString("labelNumber"));
            list.add(tempPassenger);
        }

        if (conn != null) {
            conn.closeConnection();
        }

        return list;
    }

    public List<Passenger> search(String searchInput) throws SQLException {

        List<Passenger> list = new LinkedList<Passenger>();
        ResultSet rs = null;
        PreparedStatement prdstmt = null;

        String query = "SELECT `name`, `surname`, `homeAddress`, `homePostalCode`, `homeCity`,`residentAddress`,`residentPostalCode`, `residentCity`, `color`, `shape`, `additionalDetails`, `labelNumber` FROM `passengers` WHERE `name` LIKE ? OR `surname` LIKE ? OR `homeAddress` LIKE ? OR `homePostalCode` LIKE ? OR `homeCity` LIKE ? OR `residentAddress` LIKE ? OR `residentPostalCode` LIKE ? OR `residentCity` LIKE ? OR `color` LIKE ? OR `shape` LIKE ? OR `additionalDetails` LIKE ? OR `labelNumber` LIKE ?  LIMIT 50";
        conn.startConnection();

        prdstmt = conn.getConnection().prepareStatement(query);
        
        prdstmt.setString(1, "%" + searchInput + "%");
        prdstmt.setString(2, "%" + searchInput + "%");
        prdstmt.setString(3, "%" + searchInput + "%");
        prdstmt.setString(4, "%" + searchInput + "%");
        prdstmt.setString(5, "%" + searchInput + "%");
        prdstmt.setString(6, "%" + searchInput + "%");
        prdstmt.setString(7, "%" + searchInput + "%");
        prdstmt.setString(8, "%" + searchInput + "%");
        prdstmt.setString(9, "%" + searchInput + "%");
        prdstmt.setString(10, "%" + searchInput + "%");
        prdstmt.setString(11, "%" + searchInput + "%");
        prdstmt.setString(12, "%" + searchInput + "%");

        rs = conn.performSelect(prdstmt);

        while (rs.next()) {
            Passenger tempPassenger = new Passenger();
            tempPassenger.setName(rs.getString("name"));
            tempPassenger.setSurname(rs.getString("surname"));
            tempPassenger.setAdres(rs.getString("homeAddress"));
            tempPassenger.setPostalCode(rs.getString("homePostalCode"));
            tempPassenger.setCity(rs.getString("homeCity"));
            tempPassenger.setResidentAdres(rs.getString("residentAddress"));
            tempPassenger.setResidentPostalCode(rs.getString("residentPostalCode"));
            tempPassenger.setResidentCity(rs.getString("residentCity"));
            tempPassenger.setColor(rs.getString("color"));
            tempPassenger.setShape(rs.getString("shape"));
            tempPassenger.setDetails(rs.getString("additionalDetails"));
            tempPassenger.setLabel(rs.getString("labelNumber"));
            list.add(tempPassenger);
        }

        if (conn != null) {
            conn.closeConnection();
        }

        return list;
    }

    public int create(Passenger passenger, int handlerId) throws SQLException {
        PreparedStatement prdstmt = null;
        String query = "INSERT INTO `cases`  ( `name`, `surname`, `homeAddress`, `homePostalCode`, `homeCity`,`residentAddress`,`residentPostalCode`, `residentCity`, `color`, `shape`, `aditionalDetails`, `LuggageNumber`,`HandlerID`,`PhoneNr`,`addDate`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        java.util.Date today = new java.util.Date();
        java.sql.Date sqlToday = new java.sql.Date(today.getTime());
        conn.startConnection();

        prdstmt = conn.getConnection().prepareStatement(query);

        prdstmt.setString(1, passenger.getName());
        prdstmt.setString(2, passenger.getSurname());
        prdstmt.setString(3, passenger.getAdres());
        prdstmt.setString(4, passenger.getPostalCode());
        prdstmt.setString(5, passenger.getCity());
        prdstmt.setString(6, passenger.getResidentAdres());
        prdstmt.setString(7, passenger.getResidentPostalCode());
        prdstmt.setString(8, passenger.getResidentCity());
        prdstmt.setString(9, passenger.getColor());
        prdstmt.setString(10, passenger.getShape());
        prdstmt.setString(11, passenger.getDetails());
        prdstmt.setString(12, passenger.getLabel());
        prdstmt.setInt(13, handlerId);
        prdstmt.setString(14, passenger.getPhoneNr());
        prdstmt.setDate(15, sqlToday);
        prdstmt.executeUpdate();

        if (conn != null) {
            conn.closeConnection();
        }
        return -1;
    }

}
