package popups;

import java.awt.Color;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import models.Check;
import models.Debug;
import models.User;
import models.UserDAO;

/**
 *
 * @author Jeroen
 */
public class UserEditDialog extends javax.swing.JFrame {

    private final Color red = new Color(163, 0, 15);
    private final java.util.ResourceBundle BUNDLE = java.util.ResourceBundle.getBundle("Bundle");
    private User medewerker = new User();

    /**
     * Creates new form UserEditDialog
     *
     * @param medewerker
     */
    public UserEditDialog(User medewerker) {
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

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Bundle"); // NOI18N
        nameLabel.setText(bundle.getString("UserEditDialog.nameLabel.text")); // NOI18N
        nameLabel.setToolTipText(bundle.getString("UserEditDialog.nameLabel.toolTipText")); // NOI18N

        usernameLabel.setText(bundle.getString("UserEditDialog.usernameLabel.text")); // NOI18N

        passLabel.setText(bundle.getString("UserEditDialog.passLabel.text")); // NOI18N

        confirmPassLabel.setText(bundle.getString("UserEditDialog.confirmPassLabel.text")); // NOI18N

        saveButton.setText(bundle.getString("UserEditDialog.saveButton.text")); // NOI18N
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText(bundle.getString("UserEditDialog.cancelButton.text")); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        isAppManager.setText(bundle.getString("UserEditDialog.isAppManager.text")); // NOI18N
        isAppManager.setToolTipText(bundle.getString("UserEditDialog.isAppManager.toolTipText")); // NOI18N

        isManager.setText(bundle.getString("UserEditDialog.isManager.text")); // NOI18N
        isManager.setToolTipText(bundle.getString("UserEditDialog.isManager.toolTipText")); // NOI18N

        delete.setText(bundle.getString("UserEditDialog.delete.text")); // NOI18N
        delete.setActionCommand(bundle.getString("UserEditDialog.delete.text")); // NOI18N
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

    /**
     * Fill the form with data from the DB
     */
    private void fillData() {
        nameField.setText(medewerker.getName());
        userNameField.setText(medewerker.getUsername());
        isAppManager.setSelected(medewerker.isAppManager());
        isManager.setSelected(medewerker.isManager());
    }
    /**
     * Save the data to the DB
     * @param evt 
     */
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        String footer = String.format(BUNDLE.getString("ConfirmFooter"), BUNDLE.getString("Medewerker")).toLowerCase();
        String message = BUNDLE.getString("ConfirmHead") + "\n"
                + BUNDLE.getString("UserEditDialog.usernameLabel.text") + " = " + medewerker.getUsername() + "\n"
                + BUNDLE.getString("UserEditDialog.nameLabel.text") + " = " + Check.cleanAlpha(nameField.getText()) + "\n"
                + BUNDLE.getString("UserEditDialog.isAppManager.text") + " = " + isAppManager.isSelected() + "\n"
                + BUNDLE.getString("UserEditDialog.isManager.text") + " = " + isManager.isSelected() + "\n\n"
                + footer;
        int selectedOption = JOptionPane.showConfirmDialog(null,
                message,
                BUNDLE.getString("Confirm"),
                JOptionPane.YES_NO_OPTION);
        UserDAO dbMedewerker;
        dbMedewerker = new UserDAO();
        if (selectedOption == JOptionPane.YES_OPTION) {
            medewerker.setName(Check.cleanAlpha(nameField.getText()));
            medewerker.setAppManager(isAppManager.isSelected());
            medewerker.setManager(isManager.isSelected());
            if (Arrays.equals(firstPasswordField.getPassword(), confirmPasswordField.getPassword()) && firstPasswordField.getPassword().length > 5) {
                medewerker.setPassword(firstPasswordField.getPassword());
            } else {
                JOptionPane.showMessageDialog(null,
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
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    /**
     * Exit the form
     * @param evt 
     */
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    
    /**
     * Delete the current user
     * @param evt 
     */
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed

        ConfirmPopup confirmPopup = new ConfirmPopup(userNameField.getText());
        confirmPopup.pack();
        confirmPopup.setVisible(true);
        confirmPopup.setLocationRelativeTo(null);

        medewerker.setUsername(userNameField.getText());

        dispose();

    }//GEN-LAST:event_deleteActionPerformed

    
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
