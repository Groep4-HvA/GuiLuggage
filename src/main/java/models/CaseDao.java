package models;

import DBUtil.ConnectionMySQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author sean
 */
public class CaseDao {

    ConnectionMySQL conn = new ConnectionMySQL();

    public CaseDao() {
        // initialization 
    }

    public List<Case> readAll() throws SQLException {

        List<Case> list = new LinkedList<Case>();
        ResultSet rs = null;
        PreparedStatement prdstmt = null;

        String query = "SELECT * FROM `cases` LIMIT 50";

        conn.startConnection();

        prdstmt = conn.getConnection().prepareStatement(query);
        rs = conn.performSelect(prdstmt);

        while (rs.next()) {
            Case tempcase = new Case();
            tempcase.setLabel(rs.getString("LuggageNumber"));
            tempcase.setName(rs.getString("Name"));
            tempcase.setSurName(rs.getString("Surname"));
            
            tempcase.setHomeAddress(rs.getString("homeAddress"));
            tempcase.setHomePostalCode(rs.getString("homePostalCode"));
            tempcase.setHomeCity(rs.getString("homeCity"));
            
            tempcase.setResidentAddress(rs.getString("residentAddress"));
            tempcase.setResidentPostalCode(rs.getString("residentPostalCode"));
            tempcase.setResidentCity(rs.getString("residentCity"));
            
            tempcase.setColor(rs.getString("Color"));
            tempcase.setShape(rs.getString("Shape"));
            tempcase.setAditionalDetails(rs.getString("AditionalDetails"));
            tempcase.setStorageLocation(rs.getString("StorageLocation"));
            tempcase.setHandlerID(rs.getInt("HandlerID"));
            
            tempcase.setAddDate(rs.getDate("AddDate"));
            tempcase.setResolveDate(rs.getDate("ResolveDate"));
            list.add(tempcase);
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
