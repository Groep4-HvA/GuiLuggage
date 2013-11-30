/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import DBUtil.ConnectionMySQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;




/**
 *
 * @author ChrisvanderHeijden
 */
public class LuggageDAO {
      
     ConnectionMySQL conn = new ConnectionMySQL();
    
     public LuggageDAO() {
        // initialization 
    }
   
        public int create(Luggage luggage) throws SQLException {
        PreparedStatement prdstmt = null;
        String query = "INSERT INTO `luggage`  ( `labelNumber`, `color`, `shape`, `storageLocation`, `additionalDetails`,`addDate`) VALUES(?,?,?,?,?,?);";
        java.util.Date today = new java.util.Date();
        java.sql.Date sqlToday = new java.sql.Date(today.getTime());
        
        conn.startConnection();
        
        prdstmt = conn.getConnection().prepareStatement(query);
        
        
        prdstmt.setString(1, luggage.getLabel());
        prdstmt.setString(2, luggage.getColor());
        prdstmt.setString(3, luggage.getShape());
        prdstmt.setString(4, luggage.getLocation()); 
        prdstmt.setString(5, luggage.getDetails());
        prdstmt.setDate(6, sqlToday);

        prdstmt.executeUpdate();

        if (conn != null) {
            conn.closeConnection();
        }
        return -1;
    }
        
}
