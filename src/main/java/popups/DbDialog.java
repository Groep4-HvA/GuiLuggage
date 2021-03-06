package popups;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import models.Check;
import models.Debug;

/**
 *
 * @author Sean Molenaar
 */
public class DbDialog extends javax.swing.JDialog {

    /**
     * Creates new form DbDialog
     */
    private final java.util.ResourceBundle BUNDLE = java.util.ResourceBundle.getBundle("Bundle"); // NOI18N
    private Properties prop;

    /**
     * Constructor
     * @param parent
     * @param modal 
     */
    public DbDialog(java.awt.Frame parent, boolean modal) {
	super(parent, modal);
	if (!Check.verifyLogin()) {
	    Runtime.getRuntime().exit(1);
	} else {
	    this.setUndecorated(true);
	    initComponents();
	    this.setLocationRelativeTo(null);
	    prop = new Properties();
	    try {
		prop.load(new FileInputStream(System.getProperty("user.dir") + System.getProperty("file.separator") + "Config.properties"));
	    } catch (IOException e) {
		Debug.printError(e.toString());
	    }
	    dbHostInput.setText(prop.getProperty("db_ip"));
	    dbNameInput.setText(prop.getProperty("db_name"));
	    dbUserInput.setText(prop.getProperty("db_username"));
	    Debug.println("Done");
	}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dbHost = new javax.swing.JLabel();
        dbHostInput = new javax.swing.JTextField();
        dbName = new javax.swing.JLabel();
        dbNameInput = new javax.swing.JTextField();
        dbUser = new javax.swing.JLabel();
        dbUserInput = new javax.swing.JTextField();
        dbPass = new javax.swing.JLabel();
        dbPassInput = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Bundle"); // NOI18N
        dbHost.setText(bundle.getString("dbSetting.host")); // NOI18N

        dbName.setText(bundle.getString("dbSetting.dbName")); // NOI18N

        dbUser.setText(bundle.getString("dbSetting.user")); // NOI18N

        dbPass.setText(bundle.getString("dbSetting.pass")); // NOI18N

        cancelButton.setText(bundle.getString("dbSetting.cancelButton")); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        saveButton.setText(bundle.getString("dbSetting.saveButton")); // NOI18N
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dbName)
                            .addComponent(dbHost))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dbNameInput)
                            .addComponent(dbHostInput)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dbUser)
                            .addComponent(dbPass))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dbPassInput)
                            .addComponent(dbUserInput, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cancelButton)
                        .addGap(18, 18, 18)
                        .addComponent(saveButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dbHost)
                    .addComponent(dbHostInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dbName)
                    .addComponent(dbNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dbUser)
                    .addComponent(dbUserInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dbPass)
                    .addComponent(dbPassInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(saveButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the form
     * @param evt 
     */
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
	dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * Save the editted data
     * @param evt 
     */
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
	try {
	    prop.setProperty("db_ip", dbHostInput.getText());
	    prop.setProperty("db_name", dbNameInput.getText());
	    prop.setProperty("db_username", dbUserInput.getText());
	    prop.setProperty("db_password", dbPassInput.getText());
	    prop.store(new FileOutputStream("Config.properties"), null);
	    dispose();
	} catch (IOException e) {
	    Debug.printError(e.toString());
	}
    }//GEN-LAST:event_saveButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel dbHost;
    private javax.swing.JTextField dbHostInput;
    private javax.swing.JLabel dbName;
    private javax.swing.JTextField dbNameInput;
    private javax.swing.JLabel dbPass;
    private javax.swing.JTextField dbPassInput;
    private javax.swing.JLabel dbUser;
    private javax.swing.JTextField dbUserInput;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
