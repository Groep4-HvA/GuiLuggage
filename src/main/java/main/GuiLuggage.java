package main;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author groep 4
 */
public class GuiLuggage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Locale english, dutch, current;
       
        english = new Locale("en", "US");
        dutch = new Locale("nl", "NL");
        
        Locale.setDefault(english);
        
        current = Locale.getDefault();
        System.out.println("Current language: "+current.toString());
        logIn login = new logIn();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        
    }
}
