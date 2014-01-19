package models;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

/**
 *
 * @author smillernl
 */
public class Debug {

    private static PrintWriter wout = null;

    /**
     * print a string (location is based on settings)
     *
     * @see system.out.println()
     * @param out
     */
    public static void println(String out) {
        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream(System.getProperty("user.dir") + System.getProperty("file.separator") + "Config.properties"));
        } catch (IOException e) {
            Debug.printError(e.toString());
        }
        if (prop.getProperty("debug").equals("true")) {
            System.out.println("LOG(Debug):" + out);
        } else {
            try {
                wout = new PrintWriter(new BufferedWriter(new FileWriter(System.getProperty("user.dir") + System.getProperty("file.separator") + "log.txt", true)));
                wout.println("LOG(Debug):" + out);
                wout.close();
            } catch (IOException e) {
                Debug.println(e.toString());
            }
        }
    }

    /**
     * Print an error to the log and the console
     *
     * @see system.err.println()
     * @param out
     */
    public static void printError(String out) {
        System.err.println("LOG(Error):" + out);
        try {
            wout = new PrintWriter(new BufferedWriter(new FileWriter(System.getProperty("user.dir") + System.getProperty("file.separator") + "log.txt", true)));
            wout.println("LOG(Error):" + out);
            wout.close();
        } catch (IOException e) {
            Debug.println(e.toString());
        }
    }

    /**
     * Constructor
     */
    public Debug() {
    }
}
