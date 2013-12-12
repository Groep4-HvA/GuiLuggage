package main;

import java.util.Locale;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import models.Debug;

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
        logIn login = new logIn();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        Debug.printout("Current language: "+current.toString());
        try{ 
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        
    }
}
