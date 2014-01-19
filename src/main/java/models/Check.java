package models;

import DBUtil.ConnectionMySQL;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;
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
    private static User medew;

    /**
     * log in (set the variable)
     *
     * @param medew
     */
    public static void setMedew(User medew) {
        Check.medew = medew;
    }

    /**
     * log out (clear the variable)
     *
     * @param medew
     */
    public static void resetMedew(User medew) {
        Check.medew = null;
    }

    /**
     * Clean up the label
     *
     * @param label
     * @return
     */
    static public String cleanAlphaNumeriek(String label) {
        label = label.replaceAll("[^0-9A-Za-z\\s]", "");
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

    static public String cleanAlpha(String kleur) {
        kleur = kleur.replaceAll("[^A-Za-z\\s]", "");
        return kleur;
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

        if (label == null || phoneNr == null || location == null) {
            verified = false;
        } else if (label.equals("") || phoneNr.equals("") || location.equals("")) {
            verified = false;
        } else {
            verified = true;
        }
        return verified;
    }

    /**
     * Verify if the passenger is valid
     * @param label
     * @param color
     * @param shape
     * @param name
     * @param surname
     * @param adres
     * @param postalCode
     * @param city
     * @param residentAdres
     * @param residentPostalCode
     * @param residentCity
     * @param details
     * @param phoneNr
     * @param email
     * @return validity of the passenger
     */
    static public boolean verifyPassenger(String label, String color, String shape, String name, String surname, String adres, String postalCode, String city, String residentAdres, String residentPostalCode, String residentCity, String details, String phoneNr, String email) {
        boolean verified = true;

        if (label == null || name == null || surname == null || phoneNr == null || adres == null || postalCode == null || city == null || phoneNr == null) {
            verified = false;
        } else if (label.equals("") || name.equals("") || surname.equals("") || adres.equals("") || postalCode.equals("") || city.equals("") || phoneNr.equals("")) {
            verified = false;
        } else {
            verified = true;
        }
        return verified;
    }

    /**
     * Verify if the user is valid
     * @param name
     * @param username
     * @param password
     * @return 
     */
    static public boolean verifyUser(String name, String username, char[] password) {
        boolean verified = true;

        if (name == null || username == null) {
            verified = false;
        } else if (name.equals("") || username.equals("")) {
            verified = false;
        } else if (password.length < 6) {
            verified = false;
        } else if (username.length() < 3) {
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
        boolean noResult = true;
        try {
            ConnectionMySQL conn = new ConnectionMySQL();
            ResultSet rs, rs2;
            PreparedStatement prdstmt, prdstmt2;

            String query2 = "show tables like 'cases'";
            String query = "show tables like 'Users'";
            conn.startConnection();

            prdstmt = conn.getConnection().prepareStatement(query);
            rs = conn.performSelect(prdstmt);
            if (rs.next()) {
                noResult = false;
            } else {
                String queryCreate = "CREATE TABLE `Users` (\n"
                        + "  `userId` int(11) NOT NULL AUTO_INCREMENT,\n"
                        + "  `userName` varchar(255) NOT NULL,\n"
                        + "  `userRealName` varchar(255) NOT NULL,\n"
                        + "  `userPass` varchar(255) NOT NULL DEFAULT '',\n"
                        + "  `userManager` tinyint(1) DEFAULT NULL,\n"
                        + "  `userBeheer` tinyint(1) NOT NULL,\n"
                        + "  `userLang` varchar(2) DEFAULT NULL,\n"
                        + "  `passDate` date NOT NULL,\n"
                        + "  PRIMARY KEY (`userId`),\n"
                        + "  UNIQUE KEY `userId_UNIQUE` (`userId`),\n"
                        + "  UNIQUE KEY `userName_UNIQUE` (`userName`)\n"
                        + ") ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=latin1;";
                prdstmt = conn.getConnection().prepareStatement(queryCreate);
                int ans = conn.performUpdate(prdstmt);

                String makeAdmin = "INSERT INTO `Users` (`userName`, `userRealName`, `userPass`, `userManager`, `userBeheer`, `userLang`, `passDate`) VALUES('admin', 'admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 0, 1, 'EN', NOW());";
                prdstmt = conn.getConnection().prepareStatement(makeAdmin);
                int ans2 = conn.performUpdate(prdstmt);

                prdstmt2 = conn.getConnection().prepareStatement(query2);
                rs2 = conn.performSelect(prdstmt2);
                if (!rs2.next()) {
                    String queryCreate2 = "CREATE TABLE `cases` ( `LuggageNumber` varchar(255) NOT NULL,"
                            + "`Name` varchar(255) DEFAULT NULL,"
                            + "`Surname` varchar(255) DEFAULT NULL,"
                            + "`homeAddress` varchar(255) DEFAULT NULL,"
                            + "`homePostalCode` varchar(10) DEFAULT NULL,"
                            + "`homeCity` varchar(255) DEFAULT NULL,"
                            + "`residentAddress` varchar(255) DEFAULT NULL,"
                            + "`residentPostalCode` varchar(10) DEFAULT NULL,"
                            + "`residentCity` varchar(255) DEFAULT NULL,"
                            + "`PhoneNr` varchar(15) NOT NULL,"
                            + "`Color` varchar(255) DEFAULT NULL,"
                            + "`Shape` varchar(255) DEFAULT NULL,"
                            + "`AditionalDetails` varchar(255) DEFAULT NULL,"
                            + "`StorageLocation` varchar(255) DEFAULT NULL,"
                            + "`HandlerID` int(11) NOT NULL,"
                            + "`AddDate` datetime NOT NULL,"
                            + "`ResolveDate` datetime DEFAULT NULL,"
                            + "`EmailAdress` varchar(255) DEFAULT NULL,"
                            + "PRIMARY KEY(`LuggageNumber`),"
                            + "UNIQUE KEY `LuggageNumber_UNIQUE` (`LuggageNumber`)"
                            + ") ENGINE = InnoDB DEFAULT CHARSET = latin1;";
                    prdstmt = conn.getConnection().prepareStatement(queryCreate2);
                    int ans3 = conn.performUpdate(prdstmt);
                }

            }
            if (conn != null) {
                conn.closeConnection();
            }
        } catch (SQLException e) {
            Debug.printError(e.toString());
            JOptionPane.showMessageDialog(null, BUNDLE.getString("error.db.notconnected"), BUNDLE.getString("error.db.notconnected.title"), JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } catch (NullPointerException e) {
            Debug.printError(e.toString());
            JOptionPane.showMessageDialog(null, BUNDLE.getString("error.db.notconnected"), BUNDLE.getString("error.db.notconnected.title"), JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        if (noResult) {
            JOptionPane.showMessageDialog(null, BUNDLE.getString("error.db.initialized"), BUNDLE.getString("error.db.initialized.title"), JOptionPane.INFORMATION_MESSAGE);
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
                prop.load(Check.class.getClassLoader().getResourceAsStream("Config.sample.properties"));
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
     * Compare two dates and return the difference in days
     *
     * @param d1 The first date
     * @param d2 The second date
     * @return Difference between d1 and d2
     */
    public static int dateDiff(Date d1, Date d2) {
        long diff = d2.getTime() - d1.getTime();
        int diffDays = (int) (diff / (24 * 60 * 60 * 1000));

        return diffDays;

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
