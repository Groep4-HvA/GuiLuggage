package models;

import DBUtil.ConnectionMySQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ChrisvanderHeijden
 */
public class UserDAO {

    ConnectionMySQL conn = new ConnectionMySQL();
    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private final Date date = new Date();
    private final String dateString = dateFormat.format(date);

    /**
     * Constructor
     */
    public UserDAO() {
        // initialization 
    }

    /**
     * Find the param string in the DB and return the matches.
     * @param searchInput
     * @return A list with the results
     * @throws SQLException 
     */
    public List<User> search(String searchInput) throws SQLException {

        List<User> list = new LinkedList<User>();
        ResultSet rs;
        PreparedStatement prdstmt;

        String query = "SELECT `userName`, `userRealName`, `userPass`, `userBeheer`, `userLang` FROM `Users` WHERE `username` LIKE ? OR `userRealName` LIKE ? OR `userBeheer` LIKE ? LIMIT 50";

        conn.startConnection();

        prdstmt = conn.getConnection().prepareStatement(query);

        prdstmt.setString(1, "%" + searchInput + "%");
        prdstmt.setString(2, "%" + searchInput + "%");
        prdstmt.setString(3, "%" + searchInput + "%");

        rs = conn.performSelect(prdstmt);

        while (rs.next()) {
            User tempMedewerker = new User();
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

    /**
     * List 50 of the Users in the DB
     * @return a list of 50 users as a User object arraylist
     * @throws SQLException 
     */
    public List<User> readAll() throws SQLException {
        List<User> list = new LinkedList<User>();
        ResultSet rs;
        PreparedStatement prdstmt;

        String query = "SELECT  * FROM `Users` LIMIT 51";

        conn.startConnection();

        prdstmt = conn.getConnection().prepareStatement(query);
        rs = conn.performSelect(prdstmt);

        while (rs.next()) {
            User tempMedewerker = new User();
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

    /**
     * Read the rest of the Users from the DB
     * @return a list of all users as a User object arraylist
     * @throws SQLException 
     * @see readAll()
     */
    public List<User> readAllMore() throws SQLException {
        List<User> list = new LinkedList<User>();
        ResultSet rs;
        PreparedStatement prdstmt;

        String query = "SELECT  * FROM `Users` LIMIT 100";

        conn.startConnection();

        prdstmt = conn.getConnection().prepareStatement(query);
        rs = conn.performSelect(prdstmt);

        while (rs.next()) {
            User tempMedewerker = new User();
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

    /**
     * Read the user by ID. Used to get the users name to display in the overview
     * This makes it harder to connect a certain name to a case and allows names to change
     * @param medewerkerId
     * @return a user based on the ID
     * @throws SQLException 
     */
    public User readByID(int medewerkerId) throws SQLException {
        ResultSet rs;
        PreparedStatement prdstmt;
        User tempMedewerker = new User();

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

    /**
     * Gets a users details based on the password and the username
     * @param user
     * @param pass
     * @return A user Object
     * @throws SQLException 
     */
    public List<User> readLogIn(String user, String pass) throws SQLException {
        List<User> list = new LinkedList<User>();
        ResultSet rs;
        PreparedStatement prdstmt;

        String query = "SELECT * FROM `Users` WHERE userName=? AND userPass=?;";

        conn.startConnection();

        prdstmt = conn.getConnection().prepareStatement(query);
        prdstmt.setString(1, user);
        prdstmt.setString(2, pass);
        rs = conn.performSelect(prdstmt);

        while (rs.next()) {
            User tempMedewerker = new User();
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

    /**
     * Create a new DB entry based on a user object
     * @param medewerker
     * @return the state of the query
     * @throws SQLException 
     */
    public int create(User medewerker) throws SQLException {
        PreparedStatement prdstmt;
        String query = "INSERT INTO `Users` (`userName`, `userRealName`, `userPass`, `userManager`, `userBeheer`, `userLang`, `passDate`) VALUES(?, ?, ?, ?, ?, ?, ?);";

        conn.startConnection();
        //  conn = (ConnectionMySQL) DriverManager.getConnection(url, user, pw);
        prdstmt = conn.getConnection().prepareStatement(query);
        // some code needs to be writing
        //ps = conn.prepareStatement(query);

        prdstmt.setString(1, medewerker.getUsername().toLowerCase());
        prdstmt.setString(2, medewerker.getName());
        prdstmt.setString(3, medewerker.getPassword());
        prdstmt.setBoolean(4, medewerker.isManager());
        prdstmt.setBoolean(5, medewerker.isAppManager());
        prdstmt.setString(6, medewerker.getUserLang());
        prdstmt.setString(7, dateString);
        prdstmt.executeUpdate();

        if (conn != null) {
            conn.closeConnection();
        }
        return -1;
    }

    /**
     * Update a DB entry based on a User Object
     * @param medewerker
     * @return status of the query
     * @throws SQLException 
     */
    public int update(User medewerker) throws SQLException {
        PreparedStatement prdstmt;
        String query = "UPDATE `Users` SET `userName`=?, `userRealName`=?, `userPass`=?, `userManager`=?, `userBeheer`=?, `userLang`=?, `passDate`=? WHERE `userId`=?;";

        String queryUserName, queryName, queryPass, queryUserLang;
        boolean queryManager, queryAppManager;
        queryUserName = medewerker.getUsername();
        queryName = medewerker.getName();
        queryPass = medewerker.getPassword();
        queryUserLang = medewerker.getUserLang();
        queryManager = medewerker.isManager();
        queryAppManager = medewerker.isAppManager();
        Debug.println(medewerker.toString());
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
        prdstmt.setString(7, dateString);
        prdstmt.setInt(8, medewerker.getId());

        prdstmt.executeUpdate();

        if (conn != null) {
            conn.closeConnection();
        }
        return -1;
    }

    /**
     * Delete a user
     * @param medewerker
     * @return status of the query
     * @throws SQLException 
     */
    public int delete(User medewerker) throws SQLException {

        PreparedStatement prdstmt;
        String query = "DELETE FROM Users WHERE userName =?";

        String queryUserName;

        queryUserName = medewerker.getUsername();

        conn.startConnection();

        prdstmt = conn.getConnection().prepareStatement(query);
        prdstmt.setString(1, queryUserName);

        prdstmt.executeUpdate();

        if (conn != null) {
            conn.closeConnection();
        }
        return -1;
    }

    public User getMedewerkerById(int handlerID) throws SQLException {
        User result = new User();
        ResultSet rs;
        PreparedStatement prdstmt;

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
