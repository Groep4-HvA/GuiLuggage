/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import DBUtil.ConnectionMySQL;
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
public class LuggageDAO {

    ConnectionMySQL conn = new ConnectionMySQL();

    public LuggageDAO() {}

    public int create(Luggage luggage) throws SQLException {
        PreparedStatement prdstmt = null;
        String query = "INSERT INTO `cases`  ( `labelNumber`, `color`, `shape`, `storageLocation`, `additionalDetails`,`addDate`) VALUES(?,?,?,?,?,?);";
        java.util.Date today = new java.util.Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        conn.startConnection();

        prdstmt = conn.getConnection().prepareStatement(query);

        prdstmt.setString(1, luggage.getLabel());
        prdstmt.setString(2, luggage.getColor());
        prdstmt.setString(3, luggage.getShape());
        prdstmt.setString(4, luggage.getLocation());
        prdstmt.setString(5, luggage.getDetails());
        prdstmt.setString(6, dateFormat.format(today));

        prdstmt.executeUpdate();

        if (conn != null) {
            conn.closeConnection();
        }
        return -1;
    }

    public List<Luggage> readAll() throws SQLException {

        List<Luggage> list = new LinkedList<Luggage>();
        ResultSet rs = null;
        PreparedStatement prdstmt = null;

        String query = "SELECT `labelNumber`, `color`, `storageLocation`, `additionalDetails`, `shape` FROM `luggage` LIMIT 50";

        conn.startConnection();

        prdstmt = conn.getConnection().prepareStatement(query);
        rs = conn.performSelect(prdstmt);

        while (rs.next()) {
            Luggage luggage = new Luggage();
            luggage.setLabel(rs.getString("labelNumber"));
            luggage.setColor(rs.getString("color"));
            luggage.setLocation(rs.getString("storageLocation"));
            luggage.setDetails(rs.getString("additionalDetails"));
            luggage.setShape(rs.getString("shape"));
            list.add(luggage);
        }

        if (conn != null) {
            conn.closeConnection();
        }

        return list;
    }

    public int update(Luggage luggage) throws SQLException {
        PreparedStatement prdstmt = null;
        String query = "UPDATE LUGGAGE"
                + "SET labelNumber=?, color?, shape=?, storageLocation=?, additionalDetails=?, status=?"
                + "FROM luggage"
                + "INNER JOIN passengers"
                + "ON luggage.labelNumber=passengers.labelNumber"
                + "UPDATE PASSENGERS"
                + "SET name=?, surname=?, homeAddress=?, homePostalCode=?, homeCity=?, residentAddress=?, residentPostalCode=?, residentCity=?,color=?,shape?,additionalDetails=?, labelNumber?"
                + "INNER JOIN luggage"
                + "ON luggage.labelNumber=passengers.labelNumber";
        query += " WHERE labelNumber=?";

        conn.startConnection();

        prdstmt = conn.getConnection().prepareStatement(query);

        /*
         prdstmt.setString(1, luggage.getLabel());
         prdstmt.setString(2, luggage.getColor());
         prdstmt.setString(3, luggage.getShape());
         prdstmt.setString(4, luggage.getLocation()); 
         prdstmt.setString(5, luggage.getDetails());
         */
        prdstmt.executeUpdate();

        if (conn != null) {
            conn.closeConnection();
        }
        return -1;
    }

    public int delete(Luggage luggage) throws SQLException {
        PreparedStatement prdstmt = null;
        String query = "UPDATE LUGGAGE SET labelNumber=?, color=?,shape=?,storageLocation=?,additionalDetails=? ";
        query += " WHERE labelNumber=?";

        conn.startConnection();

        prdstmt.setString(1, luggage.getLabel());
        prdstmt.setString(2, luggage.getColor());
        prdstmt.setString(3, luggage.getShape());
        prdstmt.setString(4, luggage.getLocation());
        prdstmt.setString(5, luggage.getDetails());

        prdstmt.executeUpdate();
        if (conn != null) {
            conn.closeConnection();
        }
        return -1;
    }
}
