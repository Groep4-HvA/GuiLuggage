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
import models.Medewerker;
import models.MedewerkerDAO;

/**
 *
 * @author Groep 4 HvA IS104
 * @since 15-10-13
 */
public class MainGuiFrame extends java.awt.Frame {
    //Java resources

    private List<Medewerker> medList = null;
    private List<Case> caseList = null;
    private final java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Bundle"); // NOI18N
    //Strings for add buttons
    private final String button1;
    private final String button2;
    private String button3 = null;
    //Access Management
    private boolean beheer;
    private boolean inBeheer = false;
    private boolean luggage = false;
    private int handlerId;

    /**
     * Constructor for the common user and App Manager screen
     *
     * @param value
     * @throws java.sql.SQLException
     */
    public MainGuiFrame(boolean beheer, int handlerId) throws SQLException {
        //pre init configuration of Strings
        this.handlerId = handlerId;
        this.beheer = beheer;
        button1 = (inBeheer) ? bundle.getString("Medewerker") : bundle.getString("Luggage");
        button2 = (inBeheer) ? bundle.getString("Manager") : bundle.getString("Passenger");
        button3 = (luggage) ? bundle.getString("Luggage") : bundle.getString("Passenger");

        //initializing the screen and centering it
        initComponents();
        this.setLocationRelativeTo(null);
        searchInput.requestFocusInWindow();

        //Access management: users can not see the appmanagement screen
        appManagementButton.setVisible(beheer);

        //TODO: move DAO reference to Case object. list=case.readAll() rather the caseDao
        //getting all cases into a list object.
        CaseDao dbCase = new CaseDao();
        try {
            caseList = dbCase.readAll();
        } catch (SQLException ex) {
            Logger.getLogger(logIn.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Populate table and headers
        populateTableCase(caseList);
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
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(jPanel2Layout.createSequentialGroup()
                                        .add(addNewButton1)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(addNewButton2)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(moreButton))
                                    .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 928, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
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
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(appManagementButton)
                    .add(myAccountButton)
                    .add(logoutButton))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(LabelDescription)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(searchInput, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(searchButton)
                    .add(advanced))
                .add(18, 18, 18)
                .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(addNewButton1)
                    .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(moreButton)
                        .add(addNewButton2)))
                .addContainerGap(8, Short.MAX_VALUE))
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
    /*
     * Display advanced Search options
     */
    private void advancedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_advancedActionPerformed
        Advanced advancedPopUp = new Advanced();
        advancedPopUp.setVisible(true);
    }//GEN-LAST:event_advancedActionPerformed

    /*
     * Display more results
     * TODO: No function assigned yet
     */
    private void moreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moreButtonActionPerformed
    }//GEN-LAST:event_moreButtonActionPerformed

    /*
     * Switch to the Application Management screen.
     * TODO: Clean this up
     */
    private void appManagementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appManagementButtonActionPerformed
        if (beheer) {
            if (inBeheer) {
                addNewButton1.setText(bundle.getString("MainGuiFrame.addNew") + button1);
                addNewButton2.setText(bundle.getString("MainGuiFrame.addNew") + button2);
                appManagementButton.setText(bundle.getString("MainGuiFrame.beheerButtonOn"));
                LabelDescription.setText("Search:");
                //TODO: readAll should be from the Cases, not Dao
                CaseDao dbCase = new CaseDao();
                try {
                    caseList = dbCase.readAll();
                } catch (SQLException ex) {
                    Logger.getLogger(logIn.class.getName()).log(Level.SEVERE, null, ex);
                }
                populateTableCase(caseList);
                inBeheer = false;
            } else {
                addNewButton1.setText(bundle.getString("MainGuiFrame.addNew") + bundle.getString("Manager"));
                addNewButton2.setText(bundle.getString("MainGuiFrame.addNew") + bundle.getString("Medewerker"));
                appManagementButton.setText(bundle.getString("MainGuiFrame.beheerButtonOff"));
                LabelDescription.setText("Search:");

                //TODO: Move this to the Dao
                MedewerkerDAO dbMedewerker = new MedewerkerDAO();
                try {
                    medList = dbMedewerker.readAll();
                } catch (SQLException ex) {
                    Logger.getLogger(logIn.class.getName()).log(Level.SEVERE, null, ex);
                }
                populateTableMedewerker(medList);
                inBeheer = true;
            }
        } else {
            System.out.print(bundle.getString("notAuthorized"));
        }
    }//GEN-LAST:event_appManagementButtonActionPerformed

    /*
     * Open "My Account" allowing you to edit your password and language
     * TODO: Preset the language of the user
     */
    private void myAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myAccountButtonActionPerformed
       PasswordConfirm passOverlay = new PasswordConfirm(new javax.swing.JFrame(), true, handlerId);
        passOverlay.pack();
        passOverlay.setVisible(true);
        passOverlay.setLocationRelativeTo(null);
    }//GEN-LAST:event_myAccountButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        dispose();
        logIn logOut = new logIn();
        logOut.setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void tableResultsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableResultsMouseClicked
        if (inBeheer) {
            Popupappmedewerker popup1 = new Popupappmedewerker(medList.get(tableResults.getSelectedRow()));
            popup1.setVisible(true);
        } else {
            PopUpMedewerker popup = new PopUpMedewerker(caseList.get(tableResults.getSelectedRow()));
            popup.setVisible(true);
        }
    }//GEN-LAST:event_tableResultsMouseClicked

    private void addNewButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewButton1ActionPerformed
        if (inBeheer) {
            AddMedewerker gui = new AddMedewerker(true);
            gui.setVisible(true);
        } else {
            AddLuggage gui = new AddLuggage(handlerId);
            gui.setVisible(true);
        }
    }//GEN-LAST:event_addNewButton1ActionPerformed

    private void addNewButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewButton2ActionPerformed
        AddPassenger gui3 = new AddPassenger(handlerId);
        AddMedewerker gui2 = new AddMedewerker(false);
        if (inBeheer) {
            gui2.setVisible(true);
        } else {
            gui3.setVisible(true);
        }
    }//GEN-LAST:event_addNewButton2ActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        System.out.println(searchInput.getText());
        if (!inBeheer) {
            try {
                CaseDao cdCase = new CaseDao();
                caseList = cdCase.search(searchInput.getText());
                System.out.println(searchInput.getText());
                populateTableCase(caseList);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                MedewerkerDAO dbMedewerker = new MedewerkerDAO();
                medList = dbMedewerker.search(searchInput.getText());
                populateTableMedewerker(medList);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void searchInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchInputActionPerformed
        searchButtonActionPerformed(evt);
    }//GEN-LAST:event_searchInputActionPerformed
    public void populateTableMedewerker(List<Medewerker> list) {
        for (int i = 0; i < 50; i++) {
            tableResults.getModel().setValueAt("", i, 0);
            tableResults.getModel().setValueAt("", i, 1);
            tableResults.getModel().setValueAt("", i, 2);
            tableResults.getModel().setValueAt("", i, 3);
        }
        for (int j = 0; j < list.size(); j++) {
            tableResults.getModel().setValueAt(list.get(j).getName(), j, 0);
            tableResults.getModel().setValueAt(list.get(j).getUsername(), j, 1);
            tableResults.getModel().setValueAt(list.get(j).isAppManager(), j, 2);
            tableResults.getModel().setValueAt(list.get(j).isManager(), j, 3);
        }
        tableResults.getColumnModel().getColumn(0).setHeaderValue("Name");
        tableResults.getColumnModel().getColumn(1).setHeaderValue("Username");
        tableResults.getColumnModel().getColumn(2).setHeaderValue("Appmanager");
        tableResults.getColumnModel().getColumn(3).setHeaderValue("Manager");
    }

    public void populateTableCase(List<Case> list) {
        for (int i = 0; i < 50; i++) {
            tableResults.getModel().setValueAt("", i, 0);
            tableResults.getModel().setValueAt("", i, 1);
            tableResults.getModel().setValueAt("", i, 2);
            tableResults.getModel().setValueAt("", i, 3);
        }
        for (int i = 0; i < list.size(); i++) {
            tableResults.getModel().setValueAt(i+1, i, 0);
            tableResults.getModel().setValueAt(list.get(i).getLabel(), i, 1);
            tableResults.getModel().setValueAt(list.get(i).getAddDate(), i, 2);
            tableResults.getModel().setValueAt(list.get(i).getHandler(), i, 3);
        }
        tableResults.getColumnModel().getColumn(0).setHeaderValue("#");
        tableResults.getColumnModel().getColumn(1).setHeaderValue("Luggage Number");
        tableResults.getColumnModel().getColumn(2).setHeaderValue("Add date");
        tableResults.getColumnModel().getColumn(3).setHeaderValue("Handler name");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelDescription;
    private javax.swing.JButton addNewButton1;
    private javax.swing.JButton addNewButton2;
    private javax.swing.JButton advanced;
    private javax.swing.JButton appManagementButton;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton myAccountButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchInput;
    private javax.swing.JTable tableResults;
    // End of variables declaration//GEN-END:variables
}
