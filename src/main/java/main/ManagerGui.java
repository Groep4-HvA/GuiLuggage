package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import models.Case;
import models.CaseDao;
import models.Check;
import models.Debug;
import models.PDFGenerator;
import popups.MyAccount;

/**
 *
 * @author Groep 4 HvA
 */
public class ManagerGui extends java.awt.Frame {

    private final java.util.ResourceBundle BUNDLE = java.util.ResourceBundle.getBundle("Bundle"); // NOI18N
    
    /**
     * Creates new form MainGuiFrame
     */
    private boolean beheer;
    private int handlerId;
    private Date datum1;
    private Date datum2;
    private String dateString;
    private String dateString2;
    private PDFGenerator pdf;
    private final CaseDao dbCase = new CaseDao();
    private List<Case> list;
    private List<Case> listPending;
    private List<Case> listResolved;
    public ManagerGraph graph;
    private static Image bg;
    private final DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    private final Date today = Calendar.getInstance().getTime();
    private final String date = df.format(today);
    private final Cursor waiting = new Cursor(Cursor.WAIT_CURSOR);
    private final Cursor defaultCursor = new Cursor(Cursor.DEFAULT_CURSOR);
    private final Color resolvedColor = new Color(0xFF20A545, true);
    private final Color passengerColor = new Color(0xFFF09517, true);
    private final Color luggageColor = new Color(0xFF2584C1, true);
    private final Color offWhite = new Color(237, 237, 237);

    /**
     * Shows the GUI for the manager
     *
     * @param beheer
     * @param handlerId
     * @throws SQLException
     */
    public ManagerGui(boolean beheer, int handlerId) throws SQLException {
        setCursor(waiting);
        if (!Check.verifyLogin()) {
            Runtime.getRuntime().exit(1);
        } else {
            this.handlerId = handlerId;
            this.beheer = beheer;
            initComponents();
            try {
                ManagerGui.bg = ImageIO.read(getClass().getResourceAsStream("/img/bg.png"));
            } catch (IOException e) {
                Debug.printError(e.toString());
            }

            list = dbCase.readAllMore();
            listPending = dbCase.readAllPending();
            listResolved = dbCase.readAllResolved();

            pendingLabel.setText(BUNDLE.getString("ManagerGui.pendingLabel.text") + "" + listPending.size());
            resolvLabel.setText(BUNDLE.getString("ManagerGui.resolvLabel.text") + "" + listResolved.size());
            totalLabel.setText(BUNDLE.getString("ManagerGui.totalLabel.text") + "" + list.size());
            jTable1.getColumnModel().getColumn(0).setHeaderValue("#");
            jTable1.getColumnModel().getColumn(1).setHeaderValue(BUNDLE.getString("table.LuggageNumber"));
            jTable1.getColumnModel().getColumn(2).setHeaderValue(BUNDLE.getString("table.AddDate"));
            fillTable(list);
            processedManager.setForeground(Color.red);
            processedManager.setOpaque(true);
            missingManager.setOpaque(true);
            foundManager.setOpaque(true);
        }
        setCursor(defaultCursor);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new ImagePanel();
        myAccountButton = new javax.swing.JButton();
        javax.swing.JButton moreButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        missingManager = new javax.swing.JButton();
        foundManager = new javax.swing.JButton();
        processedManager = new javax.swing.JButton();
        graphManager = new javax.swing.JButton();
        pendingLabel = new javax.swing.JLabel();
        resolvLabel = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        printButton = new javax.swing.JButton();
        tillLabel = new javax.swing.JLabel();
        selectButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        PDF = new javax.swing.JButton();
        firstDateChooser = new com.toedter.calendar.JDateChooser();
        secondDateChooser = new com.toedter.calendar.JDateChooser();
        clearButton = new javax.swing.JButton();

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

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Bundle"); // NOI18N
        myAccountButton.setText(bundle.getString("ManagerGui.myAccountButton.text")); // NOI18N
        myAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myAccountButtonActionPerformed(evt);
            }
        });

        moreButton.setText(bundle.getString("ManagerGui.moreButton.text")); // NOI18N
        moreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moreButtonActionPerformed(evt);
            }
        });

        logoutButton.setText(bundle.getString("ManagerGui.logoutButton.text")); // NOI18N
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        missingManager.setText(bundle.getString("ManagerGui.missingManagerGui.text")); // NOI18N
        missingManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                missingManagerActionPerformed(evt);
            }
        });

        foundManager.setText(bundle.getString("ManagerGui.foundManagerGui.text")); // NOI18N
        foundManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foundManagerActionPerformed(evt);
            }
        });

        processedManager.setText(bundle.getString("ManagerGui.processedManagerGui.text")); // NOI18N
        processedManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processedManagerActionPerformed(evt);
            }
        });

        graphManager.setText(bundle.getString("ManagerGui.graphManagerGui.text")); // NOI18N
        graphManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphManagerActionPerformed(evt);
            }
        });

        pendingLabel.setText(bundle.getString("ManagerGui.pendingLabel.text")); // NOI18N

        resolvLabel.setText(bundle.getString("ManagerGui.resolvLabel.text")); // NOI18N

        totalLabel.setText(bundle.getString("ManagerGui.totalLabel.text")); // NOI18N

        printButton.setText(bundle.getString("ManagerGui.printButton.text")); // NOI18N
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        tillLabel.setText(bundle.getString("ManagerGui.tillLabel.text")); // NOI18N

        selectButton.setText(bundle.getString("ManagerGui.jButton2.text")); // NOI18N
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nr", "LabelNumber", "AddDate"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setHeaderValue(bundle.getString("ManagerGui.jTable1.columnModel.title0")); // NOI18N
            jTable1.getColumnModel().getColumn(1).setHeaderValue(bundle.getString("ManagerGui.jTable1.columnModel.title1")); // NOI18N
            jTable1.getColumnModel().getColumn(2).setHeaderValue(bundle.getString("ManagerGui.jTable1.columnModel.title2")); // NOI18N
        }

        PDF.setText(bundle.getString("ManagerGui.PDF.text")); // NOI18N
        PDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PDFActionPerformed(evt);
            }
        });

        clearButton.setText(bundle.getString("ManagerGui.clearButton.text")); // NOI18N
        clearButton.setActionCommand(bundle.getString("ManagerGui.clearButton.actionCommand")); // NOI18N
        clearButton.setMaximumSize(new java.awt.Dimension(61, 23));
        clearButton.setMinimumSize(new java.awt.Dimension(61, 23));
        clearButton.setPreferredSize(new java.awt.Dimension(61, 23));
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(50, 50, 50)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jScrollPane1)
                            .add(jPanel2Layout.createSequentialGroup()
                                .add(missingManager)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(foundManager)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(processedManager)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(pendingLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 93, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(resolvLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 126, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(totalLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(graphManager))
                            .add(jPanel2Layout.createSequentialGroup()
                                .add(printButton)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(PDF)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 140, Short.MAX_VALUE)
                                .add(firstDateChooser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(tillLabel)
                                .add(18, 18, 18)
                                .add(secondDateChooser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(selectButton)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(clearButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 71, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 233, Short.MAX_VALUE)
                                .add(moreButton)))
                        .add(50, 50, 50))
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(myAccountButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(logoutButton)
                        .add(6, 6, 6))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(20, 20, 20)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(myAccountButton)
                    .add(logoutButton))
                .add(70, 70, 70)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(missingManager)
                    .add(processedManager)
                    .add(graphManager)
                    .add(pendingLabel)
                    .add(resolvLabel)
                    .add(totalLabel)
                    .add(foundManager))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(clearButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(moreButton)
                        .add(selectButton))
                    .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(tillLabel)
                        .add(PDF)
                        .add(printButton))
                    .add(secondDateChooser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(firstDateChooser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(27, 27, 27))
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
    /**
     * Get more entries
     *
     * @param evt
     */
    private void moreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moreButtonActionPerformed
        try {
            list = dbCase.readAllMore();
        } catch (SQLException ex) {
            Logger.getLogger(ManagerGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        fillTable(list);
    }//GEN-LAST:event_moreButtonActionPerformed
    /**
     * Show My Account
     *
     * @param evt
     */
    private void myAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myAccountButtonActionPerformed
        MyAccount passOverlay = new MyAccount(new javax.swing.JFrame(), true, handlerId);
        passOverlay.pack();
        passOverlay.setVisible(true);
        passOverlay.setLocationRelativeTo(null);
    }//GEN-LAST:event_myAccountButtonActionPerformed
    /**
     * Show only the missing entries
     *
     * @param evt
     */
    private void missingManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_missingManagerActionPerformed
        setCursor(waiting);
        datum1 = firstDateChooser.getDate();
        dateString = String.format("%1$tY-%1$tm-%1$td", datum1);
        datum2 = secondDateChooser.getDate();
        dateString2 = String.format("%1$tY-%1$tm-%1$td", datum2);
        missingManager.setForeground(Color.red);
        processedManager.setForeground(Color.black);
        foundManager.setForeground(Color.black);
        try {
            if (firstDateChooser.getDate() == null || secondDateChooser.getDate() == null) {
                list = dbCase.readAllPending();
            } else {
                if (!dateString.equals(dateString2)) {
                    if (dateString.compareTo(dateString2) < 0) {
                        list = dbCase.readAllPendingByDate(dateString, dateString2);
                    } else {
                        JOptionPane.showMessageDialog(null, datum1 + " " + BUNDLE.getString("furtherInPast") + " " + datum2);
                    }
                } else if (dateString.equals(dateString2)) {
                    list = dbCase.readAllPendingByDate(dateString, dateString2);
                } else {
                    JOptionPane.showMessageDialog(null, datum1 + " " + BUNDLE.getString("needsToBeGreater") + " " + datum2);
                }
            }
            fillTable(list);
        } catch (SQLException e) {
            Debug.printError(e.toString());
        } catch (HeadlessException e) {
            Debug.printError(e.toString());
        }
        setCursor(defaultCursor);
    }//GEN-LAST:event_missingManagerActionPerformed
    /**
     * Show only the processed entries
     *
     * @param evt
     */
    private void processedManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processedManagerActionPerformed
        setCursor(waiting);
        try {
            datum1 = firstDateChooser.getDate();
            dateString = String.format("%1$tY-%1$tm-%1$td", datum1);
            datum2 = secondDateChooser.getDate();
            dateString2 = String.format("%1$tY-%1$tm-%1$td", datum2);
            missingManager.setForeground(Color.black);
            processedManager.setForeground(Color.red);
            foundManager.setForeground(Color.black);
            if (firstDateChooser.getDate() == null || secondDateChooser.getDate() == null) {
                list = dbCase.readAll();
                fillTable(list);
            } else {
                if (!dateString.equals(dateString2)) {
                    if (dateString.compareTo(dateString2) < 0) {
                        list = dbCase.readAllByDate(dateString, dateString2);
                        fillTable(list);
                    } else {
                        JOptionPane.showMessageDialog(null, datum1 + " " + BUNDLE.getString("furtherInPast") + " " + datum2);
                        fillTable(list);
                    }
                } else if (dateString.equals(dateString2)) {
                    list = dbCase.readAllByDate(dateString, dateString2);
                    fillTable(list);
                } else {
                    JOptionPane.showMessageDialog(null, datum1 + " " + BUNDLE.getString("needsToBeGreater") + " " + datum2);
                }
            }
        } catch (SQLException e) {
            Debug.printError(e.toString());
        } catch (HeadlessException e) {
            Debug.printError(e.toString());
        }
        setCursor(defaultCursor);
    }//GEN-LAST:event_processedManagerActionPerformed
    /**
     * Print a page with the PDF
     *
     * @param evt
     */
    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        makePDF();
        pdf.print();
    }//GEN-LAST:event_printButtonActionPerformed
    /**
     * Log out of the application
     *
     * @param evt
     */
    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        dispose();
        logIn logOut = new logIn();
        logOut.setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed
    /**
     * Make a PDF with the data
     *
     * @param evt
     */
    private void PDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PDFActionPerformed
        setCursor(waiting);
        makePDF();
        pdf.save("Corendon_Overview_" + date);
        setCursor(defaultCursor);
    }//GEN-LAST:event_PDFActionPerformed
    /**
     * Show only the data between the selected dates
     *
     * @param evt
     */
    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
        setCursor(waiting);
        try {
            datum1 = firstDateChooser.getDate();
            dateString = String.format("%1$tY-%1$tm-%1$td", datum1);
            datum2 = secondDateChooser.getDate();
            dateString2 = String.format("%1$tY-%1$tm-%1$td", datum2);

            Debug.println(dateString);

            if (!dateString.equals(dateString2)) {

                if (dateString.compareTo(dateString2) < 0) {
                    list = dbCase.readAllByDate(dateString, dateString2);
                    fillTable(list);
                } else {
                    JOptionPane.showMessageDialog(null, datum1 + " " + BUNDLE.getString("furtherInPast") + " " + datum2);
                }
            } else if (dateString.equals(dateString2)) {
                list = dbCase.readAllByDate(dateString, dateString2);
                fillTable(list);

            } else {
                JOptionPane.showMessageDialog(null, datum1 + " " + BUNDLE.getString("furtherInPast") + " " + datum2);
            }

        } catch (HeadlessException e) {
            Debug.printError(e.toString());
        } catch (SQLException e) {
            Debug.printError(e.toString());
        }
        setCursor(defaultCursor);

    }//GEN-LAST:event_selectButtonActionPerformed
    /**
     * Show only the entries that are found
     *
     * @param evt
     */
    private void foundManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foundManagerActionPerformed
        setCursor(waiting);
        try {
            datum1 = firstDateChooser.getDate();
            dateString = String.format("%1$tY-%1$tm-%1$td", datum1);
            datum2 = secondDateChooser.getDate();
            dateString2 = String.format("%1$tY-%1$tm-%1$td", datum2);
            missingManager.setForeground(Color.black);
            processedManager.setForeground(Color.black);
            foundManager.setForeground(Color.red);
            if (firstDateChooser.getDate() == null || secondDateChooser.getDate() == null) {
                list = dbCase.readAllResolved();
            } else {
                if (!dateString.equals(dateString2)) {
                    if (dateString.compareTo(dateString2) < 0) {
                        list = dbCase.readAllResolvedByDate(dateString, dateString2);
                    } else {
                        JOptionPane.showMessageDialog(null, datum1 + " " + BUNDLE.getString("furtherInPast") + " " + datum2);
                    }
                } else if (dateString.equals(dateString2)) {
                    list = dbCase.readAllResolvedByDate(dateString, dateString2);

                } else {
                    JOptionPane.showMessageDialog(null, datum1 + " " + BUNDLE.getString("needsToBeGreater") + " " + datum2);
                }
            }
            fillTable(list, "found");
        } catch (HeadlessException e) {
            Debug.printError(e.toString());
        } catch (SQLException e) {
            Debug.printError(e.toString());
        }
        setCursor(defaultCursor);
    }//GEN-LAST:event_foundManagerActionPerformed

    /**
     * Clear the filters
     *
     * @param evt
     */
    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        try {
            firstDateChooser.setDate(null);
            secondDateChooser.setDate(null);
            list = dbCase.readAll();
            fillTable(list);
        } catch (SQLException e) {
            Debug.printError(e.toString());
        }
    }//GEN-LAST:event_clearButtonActionPerformed
    /**
     * Generate a graph
     *
     * @param evt
     */
    private void graphManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphManagerActionPerformed
        setCursor(waiting);
        //jPanel1.setVisible(false);
        if (secondDateChooser.getDate() == null || firstDateChooser.getDate() == null) {
            graph = new ManagerGraph(BUNDLE.getString("ManagerGraph.windowTitle"), true);
        } else {
            graph = new ManagerGraph(BUNDLE.getString("ManagerGraph.windowTitle"), true, firstDateChooser.getDate(), secondDateChooser.getDate());
        }
        try {
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            graph.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
            graph.setLocationRelativeTo(null);
            graph.setSize(600, 400);
            graph.setVisible(true);
        } catch (HeadlessException e) {
            Debug.printError(e.toString());
        }
        setCursor(defaultCursor);
    }//GEN-LAST:event_graphManagerActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        fillTable(list);
        Debug.println("Refreshing");
    }//GEN-LAST:event_formWindowGainedFocus

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PDF;
    private javax.swing.JButton clearButton;
    private com.toedter.calendar.JDateChooser firstDateChooser;
    private javax.swing.JButton foundManager;
    private javax.swing.JButton graphManager;
    private ImagePanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton missingManager;
    private javax.swing.JButton myAccountButton;
    private javax.swing.JLabel pendingLabel;
    private javax.swing.JButton printButton;
    private javax.swing.JButton processedManager;
    private javax.swing.JLabel resolvLabel;
    private com.toedter.calendar.JDateChooser secondDateChooser;
    private javax.swing.JButton selectButton;
    private javax.swing.JLabel tillLabel;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables

    /**
     * Fill the table with data from the list
     *
     * @param list with database data
     */
    private void fillTable(List<Case> list) {
        final ArrayList<Integer> resolveList = new ArrayList<Integer>();
        final ArrayList<Integer> passengerList = new ArrayList<Integer>();
        final ArrayList<Integer> luggageList = new ArrayList<Integer>();
        for (int i = 0; i < 99; i++) {
            jTable1.getModel().setValueAt("", i, 0);
            jTable1.getModel().setValueAt("", i, 1);
            jTable1.getModel().setValueAt("", i, 2);
        }
        for (int i = 0; i < list.size(); i++) {
            int count = i + 1;
            jTable1.getModel().setValueAt(count, i, 0);
            jTable1.getModel().setValueAt(list.get(i).getLabel(), i, 1);
            jTable1.getModel().setValueAt(list.get(i).getAddDate(), i, 2);
            if (list.get(i).getResolveDate() != null) {
                resolveList.add(i);
            } else if (list.get(i).getHomeAddress() != null) {
                passengerList.add(i);
            } else {
                luggageList.add(i);
            }
        }
        jTable1.setDefaultRenderer(Object.class, new TableCellRenderer() {
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
    }

    private void fillTable(List<Case> list, final String tab) {
        final ArrayList<Integer> luggageList = new ArrayList<Integer>();
        for (int i = 0; i < 99; i++) {
            jTable1.getModel().setValueAt("", i, 0);
            jTable1.getModel().setValueAt("", i, 1);
            jTable1.getModel().setValueAt("", i, 2);
        }
        for (int i = 0; i < list.size(); i++) {
            int count = i + 1;
            jTable1.getModel().setValueAt(count, i, 0);
            jTable1.getModel().setValueAt(list.get(i).getLabel(), i, 1);
            jTable1.getModel().setValueAt(list.get(i).getAddDate().toString(), i, 2);
            luggageList.add(i);
        }
        jTable1.setDefaultRenderer(Object.class, new TableCellRenderer() {
            private final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (tab.equals("found") && luggageList.contains(row)) {
                    c.setBackground(resolvedColor);
                } else if (tab.equals("missing") && luggageList.contains(row)) {
                    c.setBackground(luggageColor);
                } else {
                    c.setBackground(offWhite);
                }

                return c;
            }
        });
    }

    /**
     * Make a PDF object
     */
    private void makePDF() {
        List<Case> dateTotal = null;
        List<Case> dateResolved = null;
        List<Case> datePending = null;
        try {
            list = dbCase.readAll();
            listPending = dbCase.readAllPending();
            listResolved = dbCase.readAllResolved();
            datePending = dbCase.readAllPendingByDate(dateString, dateString2);
            dateResolved = dbCase.readAllResolvedByDate(dateString, dateString2);
            dateTotal = dbCase.readAllTotalByDate(dateString, dateString2);
        } catch (SQLException e) {
            Debug.printError(e.toString());
        }
        String pending = Integer.toString(listPending.size());          //----Shows totalPending in PDF--------
        String resolved = Integer.toString(listResolved.size());        //----Shows totalResolved in PDF-------
        String total = Integer.toString(list.size());                   //----Shows total----------------------
        String pendingByDate = Integer.toString(datePending.size());    //----pending by date------------------
        String resolvedByDate = Integer.toString(dateResolved.size());  //----resolvedByDate-------------------
        String totalByDate = Integer.toString(dateTotal.size());        //----totalByDate----------------------
        graph = (firstDateChooser.getDate() == null
                || secondDateChooser.getDate() == null)
                ? new ManagerGraph(total, beheer)
                : new ManagerGraph(total, beheer, firstDateChooser.getDate(), secondDateChooser.getDate());
        pdf = new PDFGenerator();
        pdf.setChart(graph.imageStream());
        pdf.generate(pending, resolved, total, dateString, dateString2, pendingByDate, resolvedByDate, totalByDate);
    }

    /**
     * A new class to add a background
     */
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
