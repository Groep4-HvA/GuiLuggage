package DBUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ahmed
 */
public class ConnectionMySQL {
    public static String DRIVER = "com.mysql.jdbc.Driver";
    public static String DBURL;
    public static String DBUSER;
    public static String DBPASS;

    private ResultSet result = null;
    private int affectedRows = -1;
    Connection conn = null;

    
    public ConnectionMySQL(){
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(System.getProperty("user.dir")+"/Config.properties"));
        } catch (IOException ex) {
            Logger.getLogger(ConnectionMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        String ip = prop.getProperty("db_ip");
        String dbName = prop.getProperty("db_name");
        DBUSER = prop.getProperty("db_username");
        DBPASS = prop.getProperty("db_password");
        DBURL = "jdbc:mysql://" + ip + ":3306/" + dbName;
    }

    public void startConnection()  {
        try {
            
            Class.forName(DRIVER);
            DriverManager.setLoginTimeout(5);
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            
        } catch (Exception e) {
            
        }
    }

    public void closeConnection()  {
       try{
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
       } catch (Exception e) {
                       
        }
        conn = null;
    }

    public ResultSet performSelect(PreparedStatement prdstmt) throws SQLException {       
            result = prdstmt.executeQuery();
        
        return result;
    }

    public int performUpdate(PreparedStatement prdstmt) throws SQLException {
        
            affectedRows = prdstmt.executeUpdate();
       
        return affectedRows;
    }

    public Connection getConnection() {
        return conn;
    }
    
    
}
