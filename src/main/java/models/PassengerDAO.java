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
public class PassengerDAO {

    private final ConnectionMySQL conn = new ConnectionMySQL();
    private final Date today = new Date();
    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public PassengerDAO() {
        // initialization 
    }

    /**
     * Create a new piece of luggage in the DB
     * @param passenger
     * @param handlerId
     * @return status of the query
     * @throws SQLException 
     */
    public int create(Passenger passenger, int handlerId) throws SQLException {
        PreparedStatement prdstmt;
        String sqlToday = dateFormat.format(today);
        String query = "INSERT INTO `cases`  ( `name`, `surname`, `homeAddress`, `homePostalCode`, `homeCity`,`residentAddress`,`residentPostalCode`, `residentCity`, `color`, `shape`, `aditionalDetails`, `LuggageNumber`,`HandlerID`,`PhoneNr`,`addDate`, `emailAdress`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
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
        prdstmt.setString(15, sqlToday);
        prdstmt.setString(16, passenger.getEmailAdress());
        prdstmt.executeUpdate();

        if (conn != null) {
            conn.closeConnection();
        }
        return -1;
    }

}
