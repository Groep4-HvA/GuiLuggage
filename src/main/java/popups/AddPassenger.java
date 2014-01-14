/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package popups;

import java.sql.SQLException;
import models.Check;
import models.Debug;
import models.PDFGenerator;
import models.Passenger;
import models.PassengerDAO;

/**
 *
 * @author User
 */
public class AddPassenger extends javax.swing.JFrame {

    private String label;
    private String color;
    private String shape;
    private String name;
    private String surname;
    private String adres;
    private String postalCode;
    private String city;
    private String residentAdres;
    private String residentPostalCode;
    private String residentCity;
    private String details;
    private String email;
    private int handlerId;
    private String phoneNr;
    private PDFGenerator pdf;

    /**
     * Creates new form AddPassenger
     *
     * @param handlerId
     */
    public AddPassenger(int handlerId) {
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

        labelTextfield = new javax.swing.JTextField();
        colorTextfield = new javax.swing.JTextField();
        shapeTextfield = new javax.swing.JTextField();
        nameTextfield = new javax.swing.JTextField();
        surnameTextfield = new javax.swing.JTextField();
        adresTextfield = new javax.swing.JTextField();
        residentAdresTextfield = new javax.swing.JTextField();
        rPostalCodeTextfield = new javax.swing.JTextField();
        rCityTextfield = new javax.swing.JTextField();
        detailsTextfield = new javax.swing.JTextField();
        saveButton = new javax.swing.JToggleButton();
        cancelButton = new javax.swing.JToggleButton();
        lLabelLabel = new javax.swing.JLabel();
        colorLabel = new javax.swing.JLabel();
        shapeLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        surNameLabel = new javax.swing.JLabel();
        addressHLabel = new javax.swing.JLabel();
        cityRLabel = new javax.swing.JLabel();
        postalCodeRLabel = new javax.swing.JLabel();
        aditionalDetailsLabel = new javax.swing.JLabel();
        printButton = new javax.swing.JToggleButton();
        addressRLabel = new javax.swing.JLabel();
        postalCodeHLabel = new javax.swing.JLabel();
        postalCodeTextfield = new javax.swing.JTextField();
        cityHLabel = new javax.swing.JLabel();
        cityTextfield = new javax.swing.JTextField();
        homeSeparator = new javax.swing.JSeparator();
        residentSeparator = new javax.swing.JSeparator();
        residentAddressLabel = new javax.swing.JLabel();
        hAddressLabel = new javax.swing.JLabel();
        phoneNrLabel = new javax.swing.JLabel();
        phoneNrText = new javax.swing.JTextField();
        pdfButton = new javax.swing.JButton();
        emailAdressLabel = new javax.swing.JLabel();
        emailAdress = new javax.swing.JTextField();
        requiredFields = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Bundle"); // NOI18N
        saveButton.setText(bundle.getString("AddPassenger.saveButton.text")); // NOI18N
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText(bundle.getString("AddPassenger.cancelButton.text")); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        lLabelLabel.setText(bundle.getString("AddPassenger.lLabelLabel.text")); // NOI18N

        colorLabel.setText(bundle.getString("AddPassenger.colorLabel.text")); // NOI18N

        shapeLabel.setText(bundle.getString("AddPassenger.shapeLabel.text")); // NOI18N

        nameLabel.setText(bundle.getString("AddPassenger.nameLabel.text")); // NOI18N

        surNameLabel.setText(bundle.getString("AddPassenger.surNameLabel.text")); // NOI18N

        addressHLabel.setText(bundle.getString("AddPassenger.addressHLabel.text")); // NOI18N

        cityRLabel.setText(bundle.getString("AddPassenger.cityRLabel.text")); // NOI18N

        postalCodeRLabel.setText(bundle.getString("AddPassenger.postalCodeRLabel.text")); // NOI18N

        aditionalDetailsLabel.setText(bundle.getString("AddPassenger.aditionalDetailsLabel.text")); // NOI18N

        printButton.setText(bundle.getString("AddPassenger.printButton.text")); // NOI18N
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        addressRLabel.setText(bundle.getString("AddPassenger.addressRLabel.text")); // NOI18N

        postalCodeHLabel.setText(bundle.getString("AddPassenger.postalCodeHLabel.text")); // NOI18N

        postalCodeTextfield.setText(bundle.getString("AddPassenger.postalCodeTextfield.text")); // NOI18N

        cityHLabel.setLabelFor(cityTextfield);
        cityHLabel.setText(bundle.getString("AddPassenger.cityHLabel.text")); // NOI18N

        cityTextfield.setText(bundle.getString("AddPassenger.cityTextfield.text")); // NOI18N

        residentAddressLabel.setText(bundle.getString("AddPassenger.residentAddressLabel.text")); // NOI18N

        hAddressLabel.setText(bundle.getString("AddPassenger.hAddressLabel.text")); // NOI18N

        phoneNrLabel.setText(bundle.getString("AddPassenger.phoneNrLabel.text")); // NOI18N

        phoneNrText.setText(bundle.getString("AddPassenger.phoneNrText.text")); // NOI18N
        phoneNrText.setToolTipText(bundle.getString("AddPassenger.phoneNrText.toolTipText")); // NOI18N
        phoneNrText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneNrTextActionPerformed(evt);
            }
        });

        pdfButton.setText(bundle.getString("AddPassenger.pdfButton.text")); // NOI18N
        pdfButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfButtonActionPerformed(evt);
            }
        });

        emailAdressLabel.setText(bundle.getString("AddPassenger.emailAdressLabel.text")); // NOI18N

        emailAdress.setText(bundle.getString("AddPassenger.emailAdress.text")); // NOI18N
        emailAdress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailAdressActionPerformed(evt);
            }
        });

        java.util.ResourceBundle bundle1 = java.util.ResourceBundle.getBundle("popups/Bundle"); // NOI18N
        requiredFields.setText(bundle1.getString("AddPassenger.requiredFields.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(residentSeparator)
                            .addComponent(homeSeparator)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addressHLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addressRLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(aditionalDetailsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(postalCodeHLabel)
                            .addComponent(postalCodeRLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(detailsTextfield)
                            .addComponent(adresTextfield, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(residentAdresTextfield, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(postalCodeTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(residentAddressLabel)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cityHLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(cityTextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rPostalCodeTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cityRLabel)
                                .addGap(18, 18, 18)
                                .addComponent(rCityTextfield))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(134, 134, 134)
                                .addComponent(hAddressLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(requiredFields)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pdfButton)
                                .addGap(17, 17, 17)
                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(colorLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                .addComponent(lLabelLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                .addComponent(shapeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                .addComponent(phoneNrLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(emailAdressLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(colorTextfield, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(shapeTextfield, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelTextfield)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(surNameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(surnameTextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE))
                            .addComponent(phoneNrText)
                            .addComponent(emailAdress))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lLabelLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(colorLabel)
                    .addComponent(colorTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shapeTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shapeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(surnameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(surNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneNrLabel)
                    .addComponent(phoneNrText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailAdressLabel)
                    .addComponent(emailAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(hAddressLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(homeSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adresTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressHLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(postalCodeTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cityHLabel)
                    .addComponent(cityTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(postalCodeHLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(residentAddressLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(residentSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(residentAdresTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressRLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rPostalCodeTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rCityTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cityRLabel)
                    .addComponent(postalCodeRLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(detailsTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(aditionalDetailsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(saveButton)
                    .addComponent(printButton)
                    .addComponent(pdfButton)
                    .addComponent(requiredFields))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
	
        
        pdf = new PDFGenerator();
	pdf.generate(label, color, shape, name, surname, adres, postalCode, city, residentAdres, residentPostalCode, residentCity, details, handlerId, phoneNr, email);
	pdf.print();
    }//GEN-LAST:event_printButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
	Passenger newPassenger;

	label = labelTextfield.getText();
	color = colorTextfield.getText();
	shape = shapeTextfield.getText();
	name = nameTextfield.getText();
	surname = surnameTextfield.getText();
	postalCode = postalCodeTextfield.getText();
	adres = adresTextfield.getText();
	city = rCityTextfield.getText();
	adres = adresTextfield.getText();
	residentAdres = residentAdresTextfield.getText();
	residentPostalCode = rPostalCodeTextfield.getText();
	residentCity = rCityTextfield.getText();
	details = detailsTextfield.getText();
	phoneNr = phoneNrText.getText();
        email = emailAdress.getText();
        

	newPassenger = new Passenger(label, color, shape, name, surname, adres, postalCode, city, residentAdres, residentPostalCode, residentCity, details, phoneNr, email);
	PassengerDAO test = new PassengerDAO();
	try {
	    //        try {
	    //            test.create(newPassenger);
	    //        } catch (Exception ex) {
	    //            //Debug.printout("sssss");
	    //            ex.printStackTrace();
	    //        }
	    test.create(newPassenger, handlerId);
	} catch (SQLException e) {
	    Debug.printError(e.toString());
	}

	dispose();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
	dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void pdfButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfButtonActionPerformed
	PassengerDAO receipt = new PassengerDAO();

	label = labelTextfield.getText();
	color = colorTextfield.getText();
	shape = shapeTextfield.getText();
	name = nameTextfield.getText();
	surname = surnameTextfield.getText();
	postalCode = postalCodeTextfield.getText();
	adres = adresTextfield.getText();
	city = cityTextfield.getText();
	adres = adresTextfield.getText();
	residentAdres = residentAdresTextfield.getText();
	residentPostalCode = rPostalCodeTextfield.getText();
	residentCity = rCityTextfield.getText();
	details = detailsTextfield.getText();
	phoneNr = phoneNrText.getText();
        email = emailAdress.getText();

	pdf = new PDFGenerator();
	// passengerReceipt = null;
	pdf.generate(label, color, shape, name, surname, adres, postalCode, city, residentAdres, residentPostalCode, residentCity, details, handlerId, phoneNr, email);
	pdf.save("Receipt_" + label);
    }//GEN-LAST:event_pdfButtonActionPerformed

    private void emailAdressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailAdressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailAdressActionPerformed

    private void phoneNrTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneNrTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNrTextActionPerformed

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        this.dispose();
    }//GEN-LAST:event_formWindowLostFocus

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressHLabel;
    private javax.swing.JLabel addressRLabel;
    private javax.swing.JLabel aditionalDetailsLabel;
    private javax.swing.JTextField adresTextfield;
    private javax.swing.JToggleButton cancelButton;
    private javax.swing.JLabel cityHLabel;
    private javax.swing.JLabel cityRLabel;
    private javax.swing.JTextField cityTextfield;
    private javax.swing.JLabel colorLabel;
    private javax.swing.JTextField colorTextfield;
    private javax.swing.JTextField detailsTextfield;
    private javax.swing.JTextField emailAdress;
    private javax.swing.JLabel emailAdressLabel;
    private javax.swing.JLabel hAddressLabel;
    private javax.swing.JSeparator homeSeparator;
    private javax.swing.JLabel lLabelLabel;
    private javax.swing.JTextField labelTextfield;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextfield;
    private javax.swing.JButton pdfButton;
    private javax.swing.JLabel phoneNrLabel;
    private javax.swing.JTextField phoneNrText;
    private javax.swing.JLabel postalCodeHLabel;
    private javax.swing.JLabel postalCodeRLabel;
    private javax.swing.JTextField postalCodeTextfield;
    private javax.swing.JToggleButton printButton;
    private javax.swing.JTextField rCityTextfield;
    private javax.swing.JTextField rPostalCodeTextfield;
    private javax.swing.JLabel requiredFields;
    private javax.swing.JLabel residentAddressLabel;
    private javax.swing.JTextField residentAdresTextfield;
    private javax.swing.JSeparator residentSeparator;
    private javax.swing.JToggleButton saveButton;
    private javax.swing.JLabel shapeLabel;
    private javax.swing.JTextField shapeTextfield;
    private javax.swing.JLabel surNameLabel;
    private javax.swing.JTextField surnameTextfield;
    // End of variables declaration//GEN-END:variables
}
