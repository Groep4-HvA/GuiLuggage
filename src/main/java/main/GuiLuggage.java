package main;

import java.util.Locale;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import models.Check;
import models.Debug;

/**
 * The Correndon Luggage System
 * @author Group 4 of IS104 HvA
 * @version 1.5 Final release
 * @see https://github.com/Groep4-HvA/GuiLuggage
 */
public class GuiLuggage {

    /**
     * Init of the program
     *
     * @param args
     */
    public static void main(String[] args) {
        Check.checkConfigFile();
        Check.checkConnection();
        Locale english, current;
        english = new Locale("en", "US");

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
}
