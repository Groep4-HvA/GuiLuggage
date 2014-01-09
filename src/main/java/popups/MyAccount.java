/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package popups;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import models.Check;
import models.Debug;
import models.Medewerker;
import models.MedewerkerDAO;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author workplz
 */
public class MyAccount extends javax.swing.JDialog {

    private final Color red = new Color(163, 0, 15);
    private Medewerker tempMedewerker = null;
    private final MedewerkerDAO medewerkerTijdelijk = new MedewerkerDAO();
    private int medewerkerID;
    private final int lang;

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
            this.medewerkerID = medewerkerID;
        }
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        passwordConfirm = new javax.swing.JPasswordField();
        dropDown = new javax.swing.JComboBox();
        saveBut = new javax.swing.JButton();
        cancelBut = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        passwordOld = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Bundle"); // NOI18N
        jLabel1.setText(bundle.getString("MyAcc.langLabel")); // NOI18N

        jLabel2.setText(bundle.getString("MyAcc.passLabel")); // NOI18N

        jLabel3.setText(bundle.getString("MyAcc.confPassLabel")); // NOI18N

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

        jLabel4.setText(bundle.getString("MyAcc.oldPassLabel")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saveBut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelBut))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(passwordConfirm)
                            .addComponent(password)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dropDown, 0, 225, Short.MAX_VALUE)
                            .addComponent(passwordOld))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(dropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(passwordOld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(passwordConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBut)
                    .addComponent(cancelBut))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButActionPerformed
        close();
    }//GEN-LAST:event_cancelButActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        saveButActionPerformed(evt);
    }//GEN-LAST:event_passwordActionPerformed

    private void saveButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButActionPerformed
        Locale english, dutch, current;

        english = new Locale("en", "US");
        dutch = new Locale("nl", "NL");
        Locale.setDefault(english);
        boolean change = false;

        if (dropDown.getSelectedIndex() != lang) {
            if (dropDown.getSelectedIndex() == 0) {
                Locale.setDefault(english);
                tempMedewerker.setUserLang("EN");
            }
            if (dropDown.getSelectedIndex() == 1) {
                Locale.setDefault(dutch);
                tempMedewerker.setUserLang("NL");
            }
            change = true;
        }
        Debug.println(change + "");
        if (password.getPassword().length > 0) {
            Debug.println(password.getPassword().toString());
            try {
                tempMedewerker = medewerkerTijdelijk.readByID(medewerkerID);
            } catch (SQLException e) {
                Debug.printError(e.toString());
            }
            if (tempMedewerker.getPassword().equals(DigestUtils.sha256Hex(String.valueOf(passwordOld.getPassword())))) {

                if (Arrays.equals(password.getPassword(), passwordConfirm.getPassword())) {
                    try {
                        tempMedewerker = medewerkerTijdelijk.readByID(medewerkerID);
                        if (!tempMedewerker.getPassword().equals(DigestUtils.sha256Hex(String.valueOf(password.getPassword())))) {
                            tempMedewerker.setPassword(password.getPassword());
                            change = true;
                        } else {
                            dispose();
                        }
                        Debug.println(tempMedewerker.toString());

                    } catch (SQLException e) {
                        Debug.printError(e.toString());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Passwords do not match");
                }


                Debug.println(change + "");
                if (change) {
                    Debug.println(tempMedewerker.toString());
                    try {
                        medewerkerTijdelijk.update(tempMedewerker);
                    } catch (SQLException e) {
                        Debug.printError(e.toString());
                    }
                }
            }
        }
        dispose();
    }//GEN-LAST:event_saveButActionPerformed

    private void dropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropDownActionPerformed
    }//GEN-LAST:event_dropDownActionPerformed

    public void close() {
        WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
        dispose();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton cancelBut;
    public javax.swing.JComboBox dropDown;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JPasswordField password;
    public javax.swing.JPasswordField passwordConfirm;
    public javax.swing.JPasswordField passwordOld;
    public javax.swing.JButton saveBut;
    // End of variables declaration//GEN-END:variables
}
