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

        String query = "SELECT `name`, `surname`, `homeAddress`, `homePostalCode`, `homeCity`,`residentAddress`,`residentPostalCode`, `residentCity`, `color`, `shape`, `additionalDetails`, `labelNumber` FROM `passengers`;";

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
    
    public int create(Passenger passenger) throws SQLException {
        PreparedStatement prdstmt = null;
        String query = "INSERT INTO `passengers`  ( `name`, `surname`, `homeAddress`, `homePostalCode`, `homeCity`,`residentAddress`,`residentPostalCode`, `residentCity`, `color`, `shape`, `additionalDetails`, `labelNumber`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";
        
        conn.startConnection();
      
       prdstmt = conn.getConnection().prepareStatement(query);
      
        prdstmt.setString(1, passenger.getName());
        prdstmt.setString(2, passenger.getSurname());
        prdstmt.setString(3, passenger.getAdres());
        prdstmt.setString(4,passenger.getPostalCode());
        prdstmt.setString(5,passenger.getCity());
        prdstmt.setString(6,passenger.getResidentAdres());
        prdstmt.setString(7,passenger.getResidentPostalCode());
        prdstmt.setString(8,passenger.getResidentCity());
        prdstmt.setString(9,passenger.getColor());
        prdstmt.setString(10,passenger.getShape());
        prdstmt.setString(11,passenger.getDetails());
        prdstmt.setString(12,passenger.getLabel());
        prdstmt.executeUpdate();

        if (conn != null) {
            conn.closeConnection();
        }
        return -1;
    }
    
}
