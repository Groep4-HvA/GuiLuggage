/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Case;
import models.CaseDao;
import models.Debug;
import models.PDFGenerator;
import models.printJob;
import popups.PasswordConfirm;

/**
 *
 * @author Groep 4 HvA
 */
public class ManagerGui extends java.awt.Frame {

    private java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Bundle"); // NOI18N
    /**
     * Creates new form MainGuiFrame
     */
    private boolean beheer;
    private int handlerId;
    private Date datum1;
    private Date datum2;
    private String dateString;
    private String dateString2;

    public ManagerGui(boolean beheer, int handlerId) throws SQLException {
	this.handlerId = handlerId;
	this.beheer = beheer;
	initComponents();

	CaseDao dbCase = new CaseDao();
	List<Case> list;
	list = dbCase.readAll();

	List<Case> listPending;
	listPending = dbCase.readAllPending();
	jLabel1.setText(bundle.getString("Manager.jLabel1.text") + "" + listPending.size());

	List<Case> listResolved;
	listResolved = dbCase.readAllResolved();
	jLabel2.setText(bundle.getString("Manager.jLabel2.text") + "" + listResolved.size());

	int x = 0;
	jLabel3.setText(bundle.getString("Manager.jLabel3.text") + "" + list.size());
	int count = 0;
	while (x < list.size()) {
	    count++;
	    //Debug.printout(list.get(x).toString());
	    jTable1.getModel().setValueAt(count, x, 0);
	    jTable1.getModel().setValueAt(list.get(x).getLabel(), x, 1);
	    jTable1.getModel().setValueAt(list.get(x).getAddDate(), x, 2);

	    x++;
	}

	jTable1.getColumnModel().getColumn(0).setHeaderValue("Nr");
	jTable1.getColumnModel().getColumn(1).setHeaderValue("LabelNumber");
	jTable1.getColumnModel().getColumn(2).setHeaderValue("AddDate");

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
        jLabel4 = new javax.swing.JLabel();
        selectButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        PDF = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        clearButton = new javax.swing.JButton();

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
        foundManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foundManagerActionPerformed(evt);
            }
        });

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

        jLabel2.setText(bundle.getString("Manager.jLabel2.text")); // NOI18N

        jLabel3.setText(bundle.getString("Manager.jLabel3.text")); // NOI18N

        printButton.setText(bundle.getString("Manager.printButton.text")); // NOI18N
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        jLabel4.setText(bundle.getString("Manager.jLabel4.text")); // NOI18N

        selectButton.setText(bundle.getString("Manager.jButton2.text")); // NOI18N
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
                {null, null, null}
            },
            new String [] {
                "Nr", "LabelNumber", "AddDate"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setHeaderValue(bundle.getString("ManagerGui.jTable1.columnModel.title0")); // NOI18N
        jTable1.getColumnModel().getColumn(1).setHeaderValue(bundle.getString("ManagerGui.jTable1.columnModel.title1")); // NOI18N
        jTable1.getColumnModel().getColumn(2).setHeaderValue(bundle.getString("ManagerGui.jTable1.columnModel.title2")); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 920, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
        );

        PDF.setText(bundle.getString("ManagerGui.PDF.text")); // NOI18N
        PDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PDFActionPerformed(evt);
            }
        });

        java.util.ResourceBundle bundle1 = java.util.ResourceBundle.getBundle("main/Bundle"); // NOI18N
        clearButton.setText(bundle1.getString("ManagerGui.clearButton.text")); // NOI18N
        clearButton.setActionCommand(bundle1.getString("ManagerGui.clearButton.actionCommand")); // NOI18N
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
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                        .add(printButton)
                        .add(18, 18, 18)
                        .add(PDF)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jDateChooser1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(jLabel4)
                        .add(18, 18, 18)
                        .add(jDateChooser2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(selectButton)
                        .add(18, 18, 18)
                        .add(clearButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 71, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(148, 148, 148)
                        .add(moreButton))
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(missingManager)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(foundManager)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(processedManager)
                        .add(67, 67, 67)
                        .add(jLabel1)
                        .add(18, 18, 18)
                        .add(jLabel2)
                        .add(18, 18, 18)
                        .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(graphManager))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                        .add(0, 6, Short.MAX_VALUE)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                                .add(myAccountButton)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(logoutButton))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(myAccountButton)
                    .add(logoutButton))
                .add(18, 18, 18)
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
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(moreButton)
                        .add(clearButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(selectButton))
                    .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(jLabel4)
                        .add(PDF)
                        .add(printButton))
                    .add(jDateChooser2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jDateChooser1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
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
	PasswordConfirm passOverlay = new PasswordConfirm(new javax.swing.JFrame(), true, handlerId);
	passOverlay.pack();
	passOverlay.setVisible(true);
	passOverlay.setLocationRelativeTo(null);
    }//GEN-LAST:event_myAccountButtonActionPerformed

    private void missingManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_missingManagerActionPerformed
	try {
	    Date datum1 = jDateChooser1.getDate();
	    String dateString = String.format("%1$tY-%1$tm-%1$td", datum1);
	    Date datum2 = jDateChooser2.getDate();
	    String dateString2 = String.format("%1$tY-%1$tm-%1$td", datum2);

//          System.out.println(dateString);
	    if (jDateChooser1.getDate() == null || jDateChooser2.getDate() == null) {

		CaseDao Case = new CaseDao();
		List<Case> list;
		list = Case.readAllPending();

		for (int x = 0; x < 50; x++) {
		    jTable1.getModel().setValueAt("", x, 0);
		    jTable1.getModel().setValueAt("", x, 1);
		    jTable1.getModel().setValueAt("", x, 2);
		}

		int x = 0;
		int count = 0;

		while (x < list.size()) {
		    //System.out.println(list.get(x).toString());
		    System.out.println(list.size());
		    count++;

		    jTable1.getModel().setValueAt(count, x, 0);
		    jTable1.getModel().setValueAt(list.get(x).getLabel(), x, 1);
		    jTable1.getModel().setValueAt(list.get(x).getAddDate(), x, 2);

		    x++;
		}

	    } else {
		if (!dateString.equals(dateString2)) {

		    if (dateString.compareTo(dateString2) < 0) {

			CaseDao Case = new CaseDao();
			List<Case> list;
			list = Case.readAllPendingByDate(dateString, dateString2);

			for (int x = 0; x < 50; x++) {
			    jTable1.getModel().setValueAt("", x, 0);
			    jTable1.getModel().setValueAt("", x, 1);
			    jTable1.getModel().setValueAt("", x, 2);
			}

			int x = 0;
			int count = 0;
			while (x < list.size()) {
			    //System.out.println(list.get(x).toString());
			    System.out.println(list.size());
			    count++;
			    jTable1.getModel().setValueAt(count, x, 0);
			    jTable1.getModel().setValueAt(list.get(x).getLabel(), x, 1);
			    jTable1.getModel().setValueAt(list.get(x).getAddDate(), x, 2);

			    x++;
			}
		    } else {
			JOptionPane.showMessageDialog(null, "" + datum1 + " cannot be further in the past then " + datum2);
		    }
		} else if (dateString.equals(dateString2)) {
		    CaseDao Case = new CaseDao();
		    List<Case> list;
		    list = Case.readAllPendingByDate(dateString, dateString2);

		    for (int x = 0; x < 50; x++) {
			jTable1.getModel().setValueAt("", x, 0);
			jTable1.getModel().setValueAt("", x, 1);
			jTable1.getModel().setValueAt("", x, 2);
		    }

		    int x = 0;
		    int count = 0;
		    while (x < list.size()) {
			//System.out.println(list.get(x).toString());
			System.out.println("s");
			count++;
			jTable1.getModel().setValueAt(count, x, 0);
			jTable1.getModel().setValueAt(list.get(x).getLabel(), x, 1);
			jTable1.getModel().setValueAt(list.get(x).getAddDate(), x, 2);

			x++;
		    }

		} else {
		    JOptionPane.showMessageDialog(null, "" + datum2 + " Needs to be greater then  " + datum1);
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }//GEN-LAST:event_missingManagerActionPerformed

    private void processedManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processedManagerActionPerformed
	try {

	    Date datum1 = jDateChooser1.getDate();
	    String dateString = String.format("%1$tY-%1$tm-%1$td", datum1);
	    Date datum2 = jDateChooser2.getDate();
	    String dateString2 = String.format("%1$tY-%1$tm-%1$td", datum2);

	    if (jDateChooser1.getDate() == null || jDateChooser2.getDate() == null) {

		CaseDao Case = new CaseDao();
		List<Case> list;
		list = Case.readAll();

		for (int x = 0; x < 50; x++) {
		    jTable1.getModel().setValueAt("", x, 0);
		    jTable1.getModel().setValueAt("", x, 1);
		    jTable1.getModel().setValueAt("", x, 2);
		}

		int x = 0;
		int count = 0;

		while (x < list.size()) {
		    //System.out.println(list.get(x).toString());
		    System.out.println(list.size());
		    count++;

		    jTable1.getModel().setValueAt(count, x, 0);
		    jTable1.getModel().setValueAt(list.get(x).getLabel(), x, 1);
		    jTable1.getModel().setValueAt(list.get(x).getAddDate(), x, 2);

		    x++;
		}

//          System.out.println(dateString);
	    } else {
		if (!dateString.equals(dateString2)) {

		    if (dateString.compareTo(dateString2) < 0) {

			CaseDao Case = new CaseDao();
			List<Case> list;
			list = Case.readAllTotalByDate(dateString, dateString2);

			for (int x = 0; x < 50; x++) {
			    jTable1.getModel().setValueAt("", x, 0);
			    jTable1.getModel().setValueAt("", x, 1);
			    jTable1.getModel().setValueAt("", x, 2);
			}

			int x = 0;
			int count = 0;
			while (x < list.size()) {
			    //System.out.println(list.get(x).toString());
			    System.out.println(list.size());
			    count++;
			    jTable1.getModel().setValueAt(count, x, 0);
			    jTable1.getModel().setValueAt(list.get(x).getLabel(), x, 1);
			    jTable1.getModel().setValueAt(list.get(x).getAddDate(), x, 2);

			    x++;
			}
		    } else {
			JOptionPane.showMessageDialog(null, "" + datum1 + " cannot be further in the past then " + datum2);
		    }
		} else if (dateString.equals(dateString2)) {
		    CaseDao Case = new CaseDao();
		    List<Case> list;
		    list = Case.readAllTotalByDate(dateString, dateString2);

		    for (int x = 0; x < 50; x++) {
			jTable1.getModel().setValueAt("", x, 0);
			jTable1.getModel().setValueAt("", x, 1);
			jTable1.getModel().setValueAt("", x, 2);
		    }

		    int x = 0;
		    int count = 0;
		    while (x < list.size()) {
			//System.out.println(list.get(x).toString());
			System.out.println("s");
			count++;
			jTable1.getModel().setValueAt(count, x, 0);
			jTable1.getModel().setValueAt(list.get(x).getLabel(), x, 1);
			jTable1.getModel().setValueAt(list.get(x).getAddDate(), x, 2);

			x++;
		    }

		} else {
		    JOptionPane.showMessageDialog(null, "" + datum2 + " Needs to be greater then  " + datum1);
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }//GEN-LAST:event_processedManagerActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
	printJob printJob = new printJob();
    }//GEN-LAST:event_printButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
	dispose();
	logIn logOut = new logIn();
	logOut.setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void PDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PDFActionPerformed
	DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	Date today = Calendar.getInstance().getTime();
	String date = df.format(today);
	//---Shows totalPending in PDF-------------------------------
	CaseDao dbCase = new CaseDao();
	List<Case> listPending = null;


	try {
	    listPending = dbCase.readAllPending();
	} catch (SQLException ex) {
	    Logger.getLogger(ManagerGui.class
		    .getName()).log(Level.SEVERE, null, ex);
	}
	String pending = Integer.toString(listPending.size());
	//----Shows totalResolved in PDF-------------------------------
	List<Case> listResolved = null;


	try {
	    listResolved = dbCase.readAllResolved();
	} catch (SQLException ex) {
	    Logger.getLogger(ManagerGui.class.getName()).log(Level.SEVERE, null, ex);
	}
	String resolved = Integer.toString(listResolved.size());
	//----Shows total ----------------------------------------------------------
	List<Case> list = null;
	try {
	    list = dbCase.readAll();
	} catch (SQLException ex) {
	    Logger.getLogger(ManagerGui.class.getName()).log(Level.SEVERE, null, ex);
	}
	String total = Integer.toString(list.size());
        //------pending by date---------------------------------------------------
        List<Case> datePending = null;
        try {
            datePending = dbCase.readAllPendingByDate(dateString, dateString2);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        String pendingByDate = Integer.toString(datePending.size());
        //-----resolvedByDate----------------------------------------------------
        List<Case> dateResolved = null;
        try {
            dateResolved = dbCase.readAllResolvedByDate(dateString, dateString2);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        String resolvedByDate = Integer.toString(dateResolved.size());
        //-----totalByDate------------------------------------------------------
        List<Case> dateTotal = null;
        try {
            dateTotal = dbCase.readAllTotalByDate(dateString, dateString2);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        String totalByDate = Integer.toString(dateTotal.size());
        
	PDFGenerator pdf = new PDFGenerator();

	pdf.generate(pending, resolved, total, dateString, dateString2, pendingByDate, resolvedByDate,totalByDate);


	try {
	    pdf.save("Corendon_Overview_" + date + ".pdf");
	} catch (FileNotFoundException ex) {
	    Logger.getLogger(ManagerGui.class.getName()).log(Level.SEVERE, null, ex);
	} catch (IOException ex) {
	    Logger.getLogger(ManagerGui.class.getName()).log(Level.SEVERE, null, ex);
	}
    }//GEN-LAST:event_PDFActionPerformed
    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
	try {

	    datum1 = jDateChooser1.getDate();
	    dateString = String.format("%1$tY-%1$tm-%1$td", datum1);
	    datum2 = jDateChooser2.getDate();
	    dateString2 = String.format("%1$tY-%1$tm-%1$td", datum2);

	    Debug.printout(dateString);

	    if (!dateString.equals(dateString2)) {

		if (dateString.compareTo(dateString2) < 0) {

		    CaseDao Case = new CaseDao();
		    List<Case> list;
		    list = Case.readAllByDate(dateString, dateString2);

		    for (int x = 0; x < 50; x++) {
			jTable1.getModel().setValueAt("", x, 0);
			jTable1.getModel().setValueAt("", x, 1);
			jTable1.getModel().setValueAt("", x, 2);
		    }

		    int x = 0;
		    int count = 0;
		    while (x < list.size()) {
			//Debug.printout(list.get(x).toString());
			Debug.printout(list.size() + "");
			count++;
			jTable1.getModel().setValueAt(count, x, 0);
			jTable1.getModel().setValueAt(list.get(x).getLabel(), x, 1);
			jTable1.getModel().setValueAt(list.get(x).getAddDate(), x, 2);

			x++;
		    }
		} else {
		    JOptionPane.showMessageDialog(null, "" + datum1 + " cannot be further in the past then " + datum2);
		}
	    } else if (dateString.equals(dateString2)) {
		CaseDao Case = new CaseDao();
		List<Case> list;
		list = Case.readAllByDate(dateString, dateString2);

		for (int x = 0; x < 50; x++) {
		    jTable1.getModel().setValueAt("", x, 0);
		    jTable1.getModel().setValueAt("", x, 1);
		    jTable1.getModel().setValueAt("", x, 2);
		}

		int x = 0;
		int count = 0;
		while (x < list.size()) {
		    //Debug.printout(list.get(x).toString());
		    Debug.printout("s");
		    count++;
		    jTable1.getModel().setValueAt(count, x, 0);
		    jTable1.getModel().setValueAt(list.get(x).getLabel(), x, 1);
		    jTable1.getModel().setValueAt(list.get(x).getAddDate(), x, 2);

		    x++;
		}

	    } else {
		JOptionPane.showMessageDialog(null, "" + datum1 + " cannot be further in the past then " + datum2);
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}


    }//GEN-LAST:event_selectButtonActionPerformed

    private void foundManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foundManagerActionPerformed
	try {

	    Date datum1 = jDateChooser1.getDate();
	    String dateString = String.format("%1$tY-%1$tm-%1$td", datum1);
	    Date datum2 = jDateChooser2.getDate();
	    String dateString2 = String.format("%1$tY-%1$tm-%1$td", datum2);

	    if (jDateChooser1.getDate() == null || jDateChooser2.getDate() == null) {

		CaseDao Case = new CaseDao();
		List<Case> list;
		list = Case.readAllResolved();

		for (int x = 0; x < 50; x++) {
		    jTable1.getModel().setValueAt("", x, 0);
		    jTable1.getModel().setValueAt("", x, 1);
		    jTable1.getModel().setValueAt("", x, 2);
		}

		int x = 0;
		int count = 0;

		while (x < list.size()) {
		    //System.out.println(list.get(x).toString());
		    System.out.println(list.size());
		    count++;

		    jTable1.getModel().setValueAt(count, x, 0);
		    jTable1.getModel().setValueAt(list.get(x).getLabel(), x, 1);
		    jTable1.getModel().setValueAt(list.get(x).getAddDate(), x, 2);

		    x++;
		}

//          System.out.println(dateString);
	    } else {
		if (!dateString.equals(dateString2)) {

		    if (dateString.compareTo(dateString2) < 0) {

			CaseDao Case = new CaseDao();
			List<Case> list;
			list = Case.readAllResolvedByDate(dateString, dateString2);

			for (int x = 0; x < 50; x++) {
			    jTable1.getModel().setValueAt("", x, 0);
			    jTable1.getModel().setValueAt("", x, 1);
			    jTable1.getModel().setValueAt("", x, 2);
			}

			int x = 0;
			int count = 0;
			while (x < list.size()) {
			    //System.out.println(list.get(x).toString());
			    System.out.println(list.size());
			    count++;
			    jTable1.getModel().setValueAt(count, x, 0);
			    jTable1.getModel().setValueAt(list.get(x).getLabel(), x, 1);
			    jTable1.getModel().setValueAt(list.get(x).getAddDate(), x, 2);

			    x++;
			}
		    } else {
			JOptionPane.showMessageDialog(null, "" + datum1 + " cannot be further in the past then " + datum2);
		    }
		} else if (dateString.equals(dateString2)) {
		    CaseDao Case = new CaseDao();
		    List<Case> list;
		    list = Case.readAllResolvedByDate(dateString, dateString2);

		    for (int x = 0; x < 50; x++) {
			jTable1.getModel().setValueAt("", x, 0);
			jTable1.getModel().setValueAt("", x, 1);
			jTable1.getModel().setValueAt("", x, 2);
		    }

		    int x = 0;
		    int count = 0;
		    while (x < list.size()) {
			//System.out.println(list.get(x).toString());
			System.out.println("s");
			count++;
			jTable1.getModel().setValueAt(count, x, 0);
			jTable1.getModel().setValueAt(list.get(x).getLabel(), x, 1);
			jTable1.getModel().setValueAt(list.get(x).getAddDate(), x, 2);

			x++;
		    }

		} else {
		    JOptionPane.showMessageDialog(null, "" + datum2 + " Needs to be greater then  " + datum1);
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}

    }//GEN-LAST:event_foundManagerActionPerformed
private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed

    try {

	jDateChooser1.setDate(null);
	jDateChooser2.setDate(null);

	CaseDao Case = new CaseDao();
	List<Case> list;
	list = Case.readAll();
	int x = 0;
	int count = 0;
	while (x < list.size()) {
	    count++;
	    //  System.out.println(list.get(x).toString());
	    jTable1.getModel().setValueAt(count, x, 0);
	    jTable1.getModel().setValueAt(list.get(x).getLabel(), x, 1);
	    jTable1.getModel().setValueAt(list.get(x).getAddDate(), x, 2);

	    x++;
	}        // TODO add your handling code here:
    } catch (Exception e) {
	e.printStackTrace();
    }
    }//GEN-LAST:event_clearButtonActionPerformed

    private void graphManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphManagerActionPerformed
	//jPanel1.setVisible(false);
	try {
	    ManagerGraph graph = new ManagerGraph("Manager graph", true);
	    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    graph.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
	    graph.setLocationRelativeTo(null);
	    graph.setSize(600, 400);
	    graph.setVisible(true);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }//GEN-LAST:event_graphManagerActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PDF;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton foundManager;
    private javax.swing.JButton graphManager;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton missingManager;
    private javax.swing.JButton myAccountButton;
    private javax.swing.JButton printButton;
    private javax.swing.JButton processedManager;
    private javax.swing.JButton selectButton;
    // End of variables declaration//GEN-END:variables
}
