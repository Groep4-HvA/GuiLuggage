/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import popups.PasswordConfirm;
import popups.Popupappmedewerker;
import popups.AddLuggage;
import popups.Advanced;
import popups.AddMedewerker;
import popups.AddPassenger;
import popups.PopUpMedewerker;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Case;
import models.CaseDao;
import models.Luggage;
import models.LuggageDAO;
import models.Medewerker;
import models.MedewerkerDAO;
import models.Passenger;
import models.PassengerDAO;

/**
 *
 * @author sean
 */
public class MainGuiFrame extends java.awt.Frame {

    private final PasswordConfirm passOverlay = new PasswordConfirm(new javax.swing.JFrame(), true);
    private final java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Bundle"); // NOI18N
    /**
     * Creates new form MainGuiFrame
     */
    private int i = 0;
    private final String button1;
    private final String button2;
    private String button3 = null;
    private boolean inBeheer = false;
    private boolean beheer;
    private boolean luggage = false;

    /**
     *
     * @param value
     * @throws java.sql.SQLException
     */
    public MainGuiFrame(boolean value) throws SQLException {
        beheer = value;
        button1 = (inBeheer) ? bundle.getString("Medewerker") : bundle.getString("Luggage");
        button2 = (inBeheer) ? bundle.getString("Manager") : bundle.getString("Passenger");
        button3 = (luggage) ? bundle.getString("Luggage") : bundle.getString("Passenger");
        initComponents();
        this.setLocationRelativeTo(null);
        appManagementButton.setVisible(beheer);
        searchInput.requestFocusInWindow();
        CaseDao dbCase = new CaseDao();
        List<Case> list = null;
        try {
            list = dbCase.readAll();
        } catch (SQLException ex) {
            Logger.getLogger(logIn.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < list.size(); i++) {
            //System.out.println(list.get(i).toString());
            tableResults.getModel().setValueAt(""+i, i, 0);
            tableResults.getModel().setValueAt(list.get(i).getLabel(), i, 1);
            tableResults.getModel().setValueAt(list.get(i).getAddDate(), i, 2);
            //tableResults.getModel().set(list.get(i).getStatus(), i, 3);
            jLabel1.setText(bundle.getString("MainGuiFrame.Location") + bundle.getString("Passengers"));
        }

        tableResults.getColumnModel().getColumn(0).setHeaderValue("Label");
        tableResults.getColumnModel().getColumn(1).setHeaderValue("Name");
        tableResults.getColumnModel().getColumn(2).setHeaderValue("Surname");
        tableResults.getColumnModel().getColumn(3).setHeaderValue("Details");

        jLabel1.setText(bundle.getString("MainGuiFrame.Location") + bundle.getString("Luggage"));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        advanced = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        addNewButton1 = new javax.swing.JButton();
        addNewButton2 = new javax.swing.JButton();
        javax.swing.JButton moreButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableResults = new javax.swing.JTable();
        appManagementButton = new javax.swing.JButton();
        myAccountButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        LabelDescription = new javax.swing.JLabel();
        searchInput = new javax.swing.JTextField();
        tableChange = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Bundle"); // NOI18N
        setTitle(bundle.getString("medewerkerMain.title")); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        advanced.setText(bundle.getString("MainGuiFrame.advanced.text")); // NOI18N
        advanced.setToolTipText(bundle.getString("MainGuiFrame.advanced.toolTipText")); // NOI18N
        advanced.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                advancedActionPerformed(evt);
            }
        });

        searchButton.setText(bundle.getString("MainGuiFrame.searchButton.text")); // NOI18N
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        addNewButton1.setText("Add new: " + button1);
        addNewButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewButton1ActionPerformed(evt);
            }
        });

        addNewButton2.setText("Add new: "+ button2);
        addNewButton2.setToolTipText(bundle.getString("MainGuiFrame.addNewButton2.toolTipText")); // NOI18N
        addNewButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewButton2ActionPerformed(evt);
            }
        });

        moreButton.setText(bundle.getString("MainGuiFrame.moreButton.text")); // NOI18N
        moreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moreButtonActionPerformed(evt);
            }
        });

        tableResults.setAutoCreateRowSorter(true);
        tableResults.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableResults.setShowVerticalLines(false);
        tableResults.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableResultsMouseClicked(evt);
            }
        });
        tableResults.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableResultsKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(tableResults);

        appManagementButton.setText(bundle.getString("MainGuiFrame.appManagementButton.text")); // NOI18N
        appManagementButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appManagementButtonActionPerformed(evt);
            }
        });

        myAccountButton.setText(bundle.getString("MainGuiFrame.myAccountButton.text")); // NOI18N
        myAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myAccountButtonActionPerformed(evt);
            }
        });

        logoutButton.setText(bundle.getString("MainGuiFrame.logoutButton.text")); // NOI18N
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        LabelDescription.setText(bundle.getString("MainGuiFrame.LabelDescription.text")); // NOI18N
        LabelDescription.setToolTipText(bundle.getString("MainGuiFrame.LabelDescription.toolTipText")); // NOI18N

        searchInput.setText(bundle.getString("MainGuiFrame.searchInput.text")); // NOI18N
        searchInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchInputActionPerformed(evt);
            }
        });

        tableChange.setText(bundle.getString("MainGuiFrame.tableChange.text")); // NOI18N
        tableChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tableChangeActionPerformed(evt);
            }
        });

        java.util.ResourceBundle bundle1 = java.util.ResourceBundle.getBundle("Bundle"); // NOI18N
        jLabel1.setText(bundle1.getString("MainGuiFrame.jLabel1.text")); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                        .add(appManagementButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(myAccountButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(logoutButton)
                        .addContainerGap())
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(LabelDescription)
                            .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                .add(searchInput, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 931, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel1)
                                    .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                        .add(jPanel2Layout.createSequentialGroup()
                                            .add(addNewButton1)
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                            .add(addNewButton2)
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .add(tableChange)
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                            .add(moreButton))
                                        .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 928, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(49, Short.MAX_VALUE))))
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(advanced)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(searchButton)
                .add(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(appManagementButton)
                    .add(myAccountButton)
                    .add(logoutButton))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(LabelDescription)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(searchInput, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(searchButton)
                    .add(advanced))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 37, Short.MAX_VALUE)
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(addNewButton1)
                    .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(moreButton)
                        .add(addNewButton2)
                        .add(tableChange)))
                .add(8, 8, 8))
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

    private void advancedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_advancedActionPerformed
        Advanced advancedPopUp = new Advanced();
        advancedPopUp.setVisible(true);
    }//GEN-LAST:event_advancedActionPerformed

    private void moreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moreButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_moreButtonActionPerformed

    private void appManagementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appManagementButtonActionPerformed
        if (beheer) {
            for (int x = 0; x < 50; x++) {
                tableResults.getModel().setValueAt("", x, 0);
                tableResults.getModel().setValueAt("", x, 1);
                tableResults.getModel().setValueAt("", x, 2);
                tableResults.getModel().setValueAt("", x, 3);
            }
            if (inBeheer) {
                tableChange.setVisible(true);
                addNewButton1.setText(bundle.getString("MainGuiFrame.addNew") + button1);
                addNewButton2.setText(bundle.getString("MainGuiFrame.addNew") + button2);
                appManagementButton.setText(bundle.getString("MainGuiFrame.beheerButtonOn"));
                LabelDescription.setText("Search:");
                PassengerDAO dbPassenger = new PassengerDAO();
                List<Passenger> list = null;
                try {
                    list = dbPassenger.readAll();
                } catch (SQLException ex) {
                    Logger.getLogger(logIn.class.getName()).log(Level.SEVERE, null, ex);
                }

                for (int i = 0; i < 50; i++) {
                    tableResults.getModel().setValueAt("", i, 0);
                    tableResults.getModel().setValueAt("", i, 1);
                    tableResults.getModel().setValueAt("", i, 2);
                    tableResults.getModel().setValueAt("", i, 3);
                }
                tableResults.getColumnModel().getColumn(0).setHeaderValue("Label");
                tableResults.getColumnModel().getColumn(1).setHeaderValue("Name");
                tableResults.getColumnModel().getColumn(2).setHeaderValue("Surname");
                tableResults.getColumnModel().getColumn(3).setHeaderValue("Details");
                for (int i = 0; i < list.size(); i++) {
                    //System.out.println(list.get(i).toString());
                    tableResults.getModel().setValueAt(list.get(i).getLabel(), i, 0);
                    tableResults.getModel().setValueAt(list.get(i).getName(), i, 1);
                    tableResults.getModel().setValueAt(list.get(i).getSurname(), i, 2);
                    tableResults.getModel().setValueAt(list.get(i).getDetails(), i, 3);
                    jLabel1.setText(bundle.getString("MainGuiFrame.Location") + bundle.getString("Passengers"));
                }
                inBeheer = false;
            } else {
                tableChange.setVisible(false);
                addNewButton1.setText(bundle.getString("MainGuiFrame.addNew") + bundle.getString("Manager"));
                addNewButton2.setText(bundle.getString("MainGuiFrame.addNew") + bundle.getString("Medewerker"));
                appManagementButton.setText(bundle.getString("MainGuiFrame.beheerButtonOff"));
                LabelDescription.setText("Search:");

                MedewerkerDAO dbMedewerker = new MedewerkerDAO();
                List<Medewerker> list = null;
                try {
                    list = dbMedewerker.readAll();
                } catch (SQLException ex) {
                    Logger.getLogger(logIn.class.getName()).log(Level.SEVERE, null, ex);
                }

                for (int i = 0; i < 50; i++) {
                    tableResults.getModel().setValueAt("", i, 0);
                    tableResults.getModel().setValueAt("", i, 1);
                    tableResults.getModel().setValueAt("", i, 2);
                    tableResults.getModel().setValueAt("", i, 3);
                }
                tableResults.getColumnModel().getColumn(0).setHeaderValue("Name");
                tableResults.getColumnModel().getColumn(1).setHeaderValue("Username");
                tableResults.getColumnModel().getColumn(2).setHeaderValue("Appmanager");
                tableResults.getColumnModel().getColumn(3).setHeaderValue("Manager");
                for (int i = 0; i < list.size(); i++) {
                    //System.out.println(list.get(i).toString());
                    tableResults.getModel().setValueAt(list.get(i).getName(), i, 0);
                    tableResults.getModel().setValueAt(list.get(i).getUsername(), i, 1);
                    tableResults.getModel().setValueAt(list.get(i).isAppManager(), i, 2);
                    tableResults.getModel().setValueAt(list.get(i).isManager(), i, 3);
                }
                jLabel1.setText(bundle.getString("MainGuiFrame.Location") + bundle.getString("Users"));
                inBeheer = true;
            }
        } else {
            System.out.print(bundle.getString("notAuthorized"));
        }
    }//GEN-LAST:event_appManagementButtonActionPerformed

    private void myAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myAccountButtonActionPerformed
        passOverlay.pack();
        passOverlay.setVisible(true);
        passOverlay.setLocationRelativeTo(null);
    }//GEN-LAST:event_myAccountButtonActionPerformed

    private void tableResultsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableResultsKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tableResultsKeyPressed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        dispose();
        logIn logOut = new logIn();
        logOut.setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void tableResultsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableResultsMouseClicked
        int i = 0;
        if (inBeheer) {
            Popupappmedewerker popup1 = new Popupappmedewerker();
            popup1.setVisible(true);
        } else {
            PopUpMedewerker popup = new PopUpMedewerker();
            popup.setVisible(true);
        }
    }//GEN-LAST:event_tableResultsMouseClicked

    private void addNewButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewButton1ActionPerformed
        if (inBeheer) {
            AddMedewerker gui = new AddMedewerker(true);
            gui.setVisible(true);
        } else {
            AddLuggage gui = new AddLuggage();
            gui.setVisible(true);
        }
    }//GEN-LAST:event_addNewButton1ActionPerformed

    private void addNewButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewButton2ActionPerformed
        AddPassenger gui3 = new AddPassenger();
        AddMedewerker gui2 = new AddMedewerker(false);
        if (inBeheer) {
            gui2.setVisible(true);
        } else {
            gui3.setVisible(true);
        }
    }//GEN-LAST:event_addNewButton2ActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        System.out.println();
        System.out.println(searchInput.getText());
        System.out.println();

        if (!inBeheer) {

            try {

                PassengerDAO dbPassenger = new PassengerDAO();
                List<Passenger> list;
                list = dbPassenger.search(searchInput.getText());

                System.out.println();
                System.out.println(searchInput.getText());
                System.out.println();

                for (int i = 0; i < 50; i++) {
                    tableResults.getModel().setValueAt("", i, 0);
                    tableResults.getModel().setValueAt("", i, 1);
                    tableResults.getModel().setValueAt("", i, 2);
                    tableResults.getModel().setValueAt("", i, 3);
                }
                tableResults.getColumnModel().getColumn(0).setHeaderValue("Label");
                tableResults.getColumnModel().getColumn(1).setHeaderValue("Name");
                tableResults.getColumnModel().getColumn(2).setHeaderValue("Surname");
                tableResults.getColumnModel().getColumn(3).setHeaderValue("Details");

                int x = 0;
                while (x < list.size()) {
                    System.out.println(list.get(x).toString());
                    tableResults.getModel().setValueAt(list.get(x).getLabel(), x, 0);
                    tableResults.getModel().setValueAt(list.get(x).getName(), x, 1);
                    tableResults.getModel().setValueAt(list.get(x).getSurname(), x, 2);
                    tableResults.getModel().setValueAt(list.get(x).getDetails(), x, 3);
                    x++;
                }
                jLabel1.setText(bundle.getString("MainGuiFrame.Location") + bundle.getString("Passengers"));

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                MedewerkerDAO dbMedewerker = new MedewerkerDAO();
                List<Medewerker> list = null;
                list = dbMedewerker.search(searchInput.getText());

                for (int i = 0; i < 50; i++) {
                    tableResults.getModel().setValueAt("", i, 0);
                    tableResults.getModel().setValueAt("", i, 1);
                    tableResults.getModel().setValueAt("", i, 2);
                    tableResults.getModel().setValueAt("", i, 3);
                }
                tableResults.getColumnModel().getColumn(0).setHeaderValue("Name");
                tableResults.getColumnModel().getColumn(1).setHeaderValue("Username");
                tableResults.getColumnModel().getColumn(2).setHeaderValue("Appmanager");
                tableResults.getColumnModel().getColumn(3).setHeaderValue("Manager");
                for (int i = 0; i < list.size(); i++) {
                    //System.out.println(list.get(i).toString());
                    tableResults.getModel().setValueAt(list.get(i).getName(), i, 0);
                    tableResults.getModel().setValueAt(list.get(i).getUsername(), i, 1);
                    tableResults.getModel().setValueAt(list.get(i).isAppManager(), i, 2);
                    tableResults.getModel().setValueAt(list.get(i).isManager(), i, 3);

                    jLabel1.setText(bundle.getString("MainGuiFrame.Location") + bundle.getString("Users"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void searchInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchInputActionPerformed

    private void tableChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tableChangeActionPerformed
        try {
            for (int x = 0; x < 50; x++) {
                tableResults.getModel().setValueAt("", x, 0);
                tableResults.getModel().setValueAt("", x, 1);
                tableResults.getModel().setValueAt("", x, 2);
                tableResults.getModel().setValueAt("", x, 3);
            }
            if (!luggage) {
                luggage = true;
                PassengerDAO dbPassenger = new PassengerDAO();
                List<Passenger> list;
                list = dbPassenger.readAll();

                int x = 0;
                while (x < list.size()) {
                    //System.out.println(list.get(x).toString());
                    tableResults.getModel().setValueAt(list.get(x).getLabel(), x, 0);
                    tableResults.getModel().setValueAt(list.get(x).getName(), x, 1);
                    tableResults.getModel().setValueAt(list.get(x).getSurname(), x, 2);
                    tableResults.getModel().setValueAt(list.get(x).getDetails(), x, 3);
                    x++;
                }

                tableResults.getColumnModel().getColumn(0).setHeaderValue("Label");
                tableResults.getColumnModel().getColumn(1).setHeaderValue("Name");
                tableResults.getColumnModel().getColumn(2).setHeaderValue("Surname");
                tableResults.getColumnModel().getColumn(3).setHeaderValue("Details");

                jLabel1.setText(bundle.getString("MainGuiFrame.Location") + bundle.getString("Passengers"));

            } else {
                luggage = false;
                LuggageDAO dbLuggage = new LuggageDAO();
                List<Luggage> list = null;
                try {
                    list = dbLuggage.readAll();
                } catch (SQLException ex) {
                    Logger.getLogger(logIn.class.getName()).log(Level.SEVERE, null, ex);
                }
                for (int i = 0; i < list.size(); i++) {
                    //System.out.println(list.get(i).toString());
                    tableResults.getModel().setValueAt(list.get(i).getLabel(), i, 0);
                    tableResults.getModel().setValueAt(list.get(i).getLocation(), i, 1);
                    tableResults.getModel().setValueAt(list.get(i).getColor(), i, 2);
                    tableResults.getModel().setValueAt(list.get(i).getShape(), i, 3);
                }
                tableResults.getColumnModel().getColumn(0).setHeaderValue("Label");
                tableResults.getColumnModel().getColumn(1).setHeaderValue("Location");
                tableResults.getColumnModel().getColumn(2).setHeaderValue("Color");
                tableResults.getColumnModel().getColumn(3).setHeaderValue("Shape");

                jLabel1.setText(bundle.getString("MainGuiFrame.Location") + bundle.getString("Luggage"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tableChangeActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelDescription;
    private javax.swing.JButton addNewButton1;
    private javax.swing.JButton addNewButton2;
    private javax.swing.JButton advanced;
    private javax.swing.JButton appManagementButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton myAccountButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchInput;
    private javax.swing.JButton tableChange;
    private javax.swing.JTable tableResults;
    // End of variables declaration//GEN-END:variables
}
