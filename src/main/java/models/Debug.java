/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import DBUtil.ConnectionMySQL;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author smillernl
 */
public class Debug {
    private static PrintWriter wout = null;

    public Debug() {

    }

    public static void println(String out) {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(System.getProperty("user.dir") + System.getProperty("file.separator") + "Config.properties"));
        } catch (IOException ex) {
            Logger.getLogger(ConnectionMySQL.class.getName()).log(Level.SEVERE, null, ex);
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
}
