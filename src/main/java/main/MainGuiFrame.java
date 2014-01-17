/**
 *
 */
package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.*;

import models.*;
import popups.*;

/**
 *
 * @author Groep 4 HvA IS104
 * @since 15-10-13
 */
public class MainGuiFrame extends java.awt.Frame {

    //Java resources
    private List<User> medList = null;
    private List<Case> caseList = null;
    private List<Integer> messageRows = new ArrayList();

    private final java.util.ResourceBundle BUNDLE = java.util.ResourceBundle.getBundle("Bundle"); // NOI18N

    //Strings for add buttons
    private String button1 = null;
    private String button2 = null;

    //Access Management
    private boolean beheer;
    private int handlerId;
    private boolean inBeheer = false;
    boolean notify = false; //set to true to enable annoying as hell notifications

    private final Cursor waiting = new Cursor(Cursor.WAIT_CURSOR);
    private final Cursor defaultCursor = new Cursor(Cursor.DEFAULT_CURSOR);

    private static Image bg;
    private final Color appManagerColor = new Color(0xFF20A545, true);
    private final Color managerColor = new Color(0xFFF09517, true);
    private final Color userColor = new Color(0xFF2584C1, true);
    private final Color resolvedColor = new Color(0xFF20A545, true);
    private final Color passengerColor = new Color(0xFFF09517, true);
    private final Color luggageColor = new Color(0xFF2584C1, true);
    private final Color offWhite = new Color(237, 237, 237);

    /**
     * Constructor for the common user and App Manager screen
     *
     * @param beheer is the user an app manager?
     * @param handlerId the ID of the user
     */
    public MainGuiFrame(boolean beheer, int handlerId) {
        if (!Check.verifyLogin()) {
            Runtime.getRuntime().exit(1);
        } else {
            setCursor(waiting);
            menuBeheer();
            //pre init configuration of Strings
            Debug.println("Configuring variables");
            this.handlerId = handlerId;
            this.beheer = beheer;
            button1 = (inBeheer) ? BUNDLE.getString("Medewerker") : BUNDLE.getString("Luggage");
            button2 = (inBeheer) ? BUNDLE.getString("Manager") : BUNDLE.getString("Passenger");

            //initializing the screen and centering it
            try {
                this.bg = ImageIO.read(getClass().getResourceAsStream("/img/bg.png"));
            } catch (IOException e) {
                Debug.printError(e.toString());
            }
            initComponents();
            this.setLocationRelativeTo(null);
            tableResults.getColumnModel().getColumn(0).setHeaderValue("#");
            tableResults.getColumnModel().getColumn(1).setHeaderValue(BUNDLE.getString("table.LuggageNumber"));
            tableResults.getColumnModel().getColumn(2).setHeaderValue(BUNDLE.getString("table.AddDate"));
            tableResults.getColumnModel().getColumn(3).setHeaderValue(BUNDLE.getString("table.HandlerName"));

            //Access management: users can not see the appmanagement screen
            appManagementButton.setVisible(beheer);
            moreButton.setVisible(false);
            fadeMore();
            //default
            setCursor(defaultCursor);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        searchButton = new javax.swing.JButton();
        addNewButton1 = new javax.swing.JButton();
        addNewButton2 = new javax.swing.JButton();
        moreButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableResults = new javax.swing.JTable();
        appManagementButton = new javax.swing.JButton();
        myAccountButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        LabelDescription = new javax.swing.JLabel();
        searchInput = new javax.swing.JTextField();

        setName("frame"); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Bundle"); // NOI18N
        setTitle(bundle.getString("medewerkerMain.title")); // NOI18N
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        searchButton.setText(bundle.getString("MainGuiFrame.searchButton.text")); // NOI18N
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        addNewButton1.setText(BUNDLE.getString("MainGuiFrame.addNew") +" " + button1);
        addNewButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewButton1ActionPerformed(evt);
            }
        });

        addNewButton2.setText(BUNDLE.getString("MainGuiFrame.addNew") +" " + button2);
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
                "#", "Labelnumber", "Add date", "Handler"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableResults.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableResults.setRowHeight(20);
        tableResults.setRowSelectionAllowed(false);
        tableResults.setShowVerticalLines(false);
        tableResults.getTableHeader().setResizingAllowed(false);
        tableResults.getTableHeader().setReorderingAllowed(false);
        tableResults.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableResultsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableResults);
        if (tableResults.getColumnModel().getColumnCount() > 0) {
            tableResults.getColumnModel().getColumn(0).setHeaderValue(bundle.getString("MainGuiFrame.tableResults.columnModel.title0")); // NOI18N
            tableResults.getColumnModel().getColumn(1).setHeaderValue(bundle.getString("MainGuiFrame.tableResults.columnModel.title1")); // NOI18N
            tableResults.getColumnModel().getColumn(2).setHeaderValue(bundle.getString("MainGuiFrame.tableResults.columnModel.title2")); // NOI18N
            tableResults.getColumnModel().getColumn(3).setHeaderValue(bundle.getString("MainGuiFrame.tableResults.columnModel.title3")); // NOI18N
        }

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
                .addContainerGap(27, Short.MAX_VALUE)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(LabelDescription)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(addNewButton1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(addNewButton2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(moreButton))
                    .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 1147, Short.MAX_VALUE)
                    .add(searchInput)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                        .add(searchButton)
                        .add(527, 527, 527)))
                .addContainerGap(26, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(appManagementButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(myAccountButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(logoutButton)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                .add(20, 20, 20)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(appManagementButton)
                    .add(myAccountButton)
                    .add(logoutButton))
                .add(80, 80, 80)
                .add(LabelDescription)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(searchInput, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(searchButton)
                .add(18, 18, Short.MAX_VALUE)
                .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 596, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(addNewButton1)
                    .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(moreButton)
                        .add(addNewButton2)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void menuBeheer() {
        //Menu settings
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu(BUNDLE.getString("menu"));

        MenuShortcut dbSC = new MenuShortcut(KeyEvent.VK_D);
        MenuShortcut helpSC = new MenuShortcut(KeyEvent.VK_F1);

        MenuItem db = new MenuItem(BUNDLE.getString("menu.db"), dbSC);
        MenuItem help = new MenuItem(BUNDLE.getString("menu.help"), helpSC);

        DBListener actionDb = new DBListener();
        HelpListener actionHelp = new HelpListener();

        db.addActionListener(actionDb);
        help.addActionListener(actionHelp);

        menuBar.add(menu);
        menu.add(help);
        if (!inBeheer) {
            menu.remove(db);
        } else {
            menu.add(db);
        }
        setMenuBar(menuBar);
    }
    /*
     * Display more results
     * TODO: How-Fei will do this
     */
    private void moreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moreButtonActionPerformed
        if (inBeheer) {
            fillTableMedewerkersMore();
        } else {
            fillTableCasesMore();
        }
    }//GEN-LAST:event_moreButtonActionPerformed

    /*
     * Switch to the Application Management screen.
     * TODO: Clean this up (Make a menu method, )
     */
    private void appManagementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appManagementButtonActionPerformed
        setCursor(waiting);

        if (beheer) {
            if (inBeheer) {
                addNewButton1.setText(BUNDLE.getString("MainGuiFrame.addNew") + button1);
                addNewButton2.setText(BUNDLE.getString("MainGuiFrame.addNew") + button2);
                appManagementButton.setText(BUNDLE.getString("MainGuiFrame.beheerButtonOn"));
                LabelDescription.setText(BUNDLE.getString("Search") + ":");
                //TODO: readAll should be from the Cases, not Dao
                fillTableCases(notify);
                inBeheer = false;
                menuBeheer();
            } else {
                addNewButton1.setText(BUNDLE.getString("MainGuiFrame.addNew") + BUNDLE.getString("Manager"));
                addNewButton2.setText(BUNDLE.getString("MainGuiFrame.addNew") + BUNDLE.getString("Medewerker"));
                appManagementButton.setText(BUNDLE.getString("MainGuiFrame.beheerButtonOff"));
                LabelDescription.setText(BUNDLE.getString("Search") + ":");
                fillTableMedewerkers();
                inBeheer = true;
                menuBeheer();
            }
        } else {
            Debug.println(BUNDLE.getString("notAuthorized"));
        }
        setCursor(defaultCursor);
    }//GEN-LAST:event_appManagementButtonActionPerformed

    /*
     * Open "My Account" allowing you to edit your password and language
     */
    private void myAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myAccountButtonActionPerformed
        MyAccount myAccount = new MyAccount(new javax.swing.JFrame(), true, handlerId);
        myAccount.pack();
        myAccount.setVisible(true);
        myAccount.setLocationRelativeTo(null);
    }//GEN-LAST:event_myAccountButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        dispose();
        logIn logOut = new logIn();
        logOut.setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void tableResultsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableResultsMouseClicked

        if (inBeheer && tableResults.getSelectedRow() < medList.size()) {
            UserEditDialog popup1 = new UserEditDialog(medList.get(tableResults.getSelectedRow()));
            popup1.setVisible(true);
        } else if (tableResults.getSelectedRow() < caseList.size() && !inBeheer) {
            CaseEditDialog popup = new CaseEditDialog(caseList.get(tableResults.getSelectedRow()), handlerId);
            popup.setVisible(true);
        } else {
            Debug.println("Wrong row clicked");
        }

    }//GEN-LAST:event_tableResultsMouseClicked

    private void addNewButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewButton1ActionPerformed

        if (inBeheer) {
            AddUser gui = new AddUser(true);
            gui.dispose();
            gui.setUndecorated(true);
            for (float i = 0.0f; i < 1.0f; i += 0.005f) {
                gui.setOpacity(i);
                gui.setVisible(true);
            }
        } else {
            AddLuggage gui = new AddLuggage(handlerId);
            gui.dispose();
            gui.setUndecorated(true);
            for (float i = 0.0f; i < 1.0f; i += 0.004f) {
                gui.setOpacity(i);
                gui.setVisible(true);
            }
        }

    }//GEN-LAST:event_addNewButton1ActionPerformed

    private void addNewButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewButton2ActionPerformed

        if (inBeheer) {
            AddUser gui = new AddUser(false);
            gui.dispose();
            gui.setUndecorated(true);
            for (float i = 0.0f; i < 1.0f; i += 0.004f) {
                gui.setOpacity(i);
                gui.setVisible(true);
            }
        } else {
            AddPassenger gui = new AddPassenger(handlerId);
            gui.dispose();
            gui.setUndecorated(true);
            for (float i = 0.0f; i < 1.0f; i += 0.005f) {
                gui.setOpacity(i);
                gui.setVisible(true);
            }
        }

    }//GEN-LAST:event_addNewButton2ActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        setCursor(waiting);
        if ("play tetris".equals(searchInput.getText().toLowerCase())) {
            Tetris.startApplication();
        } else {
            String std = searchInput.getText();
            String replaceAll = std.replaceAll("\\s+", "");
            String[] parts = replaceAll.split(",");

            int count = 1;
            for (String part : parts) {

                Debug.println("Part " + count + ":" + part);
                count++;
            }

            if (!inBeheer) {
                try {
                    CaseDao cdCase = new CaseDao();
                    caseList = cdCase.search(searchInput.getText());
                    Debug.println(searchInput.getText());
                    populateTableCase(caseList);
                    if (caseList.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No search results found.");
                    }
                } catch (SQLException e) {
                    Debug.printError(e.toString());

                }
            } else {
                try {
                    UserDAO dbMedewerker = new UserDAO();
                    medList = dbMedewerker.search(searchInput.getText());
                    populateTableMedewerker(medList);
                    if (medList.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No search results found.");
                    }
                } catch (SQLException e) {
                    Debug.printError(e.toString());
                }

            }
        }
        setCursor(defaultCursor);
    }//GEN-LAST:event_searchButtonActionPerformed

    private void searchInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchInputActionPerformed
        searchButtonActionPerformed(evt);
    }//GEN-LAST:event_searchInputActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        setCursor(waiting);
        if (inBeheer) {
            fillTableMedewerkers();
        } else {
            fillTableCases(notify);
        }
        Debug.println("Refreshing");
        setCursor(defaultCursor);
    }//GEN-LAST:event_formWindowGainedFocus

    public void fillTableCasesMore() {
        setCursor(waiting);
        CaseDao dbcase = new CaseDao();
        try {
            caseList = dbcase.readAllMore();
            populateTableCase(caseList);
        } catch (SQLException e) {
            Debug.printError(e.toString());
        }
        setCursor(defaultCursor);
    }

    private void fillTableCases(boolean start) {
        setCursor(waiting);
        CaseDao dbCase = new CaseDao();
        try {
            caseList = dbCase.readAll();
            populateTableCase(caseList);
            if (start) {
                for (int i = 0; i < messageRows.size(); i++) {
                    JOptionPane.showMessageDialog(null,
                            BUNDLE.getString("warning.longStay").replaceAll("%lbln", caseList.get(messageRows.get(i)).getLabel()),
                            BUNDLE.getString("warning.longStay.title"),
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (SQLException e) {
            Debug.printError(e.toString());
        }
        setCursor(defaultCursor);
    }

    public void fillTableMedewerkers() {
        UserDAO dbMedewerker = new UserDAO();
        try {
            medList = dbMedewerker.readAll();
        } catch (SQLException e) {
            Debug.printError(e.toString());
        }
        populateTableMedewerker(medList);
    }

    public void fillTableMedewerkersMore() {
        UserDAO dbMedewerker = new UserDAO();
        try {
            medList = dbMedewerker.readAllMore();
        } catch (SQLException e) {
            Debug.printError(e.toString());
        }
        populateTableMedewerker(medList);
    }

    public void populateTableMedewerker(List<User> list) {
        final ArrayList<Integer> appManagerList = new ArrayList<Integer>();
        final ArrayList<Integer> managerList = new ArrayList<Integer>();
        final ArrayList<Integer> userList = new ArrayList<Integer>();
        tableResults.getColumnModel().getColumn(0).setMaxWidth(350);
        tableResults.getColumnModel().getColumn(0).setPreferredWidth(250);
        for (int i = 0; i < 50; i++) {
            tableResults.getModel().setValueAt("", i, 0);
            tableResults.getModel().setValueAt("", i, 1);
            tableResults.getModel().setValueAt("", i, 2);
            tableResults.getModel().setValueAt("", i, 3);
        }
        for (int i = 0; i < list.size(); i++) {
            tableResults.getModel().setValueAt(list.get(i).getName(), i, 0);
            tableResults.getModel().setValueAt(list.get(i).getUsername(), i, 1);
            tableResults.getModel().setValueAt(list.get(i).isAppManager(), i, 2);
            tableResults.getModel().setValueAt(list.get(i).isManager(), i, 3);
            if (list.get(i).isAppManager()) {
                appManagerList.add(i);
            } else if (list.get(i).isManager()) {
                managerList.add(i);
            } else {
                userList.add(i);
            }
        }
        tableResults.setDefaultRenderer(Object.class, new TableCellRenderer() {
            private final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (appManagerList.contains(row)) {
                    c.setBackground(appManagerColor);
                } else {
                    if (managerList.contains(row)) {
                        c.setBackground(managerColor);
                    } else if (userList.contains(row)) {
                        c.setBackground(userColor);
                    } else {
                        c.setBackground(offWhite);
                    }
                }
                return c;
            }
        });
        tableResults.getColumnModel().getColumn(0).setHeaderValue(BUNDLE.getString("table.Name"));
        tableResults.getColumnModel().getColumn(1).setHeaderValue(BUNDLE.getString("table.Username"));
        tableResults.getColumnModel().getColumn(2).setHeaderValue(BUNDLE.getString("table.Appmanager"));
        tableResults.getColumnModel().getColumn(3).setHeaderValue(BUNDLE.getString("table.Manager"));
    }

    public void populateTableCase(final List<Case> list) {
        tableResults.getColumnModel().getColumn(0).setMaxWidth(35);
        final ArrayList<Integer> resolveList = new ArrayList<Integer>();
        final ArrayList<Integer> passengerList = new ArrayList<Integer>();
        final ArrayList<Integer> luggageList = new ArrayList<Integer>();
        for (int i = 0; i < 50; i++) {
            tableResults.getModel().setValueAt("", i, 0);
            tableResults.getModel().setValueAt("", i, 1);
            tableResults.getModel().setValueAt("", i, 2);
            tableResults.getModel().setValueAt("", i, 3);
        }
        for (int i = 0; i < list.size(); i++) {
            tableResults.getModel().setValueAt(i + 1, i, 0);
            tableResults.getModel().setValueAt(list.get(i).getLabel(), i, 1);
            tableResults.getModel().setValueAt(list.get(i).getAddDate(), i, 2);
            tableResults.getModel().setValueAt(list.get(i).getHandler(), i, 3);
            if (i < list.size()) {
                Date date = list.get(i).getAddDate();
                Date now = new Date();
                if (Check.dateDiff(date, now) > 30 && !messageRows.contains(i)) {
                    messageRows.add(i);
                }
            }
            if (list.get(i).getResolveDate() != null) {
                resolveList.add(i);
            } else if (list.get(i).getHomeAddress() != null) {
                passengerList.add(i);
            } else {
                luggageList.add(i);
            }

        }
        tableResults.setDefaultRenderer(Object.class, new TableCellRenderer() {
            private final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (resolveList.contains(row)) {
                    c.setBackground(resolvedColor);
                } else {
                    if (passengerList.contains(row)) {
                        c.setBackground(passengerColor);
                    } else if (luggageList.contains(row)) {
                        c.setBackground(luggageColor);
                    } else {
                        c.setBackground(offWhite);
                    }
                }
                return c;
            }
        });
        tableResults.getColumnModel().getColumn(0).setHeaderValue("#");
        tableResults.getColumnModel().getColumn(1).setHeaderValue(BUNDLE.getString("table.LuggageNumber"));
        tableResults.getColumnModel().getColumn(2).setHeaderValue(BUNDLE.getString("table.AddDate"));
        tableResults.getColumnModel().getColumn(3).setHeaderValue(BUNDLE.getString("table.HandlerName"));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelDescription;
    private javax.swing.JButton addNewButton1;
    private javax.swing.JButton addNewButton2;
    private javax.swing.JButton appManagementButton;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton moreButton;
    private javax.swing.JButton myAccountButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchInput;
    private javax.swing.JTable tableResults;
    // End of variables declaration//GEN-END:variables

    private void fadeMore() {
        jScrollPane3.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent ae) {
                boolean fadable;
                fadable = (jScrollPane3.getVerticalScrollBar().getValue() > 420);
                if (fadable) {
                    Debug.println(fadable + "");
                    moreButton.setVisible(true);
                } else {
                    moreButton.setVisible(false);
                }
            }
        });
    }

    private class HelpListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            File manual;
            if ("nl_NL".equals(Locale.getDefault().toString())) {
                manual = new File(MainGuiFrame.class.getResource("/manual/NL.pdf").getPath());
            } else {
                manual = new File(MainGuiFrame.class.getResource("/manual/EN.pdf").getPath());
            }
            PDFViewer manualViewer = new PDFViewer(manual);
            manualViewer.setVisible(true);
        }
    }

    private class DBListener implements ActionListener {

        private Frame MainGuiFrame;

        @Override
        public void actionPerformed(ActionEvent e) {
            DbDialog dialog;
            dialog = new DbDialog(MainGuiFrame, true);
            dialog.setVisible(true);
        }
    }

    private abstract class MainFocus implements FocusListener {

        /*@Override
         public void focusGained(FocusEvent e) {
         Debug.println("Focus gained");
         if (inBeheer) {
         fillTableMedewerkers();
         } else {
         fillTableCases(notify);
         }
         }

         @Override
         public void focusLost(FocusEvent e) {
         Debug.println("Focus lost");
         }*/
    }

    private static class ImagePanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); // paint the background image and scale it to fill the entire space
            Graphics2D g2 = (Graphics2D) g;
            Dimension d = super.getSize();
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.drawImage(bg, 0, 0, d.width, d.height, null);
        }
    }
}
