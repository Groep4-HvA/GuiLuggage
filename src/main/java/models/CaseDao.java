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
 * @author sean
 */
public class CaseDao {

    ConnectionMySQL conn = new ConnectionMySQL();

    public CaseDao() {
        // initialization 
    }
public List<Case> readAllPending() throws SQLException {
        List<Case> list = new LinkedList<Case>();
        ResultSet rs = null;
        PreparedStatement prdstmt = null;

        String query = "SELECT * FROM cases WHERE `ResolveDate` is null";
        conn.startConnection();

        prdstmt = conn.getConnection().prepareStatement(query);
        rs = conn.performSelect(prdstmt);

        while (rs.next()) {
            Case tempcase = new Case();
            tempcase.setLabel(rs.getString("LuggageNumber"));
            tempcase.setAddDate(rs.getDate("AddDate"));
            list.add(tempcase);
        }

        if (conn != null) {
            conn.closeConnection();
        }

        return list;

    }

    public List<Case> readAllResolved() throws SQLException {
        List<Case> list = new LinkedList<Case>();
        ResultSet rs = null;
        PreparedStatement prdstmt = null;

        String query = "SELECT * FROM cases WHERE `ResolveDate` is not null";
        conn.startConnection();

        prdstmt = conn.getConnection().prepareStatement(query);
        rs = conn.performSelect(prdstmt);

        while (rs.next()) {
            Case tempcase = new Case();
            tempcase.setLabel(rs.getString("LuggageNumber"));
            tempcase.setAddDate(rs.getDate("AddDate"));
            list.add(tempcase);
        }

        if (conn != null) {
            conn.closeConnection();
        }

        return list;

    }

    public List<Case> readAllByDate(String date1, String date2) throws SQLException {
        List<Case> list = new LinkedList<Case>();
        ResultSet rs = null;
        PreparedStatement prdstmt = null;

        String query = "SELECT LuggageNumber, AddDate, LEFT(AddDate, 10) FROM cases WHERE `AddDate` BETWEEN ? AND ? LIMIT 50;";
        conn.startConnection(); //2013-12-09

        prdstmt = conn.getConnection().prepareStatement(query);
        prdstmt.setString(1, date1);
        prdstmt.setString(2, date2);

        rs = conn.performSelect(prdstmt);

        while (rs.next()) {
            Case tempcase = new Case();
            tempcase.setLabel(rs.getString("LuggageNumber"));
            tempcase.setAddDate(rs.getDate("AddDate"));
            list.add(tempcase);
        }
        return list;
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
            tempcase.setHandler(rs.getInt("HandlerID"));

            tempcase.setAddDate(rs.getDate("AddDate"));
            tempcase.setResolveDate(rs.getDate("ResolveDate"));
            list.add(tempcase);
        }

        if (conn != null) {
            conn.closeConnection();
        }

        return list;
    }

    public List<Case> search(String searchInput) throws SQLException {

        List<Case> list = new LinkedList<Case>();
        ResultSet rs = null;
        PreparedStatement prdstmt = null;

        String query = "SELECT * FROM `cases` WHERE `Name` LIKE ? OR `Surname` LIKE ? OR `homeAddress` LIKE ? OR `homePostalCode` LIKE ? OR `homeCity` LIKE ? OR `residentAddress` LIKE ? OR `residentPostalCode` LIKE ? OR `residentCity` LIKE ? OR `Color` LIKE ? OR `Shape` LIKE ? OR `AditionalDetails` LIKE ? OR `LuggageNumber` LIKE ?  LIMIT 50";
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
            Case tempCase = new Case();
            tempCase.setLabel(rs.getString("LuggageNumber"));
            tempCase.setName(rs.getString("Name"));
            tempCase.setSurName(rs.getString("Surname"));

            tempCase.setHomeAddress(rs.getString("homeAddress"));
            tempCase.setHomePostalCode(rs.getString("homePostalCode"));
            tempCase.setHomeCity(rs.getString("homeCity"));

            tempCase.setResidentAddress(rs.getString("residentAddress"));
            tempCase.setResidentPostalCode(rs.getString("residentPostalCode"));
            tempCase.setResidentCity(rs.getString("residentCity"));

            tempCase.setColor(rs.getString("Color"));
            tempCase.setShape(rs.getString("Shape"));
            tempCase.setAditionalDetails(rs.getString("AditionalDetails"));
            tempCase.setStorageLocation(rs.getString("StorageLocation"));
            tempCase.setHandler(rs.getInt("HandlerID"));

            tempCase.setAddDate(rs.getDate("AddDate"));
            tempCase.setResolveDate(rs.getDate("ResolveDate"));
            list.add(tempCase);
        }

        if (conn != null) {
            conn.closeConnection();
        }

        return list;
    }

public int update(Case currentCase) throws SQLException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String queryResolve, queryLabel, queryName, querySurName, queryColor, queryShape, queryRAddress, queryRPostalCode, queryRCity, queryHAddress, queryHPostalCode, queryHCity, queryAditional, queryLocation;
        queryLabel          = currentCase.getLabel();
        querySurName        = currentCase.getSurName();
        queryName           = currentCase.getName();
        queryColor          = currentCase.getColor();
        queryShape          = currentCase.getShape();
        queryRAddress       = currentCase.getResidentAddress();
        queryRPostalCode    = currentCase.getResidentPostalCode();
        queryRCity          = currentCase.getResidentCity();
        queryHAddress       = currentCase.getHomeAddress();
        queryHPostalCode    = currentCase.getHomePostalCode();
        queryHCity          = currentCase.getHomeCity();
        queryAditional      = currentCase.getAditionalDetails();
        queryLocation       = currentCase.getStorageLocation();
        queryResolve        = (currentCase.getResolveDate()==null) ? null : dateFormat.format(currentCase.getResolveDate());
        
        
        
        PreparedStatement prdstmt = null;
        String query = "UPDATE `cases` SET `Name`=?, `Surname`=?, `homeAddress`=?, `homePostalCode`=?, `homeCity`=?, `residentAddress`=?, `residentPostalCode`=?, `residentCity`=?, `Color`=?, `Shape`=?, `AditionalDetails`=?, `StorageLocation`=?, `ResolveDate`=? WHERE `LuggageNumber`=?;";
        conn.startConnection();
        //  conn = (ConnectionMySQL) DriverManager.getConnection(url, user, pw);
        prdstmt = conn.getConnection().prepareStatement(query);
        // some code needs to be writing
        //ps = conn.prepareStatement(query);
        prdstmt.setString(1, queryName);
        prdstmt.setString(2, querySurName);
        prdstmt.setString(3, queryHAddress);
        prdstmt.setString(4, queryHPostalCode);
        prdstmt.setString(5, queryHCity);
        prdstmt.setString(6, queryRAddress);
        prdstmt.setString(7, queryRPostalCode);
        prdstmt.setString(8, queryRCity);
        prdstmt.setString(9, queryColor);
        prdstmt.setString(10, queryShape);
        prdstmt.setString(11, queryAditional);
        prdstmt.setString(12, queryLocation);
        prdstmt.setString(13, queryResolve);
        //Selecter
        prdstmt.setString(14, queryLabel);
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
