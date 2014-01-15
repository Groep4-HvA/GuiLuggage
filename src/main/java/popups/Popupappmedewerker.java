/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package popups;

import java.awt.Color;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import models.Check;
import models.Debug;
import models.Medewerker;
import models.MedewerkerDAO;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Jeroen
 */
public class Popupappmedewerker extends javax.swing.JFrame {

    private final Color red = new Color(163, 0, 15);
    private Medewerker medewerker = new Medewerker();

    /**
     * Creates new form Popupappmedewerker
     *
     * @param medewerker
     */
    public Popupappmedewerker(Medewerker medewerker) {
        if (!Check.verifyLogin()) {
            Runtime.getRuntime().exit(1);
        } else {
            this.medewerker = medewerker;
            this.setUndecorated(true);
            getRootPane().setBorder(BorderFactory.createLineBorder(red));
            initComponents();
            this.setLocationRelativeTo(null);
            fillData();
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

        userNameField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        passLabel = new javax.swing.JLabel();
        confirmPassLabel = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        firstPasswordField = new javax.swing.JPasswordField();
        confirmPasswordField = new javax.swing.JPasswordField();
        isAppManager = new javax.swing.JCheckBox();
        isManager = new javax.swing.JCheckBox();
        delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Bundle"); // NOI18N
        nameLabel.setText(bundle.getString("Popupappmedewerker.nameLabel.text")); // NOI18N
        nameLabel.setToolTipText(bundle.getString("Popupappmedewerker.nameLabel.toolTipText")); // NOI18N

        usernameLabel.setText(bundle.getString("Popupappmedewerker.usernameLabel.text")); // NOI18N

        passLabel.setText(bundle.getString("Popupappmedewerker.passLabel.text")); // NOI18N

        confirmPassLabel.setText(bundle.getString("Popupappmedewerker.confirmPassLabel.text")); // NOI18N

        saveButton.setText(bundle.getString("Popupappmedewerker.saveButton.text")); // NOI18N
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText(bundle.getString("Popupappmedewerker.cancelButton.text")); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        isAppManager.setText(bundle.getString("Popupappmedewerker.isAppManager.text")); // NOI18N
        isAppManager.setToolTipText(bundle.getString("Popupappmedewerker.isAppManager.toolTipText")); // NOI18N

        isManager.setText(bundle.getString("Popupappmedewerker.isManager.text")); // NOI18N
        isManager.setToolTipText(bundle.getString("Popupappmedewerker.isManager.toolTipText")); // NOI18N

        java.util.ResourceBundle bundle1 = java.util.ResourceBundle.getBundle("popups/Bundle"); // NOI18N
        delete.setText(bundle1.getString("Popupappmedewerker.delete.text")); // NOI18N
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(confirmPassLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(passLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton))
                    .addComponent(nameField)
                    .addComponent(userNameField)
                    .addComponent(firstPasswordField)
                    .addComponent(confirmPasswordField)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(isAppManager, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(isManager, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel)
                    .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passLabel)
                    .addComponent(firstPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmPassLabel)
                    .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(isAppManager)
                    .addComponent(isManager))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(saveButton)
                    .addComponent(delete))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fillData() {
        nameField.setText(medewerker.getName());
        userNameField.setText(medewerker.getUsername());
        isAppManager.setSelected(medewerker.isAppManager());
        isManager.setSelected(medewerker.isManager());
    }
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        medewerker.setName(nameField.getText());
        medewerker.setAppManager(isAppManager.isSelected());
        medewerker.setManager(isManager.isSelected());

        MedewerkerDAO dbMedewerker;
        dbMedewerker = new MedewerkerDAO();

        if (Arrays.equals(firstPasswordField.getPassword(), confirmPasswordField.getPassword()) && firstPasswordField.getPassword().length >5 ) {
            medewerker.setPassword(firstPasswordField.getPassword());
        }else {JOptionPane.showMessageDialog(null,
                    "Your input was invalid. Password and confirm password should have the same value and they have to be longer then 6 characters.",
                    "Input error - empty",
                    JOptionPane.ERROR_MESSAGE);
        }
        try {
            dbMedewerker.update(medewerker);
        } catch (SQLException e) {
            Debug.printError(e.toString());
        }
        Debug.println(medewerker.toString());
        dispose();
        
        
    }//GEN-LAST:event_saveButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed

        ConfirmPopup confirmPopup = new ConfirmPopup(userNameField.getText());
        confirmPopup.pack();
        confirmPopup.setVisible(true);
        confirmPopup.setLocationRelativeTo(null);

        medewerker.setUsername(userNameField.getText());

        dispose();

    }//GEN-LAST:event_deleteActionPerformed

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        this.dispose();
    }//GEN-LAST:event_formWindowLostFocus

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel confirmPassLabel;
    private javax.swing.JPasswordField confirmPasswordField;
    private javax.swing.JButton delete;
    private javax.swing.JPasswordField firstPasswordField;
    private javax.swing.JCheckBox isAppManager;
    private javax.swing.JCheckBox isManager;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel passLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField userNameField;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
