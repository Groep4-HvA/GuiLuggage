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
public class MedewerkerDAO {

    ConnectionMySQL conn = new ConnectionMySQL();

    public MedewerkerDAO() {
        // initialization 
    }

    public List<Medewerker> search(String searchInput) throws SQLException {

        List<Medewerker> list = new LinkedList<Medewerker>();
        ResultSet rs = null;
        PreparedStatement prdstmt = null;

        String query = "SELECT `userName`, `userRealName`, `userPass`, `userBeheer`, `userLang` FROM `Users` WHERE `username` LIKE ? OR `userRealName` LIKE ? OR `userBeheer` LIKE ? LIMIT 50";

        conn.startConnection();

        prdstmt = conn.getConnection().prepareStatement(query);
        
        prdstmt.setString(1, "%" + searchInput + "%");
        prdstmt.setString(2, "%" + searchInput + "%");
        prdstmt.setString(3, "%" + searchInput + "%");
        
        rs = conn.performSelect(prdstmt);

        while (rs.next()) {
            Medewerker tempMedewerker = new Medewerker();
            tempMedewerker.setName(rs.getString("userRealName"));
            tempMedewerker.setUsername(rs.getString("userName"));
            tempMedewerker.setPassword(rs.getString("userPass"));
            tempMedewerker.setAppManager(rs.getBoolean("userBeheer"));
            list.add(tempMedewerker);
        }

        if (conn != null) {
            conn.closeConnection();
        }

        return list;
    }

    public List<Medewerker> readAll() throws SQLException {
        List<Medewerker> list = new LinkedList<Medewerker>();
        ResultSet rs = null;
        PreparedStatement prdstmt = null;

        String query = "SELECT `userName`, `userRealName`, `userPass`, `userBeheer`, `userLang` FROM `Users` LIMIT 50";

        conn.startConnection();

        prdstmt = conn.getConnection().prepareStatement(query);
        rs = conn.performSelect(prdstmt);

        while (rs.next()) {
            Medewerker tempMedewerker = new Medewerker();
            tempMedewerker.setName(rs.getString("userRealName"));
            tempMedewerker.setUsername(rs.getString("userName"));
            tempMedewerker.setPassword(rs.getString("userPass"));
            tempMedewerker.setAppManager(rs.getBoolean("userBeheer"));
            list.add(tempMedewerker);
        }

        if (conn != null) {
            conn.closeConnection();
        }

        return list;
    }

////    public Medewerker readById(int id) throws SQLException {
//        ResultSet rs = null;
//        PreparedStatement prdstmt = null;
//
//        String query = "SELECT ID,NAME, STREETADDRESS, CITY FROM CUSTOMER WHERE ID=?";
//
//        conn.startConnection();
//
//        prdstmt = conn.getConnection().prepareStatement(query);
//        prdstmt.setInt(1, id);
//
//        rs = conn.performSelect(prdstmt);
//
//
//        if (rs.next()) {
//            
////            tempMedewerker.setName(rs.getString("name"));
//     //       tempMedewerker.setUsername(rs.getString("username"));
//     //       tempMedewerker.setPassword(rs.getString("password"));
//     //       tempMedewerker.setAppManager(rs.getBoolean("AppManager"));
//        } else {
//            return null;
//        }
//
//        if (conn != null) {
//            conn.closeConnection();
//        }
//
//
//      //  return tempMedewerker;
//    }
    public List<Medewerker> readLogIn(String user, String pass) throws SQLException {
        List<Medewerker> list = new LinkedList<Medewerker>();
        ResultSet rs = null;
        PreparedStatement prdstmt = null;

        String query = "SELECT * FROM `Users` WHERE userName=? AND userPass=?;";

        conn.startConnection();

        prdstmt = conn.getConnection().prepareStatement(query);
        prdstmt.setString(1, user);
        prdstmt.setString(2, pass);
        rs = conn.performSelect(prdstmt);

        while (rs.next()) {
            Medewerker tempMedewerker = new Medewerker();
            tempMedewerker.setUsername(rs.getString("userName"));
            tempMedewerker.setPassword(rs.getString("userPass"));
            tempMedewerker.setName(rs.getString("userRealName"));
            tempMedewerker.setUserLang(rs.getString("userLang"));
            tempMedewerker.setManager(rs.getBoolean("userManager"));
            tempMedewerker.setAppManager(rs.getBoolean("userBeheer"));
            list.add(tempMedewerker);
        }

        if (conn != null) {
            conn.closeConnection();
        }

        return list;
    }

    public int create(Medewerker medewerker) throws SQLException {
        PreparedStatement prdstmt = null;
        String query = "INSERT INTO `Users` (`userName`, `userRealName`, `userPass`, `userManager`, `userBeheer`, `userLang`) VALUES(?, ?, ?, ?, ?, ?);";

        conn.startConnection();
        //  conn = (ConnectionMySQL) DriverManager.getConnection(url, user, pw);
        prdstmt = conn.getConnection().prepareStatement(query);
        // some code needs to be writing
        //ps = conn.prepareStatement(query);
        prdstmt.setString(1, medewerker.getUsername());
        prdstmt.setString(2, medewerker.getName());
        prdstmt.setString(3, medewerker.getPassword());
        prdstmt.setBoolean(4, medewerker.isManager());
        prdstmt.setBoolean(5, medewerker.isAppManager());
        prdstmt.setString(6, medewerker.getUserLang());
        prdstmt.executeUpdate();

        if (conn != null) {
            conn.closeConnection();
        }
        return -1;
    }

    public int update(Medewerker cust) throws SQLException {
        PreparedStatement prdstmt = null;
        String query = "UPDATE CUSTOMER SET  Name=?, StreetAddress=?,City=? ";
        query += " WHERE ID=?";

        conn.startConnection();
        // some code needs to be writing

        prdstmt.executeUpdate();

        if (conn != null) {
            conn.closeConnection();
        }
        return -1;
    }

    public int delete(Medewerker cust) throws SQLException {
        PreparedStatement prdstmt = null;
        String query = "DELETE  FROM CUSTOMER WHERE ID=?";

        conn.startConnection();
        // some code needs to be writing

        prdstmt.executeUpdate();

        if (conn != null) {
            conn.closeConnection();
        }
        return -1;
    }

}
