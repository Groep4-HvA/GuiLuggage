package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.Properties;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import models.Debug;

/**
 *
 * @author groep 4
 */
public class GuiLuggage {
    private static String orig_dbIp;
    private static String orig_dbName;
    private static String orig_dbUser;
    private static String orig_dbPass;
    private static String orig_debug;

    /**
     * Init of the program
     * @param args 
     */
    public static void main(String[] args) {
	checkConfigFile();

	Locale english, dutch, current;
	english = new Locale("en", "US");
	dutch = new Locale("nl", "NL");

	Locale.setDefault(english);

	current = Locale.getDefault();
	logIn login = new logIn();
	login.setVisible(true);
	login.setLocationRelativeTo(null);
	Debug.println("Current language: " + current.toString());
	try {
	    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	} catch (ClassNotFoundException e) {
	    Debug.printError(e.toString());
	} catch (IllegalAccessException e) {
	    Debug.printError(e.toString());
	} catch (InstantiationException e) {
	    Debug.printError(e.toString());
	} catch (UnsupportedLookAndFeelException e) {
	    Debug.printError(e.toString());
	}

    }
    /**
     * Check if the config file is valid and complete
     */
    private static void checkConfigFile() {
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
	    writer.close();
	}
    }

    /**
     * Check if all settings can be read
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
	} catch (Exception e) {
	    Debug.println(e.toString());
	    result = false;
	}
	if (orig_dbIp == null || orig_dbName == null || orig_dbUser == null || orig_dbPass == null || orig_debug == null) {
	    result = false;
	}
	return result;
    }
}
