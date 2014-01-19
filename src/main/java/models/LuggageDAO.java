package models;

import DBUtil.ConnectionMySQL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ChrisvanderHeijden
 */
public class LuggageDAO {

    ConnectionMySQL conn = new ConnectionMySQL();

    public LuggageDAO() {
        // initialization 
    }

    /**
     * Create a new entry for the luggage in the DB
     * @param luggage
     * @param handlerId
     * @return
     * @throws SQLException 
     */
    public int create(Luggage luggage, int handlerId) throws SQLException {
        PreparedStatement prdstmt;
        String query = "INSERT INTO `cases`  ( `LuggageNumber`, `color`, `shape`, `storageLocation`, `aditionalDetails`,`addDate`,`HandlerID`,`PhoneNr`) VALUES(?,?,?,?,?,?,?,?);";
        Date today = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sqlToday = dateFormat.format(today);

        conn.startConnection();

        prdstmt = conn.getConnection().prepareStatement(query);

        prdstmt.setString(1, luggage.getLabel());
        prdstmt.setString(2, luggage.getColor());
        prdstmt.setString(3, luggage.getShape());
        prdstmt.setString(4, luggage.getLocation());
        prdstmt.setString(5, luggage.getDetails());
        prdstmt.setString(6, sqlToday);
        prdstmt.setInt(7, handlerId);
        prdstmt.setString(8, luggage.getPhoneNr());

        prdstmt.executeUpdate();
        Debug.println("INSERT INTO DB");

        if (conn != null) {
            conn.closeConnection();
        }
        return -1;
    }
}
