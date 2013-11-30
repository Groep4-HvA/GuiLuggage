/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package popups;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Luggage;
import models.LuggageDAO;

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
    
    /**
     * Creates new form guiPopupDesign
     */
    public AddLuggage() {
        initComponents();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Bundle"); // NOI18N
        setTitle(bundle.getString("AddLuggage.title")); // NOI18N

        java.util.ResourceBundle bundle1 = java.util.ResourceBundle.getBundle("Bundle"); // NOI18N
        labelLabel.setText(bundle1.getString("AddLuggage.labelLabel.text")); // NOI18N

        colorLabel.setText(bundle1.getString("AddLuggage.colorLabel.text")); // NOI18N

        shapeLabel.setText(bundle1.getString("AddLuggage.shapeLabel.text")); // NOI18N

        storageLocationLabel.setText(bundle1.getString("AddLuggage.storageLocationLabel.text")); // NOI18N

        adDetailsLabel.setText(bundle1.getString("AddLuggage.adDetailsLabel.text")); // NOI18N

        Save.setText(bundle1.getString("AddLuggage.Save.text")); // NOI18N
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        cancel.setText(bundle1.getString("AddLuggage.cancel.text")); // NOI18N
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelLabel)
                    .addComponent(colorLabel)
                    .addComponent(shapeLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(adDetailsLabel)
                            .addComponent(storageLocationLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Save)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 409, Short.MAX_VALUE)
                                .addComponent(cancel))
                            .addComponent(labelTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(colorTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(shapeTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2))
                        .addGap(3, 3, 3))))
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(storageLocationLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adDetailsLabel)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancel)
                    .addComponent(Save))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public static AddLuggage form = new AddLuggage();
    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        Luggage newLuggage;
        label = labelTextField.getText();
        color = colorTextField.getText();
        shape = shapeTextField.getText();
        location = locationTextField.getText();
        details = detailsTextField.getText();
        
        
        newLuggage = new Luggage(label, color, shape, location, details);
        LuggageDAO test = new LuggageDAO();
        
        try {
            test.create(newLuggage);
        } catch (SQLException ex) {
            Logger.getLogger(AddLuggage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        dispose();
    }//GEN-LAST:event_SaveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(AddLuggage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                form.setVisible(true);
            }
        });
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
    public javax.swing.JLabel shapeLabel;
    public javax.swing.JTextField shapeTextField;
    public javax.swing.JLabel storageLocationLabel;
    // End of variables declaration//GEN-END:variables
}
