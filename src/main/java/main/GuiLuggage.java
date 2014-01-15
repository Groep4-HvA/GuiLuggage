package main;

import java.awt.Cursor;
import java.util.Locale;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import models.Check;
import models.Debug;

/**
 *
 * @author groep 4
 */
public class GuiLuggage {

    /**
     * Init of the program
     * @param args 
     */
    public static void main(String[] args) {
	Check.checkConfigFile();
        Check.checkConnection();

        Cursor waiting = new Cursor(Cursor.WAIT_CURSOR);
	Locale english, dutch, current;
	english = new Locale("en", "US");
	dutch = new Locale("nl", "NL");

	Locale.setDefault(english);

	current = Locale.getDefault();
	logIn login = new logIn();
	login.setVisible(true);
	login.setLocationRelativeTo(null);
      //  login.setCursor(waiting);
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
