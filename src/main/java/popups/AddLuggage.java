/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package popups;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import models.Case;
import models.Check;
import models.Debug;
import models.Luggage;
import models.LuggageDAO;
import models.User;
import models.UserDAO;

/**
 *
 * @author workplz
 */
public class AddLuggage extends javax.swing.JFrame {

    private String label;
    private String color;
    private String shape;
    private String location;
    private String details;
    private int handlerId;
    private String phoneNr;
    private final java.util.ResourceBundle BUNDLE = java.util.ResourceBundle.getBundle("Bundle");

    /**
     * Creates new form guiPopupDesign
     *
     * @param handlerId
     */
    public AddLuggage(int handlerId) {
        if (!Check.verifyLogin()) {
            Runtime.getRuntime().exit(1);
        } else {
            this.handlerId = handlerId;
            initComponents();
            this.setLocationRelativeTo(null);
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

        labelLabel = new javax.swing.JLabel();
        colorLabel = new javax.swing.JLabel();
        shapeLabel = new javax.swing.JLabel();
        storageLocationLabel = new javax.swing.JLabel();
        adDetailsLabel = new javax.swing.JLabel();
        Save = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        labelTextField = new javax.swing.JTextField();
        colorTextField = new javax.swing.JTextField();
        shapeTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        locationTextField = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        detailsTextField = new javax.swing.JTextArea();
        phoneNrLabel = new javax.swing.JLabel();
        phoneNrText = new javax.swing.JTextField();
        requiredFields = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Bundle"); // NOI18N
        setTitle(bundle.getString("AddLuggage.title")); // NOI18N
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });

        labelLabel.setText(bundle.getString("AddLuggage.labelLabel.text")); // NOI18N

        colorLabel.setText(bundle.getString("AddLuggage.colorLabel.text")); // NOI18N

        shapeLabel.setText(bundle.getString("AddLuggage.shapeLabel.text")); // NOI18N

        storageLocationLabel.setText(bundle.getString("AddLuggage.storageLocationLabel.text")); // NOI18N

        adDetailsLabel.setText(bundle.getString("AddLuggage.adDetailsLabel.text")); // NOI18N

        Save.setText(bundle.getString("AddLuggage.Save.text")); // NOI18N
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        cancel.setText(bundle.getString("AddLuggage.cancel.text")); // NOI18N
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        locationTextField.setColumns(20);
        locationTextField.setRows(5);
        jScrollPane1.setViewportView(locationTextField);

        detailsTextField.setColumns(20);
        detailsTextField.setRows(5);
        jScrollPane2.setViewportView(detailsTextField);

        phoneNrLabel.setText(bundle.getString("AddLuggage.phoneNrLabel.text")); // NOI18N

        phoneNrText.setText(bundle.getString("AddLuggage.phoneNrText.text")); // NOI18N

        java.util.ResourceBundle bundle1 = java.util.ResourceBundle.getBundle("popups/Bundle"); // NOI18N
        requiredFields.setText(bundle1.getString("AddLuggage.requiredFields.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phoneNrLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(storageLocationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(colorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(shapeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(adDetailsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(requiredFields)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Save)
                                .addGap(124, 124, 124)
                                .addComponent(cancel))
                            .addComponent(labelTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(colorTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(shapeTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addGap(3, 3, 3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(phoneNrText)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLabel)
                    .addComponent(labelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(colorLabel)
                    .addComponent(colorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shapeLabel)
                    .addComponent(shapeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneNrLabel)
                    .addComponent(phoneNrText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(storageLocationLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adDetailsLabel)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cancel)
                        .addComponent(Save))
                    .addComponent(requiredFields))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        Luggage newLuggage;
        label = Check.cleanAlphaNumeriek(labelTextField.getText());
        color = colorTextField.getText();
        shape = shapeTextField.getText();
        location = locationTextField.getText();
        details = detailsTextField.getText();
        phoneNr = phoneNrText.getText();
        String footer = String.format(BUNDLE.getString("ConfirmFooter"), BUNDLE.getString("Luggage")).toLowerCase();
        String message = BUNDLE.getString("ConfirmHead") + "\n"
                + BUNDLE.getString("AddLuggage.labelLabel.text") + " = " + label + "\n"
                + BUNDLE.getString("AddLuggage.colorLabel.text") + " = " + color + "\n"
                + BUNDLE.getString("AddLuggage.shapeLabel.text") + " = " + shape + "\n"
                + BUNDLE.getString("AddLuggage.phoneNrLabel.text") + " = " + location + "\n"
                + BUNDLE.getString("AddLuggage.storageLocationLabel.text") + " = " + details + "\n"
                + BUNDLE.getString("AddLuggage.adDetailsLabel.text") + " = " + phoneNr + "\n\n"
                + footer;
        int selectedOption = JOptionPane.showConfirmDialog(null,
                message,
                BUNDLE.getString("Confirm"),
                JOptionPane.YES_NO_OPTION);
        if (Check.verifyLuggage(label, color, shape, location, details, phoneNr)&&selectedOption == JOptionPane.YES_OPTION) {
            Debug.println(Check.cleanPhone(phoneNr));
            newLuggage = new Luggage(label, color, shape, location, details, phoneNr);
            saveData(newLuggage);

        } else {
            JOptionPane.showMessageDialog(null,
                    "Your input was invalid. The label, storage location and phone number can not be empty",
                    "Input error - empty",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_SaveActionPerformed

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        this.dispose();
    }//GEN-LAST:event_formWindowLostFocus
    private void saveData(Luggage item) {
        LuggageDAO test = new LuggageDAO();
        try {
            test.create(item, handlerId);
        } catch (SQLException e) {
            Debug.printError(e.toString());
            Debug.printError(e.getSQLState());
        }
        dispose();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Save;
    public javax.swing.JLabel adDetailsLabel;
    public javax.swing.JButton cancel;
    public javax.swing.JLabel colorLabel;
    public javax.swing.JTextField colorTextField;
    public javax.swing.JTextArea detailsTextField;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel labelLabel;
    public javax.swing.JTextField labelTextField;
    public javax.swing.JTextArea locationTextField;
    public javax.swing.JLabel phoneNrLabel;
    public javax.swing.JTextField phoneNrText;
    public javax.swing.JLabel requiredFields;
    public javax.swing.JLabel shapeLabel;
    public javax.swing.JTextField shapeTextField;
    public javax.swing.JLabel storageLocationLabel;
    // End of variables declaration//GEN-END:variables
}
