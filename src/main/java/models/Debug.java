/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import DBUtil.ConnectionMySQL;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author smillernl
 */
public class Debug {

    private static Properties prop;

    public Debug() {
    }

    public static void out(String out) {
        try {
            prop.load(new FileInputStream(System.getProperty("user.dir") + System.getProperty("file.separator") + "Config.properties"));
        } catch (IOException ex) {
            Logger.getLogger(ConnectionMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (prop.getProperty("debug").equals("true")) {
            System.out.println(out);
        } else {
            Writer writer = null;

            try {
                writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(System.getProperty("user.dir") + System.getProperty("file.separator") + "log.txt"), "UTF-8"));
                writer.write("LOG(Debug):" + out);
            } catch (IOException ex) {
                //TODO add exception for report
            } finally {
                try {
                    writer.close();
                } catch (Exception ex) {
                }
            }
        }
    }
}
