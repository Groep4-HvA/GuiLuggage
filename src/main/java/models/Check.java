package models;

import DBUtil.ConnectionMySQL;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * The checks for variables or being logged in
 *
 * @author smillernl
 */
public class Check {

    private static String orig_dbIp;
    private static String orig_dbName;
    private static String orig_dbUser;
    private static String orig_dbPass;
    private static String orig_debug;
    private static String orig_airfield;
    private static final java.util.ResourceBundle BUNDLE = java.util.ResourceBundle.getBundle("Bundle");

    private static Medewerker medew;

    /**
     * log in (set the variable)
     *
     * @param medew
     */
    public static void setMedew(Medewerker medew) {
        Check.medew = medew;
    }

    /**
     * log out (clear the variable)
     *
     * @param medew
     */
    public static void resetMedew(Medewerker medew) {
        Check.medew = null;
    }

    /**
     * Clean up the label
     *
     * @param label
     * @return
     */
    static public String cleanLabel(String label) {
        label = label.replaceAll("\\s+", "");
        return label;
    }

    /**
     * Clean up the phone number
     *
     * @param number
     * @return
     */
    static public String cleanPhone(String number) {
        number = number.replaceAll("[^0-9()+]", "");
        return number;
    }

    /**
     * Check of the data in luggage is valid
     *
     * @param label the labelnr of the luggage
     * @param color the color of the luggage
     * @param shape the shape of the luggage
     * @param location the location where you temporarily stored the luggage
     * @param details any further details of the luggage
     * @param phoneNr the phoneNr of the person dropping of the luggage
     * @return if parameters are valid
     */
    static public boolean verifyLuggage(String label, String color, String shape, String location, String details, String phoneNr) {
        boolean verified = true;
        
        if (label == null || color == null || phoneNr == null) {
            verified = false;
        } else if (label.equals("") || color.equals("") || phoneNr.equals("")) {
            verified = false;
        } else {
            verified = true;
        }
        return verified;
    }

    /**
     * Verify if there was ever someone logged in
     *
     * @return loggedIn
     */
    public static boolean verifyLogin() {
        try {
            return medew.getName() != null && medew.getPassword() != null;
        } catch (NullPointerException e) {
            Debug.printError(e.toString());
            return false;
        }
    }

    /**
     * Checks the connection to the database
     */
    public static void checkConnection() {
        boolean result = false;
        try {
            ConnectionMySQL connect = new ConnectionMySQL();
            connect.getConnection();
            Connection con = connect.getConnection();
            Statement stmt = null;
            try{
                stmt = con.createStatement();
                result = stmt.execute("show tables;");
            }catch(NullPointerException e){
                Debug.printError(e.toString());
                JOptionPane.showMessageDialog(null, BUNDLE.getString("error.db.notconnected"), BUNDLE.getString("error.db.notconnected.title"), JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
            if (result) {
                Debug.println("SQL command was executed sucessfully");
            } else {
                JOptionPane.showMessageDialog(null, BUNDLE.getString("error.db.notconnected"), BUNDLE.getString("error.db.notconnected.title"), JOptionPane.ERROR_MESSAGE);
            }
            connect.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Check.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Check if the config file is valid and complete
     */
    public static void checkConfigFile() {
        boolean fullSettings = settingsRead();
        File f = new File(System.getProperty("user.dir") + "/Config.properties");
        if (f.exists() && fullSettings) {
            Debug.println("All clear, starting application");
        } else {
            Properties prop = new Properties();
            try {
                prop.load(new FileInputStream(System.getProperty("user.dir") + "/Config.sample.properties"));
            } catch (IOException e) {
                Debug.printError(e.toString());
            }
            String ip = (orig_dbIp != null) ? orig_dbIp : prop.getProperty("db_ip");
            String dbName = (orig_dbName != null) ? orig_dbName : prop.getProperty("db_name");
            String dbUser = (orig_dbUser != null) ? orig_dbUser : prop.getProperty("db_username");
            String dbPass = (orig_dbPass != null) ? orig_dbPass : prop.getProperty("db_password");
            String debug = (orig_debug != null) ? orig_debug : prop.getProperty("debug");
            String airfield = (orig_airfield != null) ? orig_airfield : prop.getProperty("airfield");

            PrintWriter writer = null;
            try {
                writer = new PrintWriter("Config.properties", "UTF-8");
            } catch (FileNotFoundException e) {
                Debug.printError(e.toString());
            } catch (UnsupportedEncodingException e) {
                Debug.printError(e.toString());
            }
            writer.println("#This file is generated from the sample file because no file was found, or not all values was found");
            writer.println();
            writer.println("db_ip=" + ip);
            writer.println("db_name=" + dbName);
            writer.println("db_username=" + dbUser);
            writer.println("db_password=" + dbPass);
            writer.println("debug=" + debug);
            writer.println("airfield=" + airfield);
            writer.close();
        }
    }

    /**
     * Check if all settings can be read
     *
     * @return settings can be read or not
     */
    private static boolean settingsRead() {
        boolean result = true;
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(System.getProperty("user.dir") + "/Config.properties"));
        } catch (IOException ex) {
            result = false;
            System.err.println("No config file found, generating one...");
        }
        try {
            orig_dbIp = prop.getProperty("db_ip");
            orig_dbName = prop.getProperty("db_name");
            orig_dbUser = prop.getProperty("db_username");
            orig_dbPass = prop.getProperty("db_password");
            orig_debug = prop.getProperty("debug");
            orig_airfield = prop.getProperty("airfield");
        } catch (Exception e) {
            Debug.println(e.toString());
            result = false;
        }
        if (orig_dbIp == null || orig_dbName == null || orig_dbUser == null || orig_dbPass == null || orig_debug == null || orig_airfield == null) {
            result = false;
        }
        return result;
    }
}
