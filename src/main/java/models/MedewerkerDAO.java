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

        String query = "SELECT  * FROM `Users` LIMIT 50";

        conn.startConnection();

        prdstmt = conn.getConnection().prepareStatement(query);
        rs = conn.performSelect(prdstmt);

        while (rs.next()) {
            Medewerker tempMedewerker = new Medewerker();
            tempMedewerker.setId(rs.getInt("userId"));
            tempMedewerker.setName(rs.getString("userRealName"));
            tempMedewerker.setUsername(rs.getString("userName"));
            tempMedewerker.setPassword(rs.getString("userPass"));
            tempMedewerker.setAppManager(rs.getBoolean("userBeheer"));
            tempMedewerker.setManager(rs.getBoolean("userManager"));
            list.add(tempMedewerker);
        }

        if (conn != null) {
            conn.closeConnection();
        }

        return list;
    }

    public Medewerker readByID(int medewerkerId) throws SQLException {
        ResultSet rs = null;
        PreparedStatement prdstmt = null;
        Medewerker tempMedewerker = new Medewerker();

        String query = "SELECT * FROM `Users` WHERE userId=?;";

        conn.startConnection();

        prdstmt = conn.getConnection().prepareStatement(query);
        prdstmt.setInt(1, medewerkerId);
        rs = conn.performSelect(prdstmt);

        while (rs.next()) {
            tempMedewerker.setId(rs.getInt("userId"));
            tempMedewerker.setUsername(rs.getString("userName"));
            tempMedewerker.setPassword(rs.getString("userPass"));
            tempMedewerker.setName(rs.getString("userRealName"));
            tempMedewerker.setUserLang(rs.getString("userLang"));
            tempMedewerker.setManager(rs.getBoolean("userManager"));
            tempMedewerker.setAppManager(rs.getBoolean("userBeheer"));
            break;
        }

        if (conn != null) {
            conn.closeConnection();
        }

        return tempMedewerker;
    }

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
            tempMedewerker.setId(rs.getInt("userId"));
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

    public int update(Medewerker medewerker) throws SQLException {
        PreparedStatement prdstmt = null;
        String query = "UPDATE `Users` SET `userName`=?, `userRealName`=?, `userPass`=?, `userManager`=?, `userBeheer`=?, `userLang`=? WHERE `userId`=?;";

        String queryUserName, queryName, queryPass, queryUserLang;
        boolean queryManager, queryAppManager;
        queryUserName = medewerker.getUsername();
        queryName = medewerker.getName();
        queryPass = medewerker.getPassword();
        queryUserLang = medewerker.getUserLang();
        queryManager = medewerker.isManager();
        queryAppManager = medewerker.isAppManager();
        System.err.println(medewerker.toString());
        conn.startConnection();
        //  conn = (ConnectionMySQL) DriverManager.getConnection(url, user, pw);
        prdstmt = conn.getConnection().prepareStatement(query);
        // some code needs to be writing
        //ps = conn.prepareStatement(query);
        prdstmt.setString(1, queryUserName);
        prdstmt.setString(2, queryName);
        prdstmt.setString(3, queryPass);
        prdstmt.setBoolean(4, queryManager);
        prdstmt.setBoolean(5, queryAppManager);
        prdstmt.setString(6, queryUserLang);
        prdstmt.setInt(7, medewerker.getId());
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

    public Medewerker getMedewerkerById(int handlerID) throws SQLException {
        Medewerker result = new Medewerker();
        ResultSet rs = null;
        PreparedStatement prdstmt = null;

        String query = "SELECT * FROM `Users` WHERE userId=?;";

        conn.startConnection();

        prdstmt = conn.getConnection().prepareStatement(query);
        prdstmt.setInt(1, handlerID);
        rs = conn.performSelect(prdstmt);
        while (rs.next()) {
            result.setId(rs.getInt("userId"));
            result.setUsername(rs.getString("userName"));
            result.setPassword(rs.getString("userPass"));
            result.setName(rs.getString("userRealName"));
            result.setUserLang(rs.getString("userLang"));
            result.setManager(rs.getBoolean("userManager"));
            result.setAppManager(rs.getBoolean("userBeheer"));
            break;
        }

        if (conn != null) {
            conn.closeConnection();
        }

        return result;
    }
}
