package popups;

import java.awt.Color;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import models.Check;
import models.Debug;
import models.User;
import models.UserDAO;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author workplz
 */
public class MyAccount extends javax.swing.JDialog {

    private final Color red = new Color(163, 0, 15);
    private User tempMedewerker = null;
    private final UserDAO medewerkerTijdelijk = new UserDAO();
    private int lang = 0;

    /**
     * Creates new form PasswordConfirm
     *
     * @param parent
     * @param modal
     * @param medewerkerID
     */
    public MyAccount(java.awt.Frame parent, boolean modal, int medewerkerID) {
        super(parent, modal);
        if (!Check.verifyLogin()) {
            Runtime.getRuntime().exit(1);
        } else {
            this.setUndecorated(true);
            getRootPane().setBorder(BorderFactory.createLineBorder(red));
            initComponents();
            this.setLocationRelativeTo(null);
            try {
                tempMedewerker = medewerkerTijdelijk.readByID(medewerkerID);
            } catch (SQLException e) {
                Debug.printError(e.toString());
            }
            if (tempMedewerker.getUserLang().equals("EN")) {
                dropDown.setSelectedIndex(0);
                Debug.println("EN");
                lang = 0;
            } else {
                dropDown.setSelectedIndex(1);
                Debug.println("NL");
                lang = 1;
            }
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

        languageLabel = new javax.swing.JLabel();
        passLabel = new javax.swing.JLabel();
        confirmPassLabel = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        passwordConfirm = new javax.swing.JPasswordField();
        dropDown = new javax.swing.JComboBox();
        saveBut = new javax.swing.JButton();
        cancelBut = new javax.swing.JButton();
        oldPassLabel = new javax.swing.JLabel();
        passwordOld = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Bundle"); // NOI18N
        languageLabel.setText(bundle.getString("MyAcc.langLabel")); // NOI18N

        passLabel.setText(bundle.getString("MyAcc.passLabel")); // NOI18N

        confirmPassLabel.setText(bundle.getString("MyAcc.confPassLabel")); // NOI18N

        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });

        dropDown.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "English", "Nederlands" }));
        dropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropDownActionPerformed(evt);
            }
        });

        saveBut.setText(bundle.getString("MyAcc.saveButton")); // NOI18N
        saveBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButActionPerformed(evt);
            }
        });

        cancelBut.setText(bundle.getString("MyAcc.cancelButton")); // NOI18N
        cancelBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButActionPerformed(evt);
            }
        });

        oldPassLabel.setText(bundle.getString("MyAcc.oldPassLabel")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saveBut)
                        .addGap(243, 243, 243)
                        .addComponent(cancelBut))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(confirmPassLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(passwordConfirm))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(password))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(oldPassLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(languageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordOld)
                            .addComponent(dropDown, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(languageLabel)
                    .addComponent(dropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordOld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oldPassLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmPassLabel)
                    .addComponent(passwordConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBut)
                    .addComponent(cancelBut))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the current form
     * @param evt 
     */
    private void cancelButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButActionPerformed

    /**
     * save when pressing enter in password
     * @param evt 
     */
    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        saveButActionPerformed(evt);
    }//GEN-LAST:event_passwordActionPerformed

    /**
     * Save the settings
     * @param evt 
     */
    private void saveButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButActionPerformed
        boolean change = false; //Determines if there are changes

        if (dropDown.getSelectedIndex() != lang) {//There are changes
            if (dropDown.getSelectedIndex() == 0) {
                Locale.setDefault(new Locale("en", "US"));
                tempMedewerker.setUserLang("EN");
            }
            if (dropDown.getSelectedIndex() == 1) {
                Locale.setDefault(new Locale("nl", "NL"));
                tempMedewerker.setUserLang("NL");
            }
            change = true;//Set the changes
        }
        Debug.println(change + "");
        if (password.getPassword().length == 0) {
            dispose();
        } else {
            if (password.getPassword().length > 5) {
                Debug.println(password.getPassword().toString());
                if (tempMedewerker.getPassword().equals(DigestUtils.sha256Hex(String.valueOf(passwordOld.getPassword())))) {
                    if (Arrays.equals(password.getPassword(), passwordConfirm.getPassword())) {
                        if (!tempMedewerker.getPassword().equals(DigestUtils.sha256Hex(String.valueOf(password.getPassword())))) {
                            tempMedewerker.setPassword(password.getPassword());
                            change = true;
                        }
                        Debug.println(tempMedewerker.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Passwords do not match");
                    }

                } else {
                    JOptionPane.showMessageDialog(null,
                            "Your input was invalid. Old password is not correct.",
                            "Input error - not correct",
                            JOptionPane.ERROR_MESSAGE);
//                            dispose();
                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "Your input was invalid. Passwords must be atleast 6 characters.",
                        "Input error - not correct",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        Debug.println(change + "");
        if (change) {
            Debug.println(tempMedewerker.toString());
            try {
                medewerkerTijdelijk.update(tempMedewerker);//Save to DB
                dispose();
            } catch (SQLException e) {
                Debug.printError(e.toString());
            }
        }
    }//GEN-LAST:event_saveButActionPerformed

    private void dropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropDownActionPerformed
    }//GEN-LAST:event_dropDownActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton cancelBut;
    public javax.swing.JLabel confirmPassLabel;
    public javax.swing.JComboBox dropDown;
    public javax.swing.JLabel languageLabel;
    public javax.swing.JLabel oldPassLabel;
    public javax.swing.JLabel passLabel;
    public javax.swing.JPasswordField password;
    public javax.swing.JPasswordField passwordConfirm;
    public javax.swing.JPasswordField passwordOld;
    public javax.swing.JButton saveBut;
    // End of variables declaration//GEN-END:variables
}
