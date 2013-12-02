/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.List;
import models.Passenger;
import models.PassengerDAO;
import models.printJob;
import popups.PasswordConfirm;

/**
 *
 * @author sean
 */
public class ManagerGui extends java.awt.Frame {

    private PasswordConfirm passOverlay = new PasswordConfirm(new javax.swing.JFrame(), true);
    /**
     * Creates new form MainGuiFrame
     */
    private boolean beheer;

    public ManagerGui(boolean beheer) throws SQLException {
        beheer = this.beheer;
        initComponents();
        
        
        
        PassengerDAO dbPassenger = new PassengerDAO();
        List<Passenger> list;
        list = dbPassenger.readAll();
        
        
        int x = 0;
        while (x < list.size()) {
          //  System.out.println(list.get(x).toString());
            jTable1.getModel().setValueAt(list.get(x).getLabel(), x, 0);
            jTable1.getModel().setValueAt(list.get(x).getName(), x, 1);
            jTable1.getModel().setValueAt(list.get(x).getColor(), x, 2);
            jTable1.getModel().setValueAt(list.get(x).getShape(), x, 3);
            x++;
        }
       
        jTable1.getColumnModel().getColumn(0).setHeaderValue("Label");
        jTable1.getColumnModel().getColumn(1).setHeaderValue("Name");
        jTable1.getColumnModel().getColumn(2).setHeaderValue("Color");
        jTable1.getColumnModel().getColumn(3).setHeaderValue("Shape");
        
    }
    

    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        myAccountButton = new javax.swing.JButton();
        javax.swing.JButton moreButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        missingManager = new javax.swing.JButton();
        foundManager = new javax.swing.JButton();
        processedManager = new javax.swing.JButton();
        graphManager = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        printButton = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Bundle"); // NOI18N
        myAccountButton.setText(bundle.getString("Manager.myAccountButton.text")); // NOI18N
        myAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myAccountButtonActionPerformed(evt);
            }
        });

        moreButton.setText(bundle.getString("Manager.moreButton.text")); // NOI18N
        moreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moreButtonActionPerformed(evt);
            }
        });

        logoutButton.setText(bundle.getString("Manager.logoutButton.text")); // NOI18N
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        missingManager.setText(bundle.getString("Manager.missingManager.text")); // NOI18N
        missingManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                missingManagerActionPerformed(evt);
            }
        });

        foundManager.setText(bundle.getString("Manager.foundManager.text")); // NOI18N

        processedManager.setText(bundle.getString("Manager.processedManager.text")); // NOI18N
        processedManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processedManagerActionPerformed(evt);
            }
        });

        graphManager.setText(bundle.getString("Manager.graphManager.text")); // NOI18N
        graphManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphManagerActionPerformed(evt);
            }
        });

        jLabel1.setText(bundle.getString("Manager.jLabel1.text")); // NOI18N
        jLabel1.setText("Found: 1");

        jLabel2.setText(bundle.getString("Manager.jLabel2.text")); // NOI18N
        jLabel2.setText("Missing: 2");

        jLabel3.setText(bundle.getString("Manager.jLabel3.text")); // NOI18N
        jLabel3.setText("Total: 3");

        printButton.setText(bundle.getString("Manager.printButton.text")); // NOI18N
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        jTextField1.setText(bundle.getString("Manager.jTextField1.text")); // NOI18N

        jLabel4.setText(bundle.getString("Manager.jLabel4.text")); // NOI18N

        jTextField2.setText(bundle.getString("Manager.jTextField2.text")); // NOI18N

        jButton2.setText(bundle.getString("Manager.jButton2.text")); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        java.util.ResourceBundle bundle1 = java.util.ResourceBundle.getBundle("main/Bundle"); // NOI18N
        jTable1.getColumnModel().getColumn(0).setHeaderValue(bundle1.getString("ManagerGui.jTable1.columnModel.title0")); // NOI18N
        jTable1.getColumnModel().getColumn(1).setHeaderValue(bundle1.getString("ManagerGui.jTable1.columnModel.title1")); // NOI18N
        jTable1.getColumnModel().getColumn(2).setHeaderValue(bundle1.getString("ManagerGui.jTable1.columnModel.title2")); // NOI18N
        jTable1.getColumnModel().getColumn(3).setHeaderValue(bundle1.getString("ManagerGui.jTable1.columnModel.title3")); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 1000, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(myAccountButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(logoutButton)
                .addContainerGap())
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(printButton)
                        .add(215, 215, 215)
                        .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jLabel4)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jButton2)
                        .add(309, 309, 309)
                        .add(moreButton))
                    .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(jPanel2Layout.createSequentialGroup()
                            .add(missingManager)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                            .add(foundManager)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                            .add(processedManager)
                            .add(70, 70, 70)
                            .add(jLabel1)
                            .add(18, 18, 18)
                            .add(jLabel2)
                            .add(18, 18, 18)
                            .add(jLabel3)
                            .add(377, 377, 377)
                            .add(graphManager))))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(myAccountButton)
                    .add(logoutButton))
                .add(18, 25, Short.MAX_VALUE)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(missingManager)
                    .add(processedManager)
                    .add(graphManager)
                    .add(jLabel1)
                    .add(jLabel2)
                    .add(jLabel3)
                    .add(foundManager))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(moreButton)
                    .add(printButton)
                    .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel4)
                    .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton2))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void moreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moreButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_moreButtonActionPerformed

    private void myAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myAccountButtonActionPerformed
        passOverlay.pack();
        passOverlay.setVisible(true);
        passOverlay.setLocationRelativeTo(null);
    }//GEN-LAST:event_myAccountButtonActionPerformed

    private void missingManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_missingManagerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_missingManagerActionPerformed

    private void processedManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processedManagerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_processedManagerActionPerformed

    private void graphManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphManagerActionPerformed
        //jPanel1.setVisible(false);
        ManagerGraph graph = new ManagerGraph("Manager graph", true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        graph.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        graph.setLocationRelativeTo(null);
        graph.setSize(600, 400);
        graph.setVisible(true);
    }//GEN-LAST:event_graphManagerActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        printJob printJob = new printJob();
    }//GEN-LAST:event_printButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        dispose();
        logIn logOut = new logIn();
        logOut.setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton foundManager;
    private javax.swing.JButton graphManager;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton missingManager;
    private javax.swing.JButton myAccountButton;
    private javax.swing.JButton printButton;
    private javax.swing.JButton processedManager;
    // End of variables declaration//GEN-END:variables
}
