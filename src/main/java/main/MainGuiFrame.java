/**
 *
 */
package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import models.*;
import popups.*;

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
    private String button1 = null;
    private String button2 = null;

    //Access Management
    private boolean beheer;
    private int handlerId;
    private boolean inBeheer = false;
    private Image bg;

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
            menuBeheer();
            //pre init configuration of Strings
            this.handlerId = handlerId;
            this.beheer = beheer;
            button1 = (inBeheer) ? bundle.getString("Medewerker") : bundle.getString("Luggage");
            button2 = (inBeheer) ? bundle.getString("Manager") : bundle.getString("Passenger");

            //initializing the screen and centering it
            try {
                this.bg = ImageIO.read(getClass().getResourceAsStream("/img/bg.png"));
            } catch (IOException e) {
                Debug.printError(e.toString());
            }
            initComponents();
            this.setLocationRelativeTo(null);
            searchInput.requestFocusInWindow();

            //Access management: users can not see the appmanagement screen
            appManagementButton.setVisible(beheer);
            moreButton.setVisible(false);
            fillTableCases();
            fadeMore();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new ImagePanel();
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
        tableResults.setRowHeight(20);
        tableResults.setShowVerticalLines(false);
        tableResults.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableResultsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableResults);
        java.util.ResourceBundle bundle1 = java.util.ResourceBundle.getBundle("Bundle"); // NOI18N
        tableResults.getColumnModel().getColumn(0).setHeaderValue(bundle1.getString("MainGuiFrame.tableResults.columnModel.title0")); // NOI18N
        tableResults.getColumnModel().getColumn(1).setHeaderValue(bundle1.getString("MainGuiFrame.tableResults.columnModel.title1")); // NOI18N
        tableResults.getColumnModel().getColumn(2).setHeaderValue(bundle1.getString("MainGuiFrame.tableResults.columnModel.title2")); // NOI18N
        tableResults.getColumnModel().getColumn(3).setHeaderValue(bundle1.getString("MainGuiFrame.tableResults.columnModel.title3")); // NOI18N

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
                .add(searchButton)
                .add(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                .add(13, 13, 13)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(appManagementButton)
                    .add(myAccountButton)
                    .add(logoutButton))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED, 16, Short.MAX_VALUE)
                .add(LabelDescription)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(searchInput, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(searchButton)
                .add(18, 18, 18)
                .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(addNewButton1)
                    .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(moreButton)
                        .add(addNewButton2)))
                .addContainerGap(35, Short.MAX_VALUE))
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
        Menu menu = new Menu(bundle.getString("menu"));

        MenuShortcut dbSC= new MenuShortcut(KeyEvent.VK_D);
        MenuShortcut helpSC = new MenuShortcut(KeyEvent.VK_F1);
        
        MenuItem db = new MenuItem(bundle.getString("menu.db"), dbSC);
        MenuItem help = new MenuItem(bundle.getString("menu.help"), helpSC);

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
        fillTableMore();
    }//GEN-LAST:event_moreButtonActionPerformed

    /*
     * Switch to the Application Management screen.
     * TODO: Clean this up (Make a menu method, )
     */
    private void appManagementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appManagementButtonActionPerformed
        if (beheer) {
            if (inBeheer) {
                addNewButton1.setText(bundle.getString("MainGuiFrame.addNew") + button1);
                addNewButton2.setText(bundle.getString("MainGuiFrame.addNew") + button2);
                appManagementButton.setText(bundle.getString("MainGuiFrame.beheerButtonOn"));
                LabelDescription.setText("Search:");
                //TODO: readAll should be from the Cases, not Dao
                fillTableCases();
                inBeheer = false;
                menuBeheer();
            } else {
                addNewButton1.setText(bundle.getString("MainGuiFrame.addNew") + bundle.getString("Manager"));
                addNewButton2.setText(bundle.getString("MainGuiFrame.addNew") + bundle.getString("Medewerker"));
                appManagementButton.setText(bundle.getString("MainGuiFrame.beheerButtonOff"));
                LabelDescription.setText("Search:");
                fillTableMedewerkers();
                inBeheer = true;
                menuBeheer();
            }
        } else {
            Debug.println(bundle.getString("notAuthorized"));
        }
    }//GEN-LAST:event_appManagementButtonActionPerformed

    /*
     * Open "My Account" allowing you to edit your password and language
     * TODO: Preset the language of the user
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
        if (inBeheer) {
            Popupappmedewerker popup1 = new Popupappmedewerker(medList.get(tableResults.getSelectedRow()));
            popup1.setVisible(true);
        } else {
            PopUpMedewerker popup = new PopUpMedewerker(caseList.get(tableResults.getSelectedRow()), handlerId);
            popup.setVisible(true);
        }
    }//GEN-LAST:event_tableResultsMouseClicked

    private void addNewButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewButton1ActionPerformed
        if (inBeheer) {
            AddMedewerker gui = new AddMedewerker(true);
            gui.dispose();
            gui.setUndecorated(true);
            for (float i = 0.0f; i < 1.0f; i += 0.005f) {
                gui.setOpacity(i);
                //  System.out.println(i);
                gui.setVisible(true);
            }
        } else {
            AddLuggage gui = new AddLuggage(handlerId);
            gui.dispose();
            gui.setUndecorated(true);
            for (float i = 0.0f; i < 1.0f; i += 0.004f) {
                gui.setOpacity(i);
                //  System.out.println(i);
                gui.setVisible(true);
            }
        }
    }//GEN-LAST:event_addNewButton1ActionPerformed

    private void addNewButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewButton2ActionPerformed
        AddPassenger gui3 = new AddPassenger(handlerId);
        AddMedewerker gui2 = new AddMedewerker(false);
        if (inBeheer) {
            gui2.dispose();
            gui2.setUndecorated(true);
            for (float i = 0.0f; i < 1.0f; i += 0.004f) {
                //gui2.setOpacity(i);
                //  System.out.println(i);
                gui2.setVisible(true);
            }
        } else {
            gui3.dispose();
            gui3.setUndecorated(true);
            for (float i = 0.0f; i < 1.0f; i += 0.005f) {
                //gui3.setOpacity(i);
                //System.out.println(i);
                gui3.setVisible(true);
            }
        }
    }//GEN-LAST:event_addNewButton2ActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        Debug.println(searchInput.getText());
        
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
            } catch (SQLException e) {
                Debug.printError(e.toString());
            }
        } else {
            try {
                MedewerkerDAO dbMedewerker = new MedewerkerDAO();
                medList = dbMedewerker.search(searchInput.getText());
                populateTableMedewerker(medList);
            } catch (SQLException e) {
                Debug.printError(e.toString());
            }

        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void searchInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchInputActionPerformed
        searchButtonActionPerformed(evt);
    }//GEN-LAST:event_searchInputActionPerformed
    public void fillTableMore() {
        CaseDao dbcase = new CaseDao();
        try {
            caseList = dbcase.ReadAllMore();
        } catch (SQLException e) {
            Debug.printError(e.toString());
        }
        populateTableCase(caseList);
    }

    private void fillTableCases() {
        CaseDao dbCase = new CaseDao();
        try {
            caseList = dbCase.readAll();
        } catch (SQLException e) {
            Debug.printError(e.toString());
        }
        populateTableCase(caseList);
    }

    public void fillTableMedewerkers() {
        MedewerkerDAO dbMedewerker = new MedewerkerDAO();
        try {
            medList = dbMedewerker.readAll();
        } catch (SQLException e) {
            Debug.printError(e.toString());
        }
        populateTableMedewerker(medList);
    }

    public void populateTableMedewerker(List<Medewerker> list) {
        tableResults.getColumnModel().getColumn(0).setMaxWidth(350);
        tableResults.getColumnModel().getColumn(0).setPreferredWidth(250);
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
        tableResults.setDefaultRenderer(Object.class, new TableCellRenderer() {
            private final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setBackground(Color.WHITE);
                return c;
            }
        });
        tableResults.getColumnModel().getColumn(0).setHeaderValue("Name");
        tableResults.getColumnModel().getColumn(1).setHeaderValue("Username");
        tableResults.getColumnModel().getColumn(2).setHeaderValue("Appmanager");
        tableResults.getColumnModel().getColumn(3).setHeaderValue("Manager");
    }

    public void populateTableCase(List<Case> list) {
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
            if (list.get(i).getResolveDate() != null) {
                resolveList.add(i);
            }
            if (list.get(i).getHomeAddress() != null) {
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
                    c.setBackground(new Color(32, 165, 69));
                } else {
                    if (passengerList.contains(row)) {
                        c.setBackground(new Color(240, 149, 23));
                    } else if (luggageList.contains(row)) {
                        c.setBackground(new Color(37, 132, 193));
                    } else {
                        c.setBackground(new Color(240, 240, 240));
                    }
                }
                return c;
            }
        });
        tableResults.getColumnModel().getColumn(0).setHeaderValue("#");
        tableResults.getColumnModel().getColumn(1).setHeaderValue("Luggage Number");
        tableResults.getColumnModel().getColumn(2).setHeaderValue("Add date");
        tableResults.getColumnModel().getColumn(3).setHeaderValue("Handler name");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelDescription;
    private javax.swing.JButton addNewButton1;
    private javax.swing.JButton addNewButton2;
    private javax.swing.JButton appManagementButton;
    private ImagePanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton myAccountButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchInput;
    private JTable tableResults;
    private JButton moreButton;
    // End of variables declaration//GEN-END:variables

    private void fadeMore() {
        jScrollPane3.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent ae) {
                boolean fadable;
                fadable = (jScrollPane3.getVerticalScrollBar().getValue() > 1500);
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
            HelpDialog dialog = new HelpDialog();
            dialog.setVisible(true);
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

    private class ImagePanel extends JPanel {

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
