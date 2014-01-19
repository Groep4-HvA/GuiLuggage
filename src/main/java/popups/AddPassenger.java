package popups;

import java.sql.SQLException;
import javax.swing.JOptionPane;
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
    private final java.util.ResourceBundle BUNDLE = java.util.ResourceBundle.getBundle("Bundle");

    /**
     * Creates new form AddPassenger
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

        pdfButton.setText(bundle.getString("AddPassenger.pdfButton.text")); // NOI18N
        pdfButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfButtonActionPerformed(evt);
            }
        });

        emailAdressLabel.setText(bundle.getString("AddPassenger.emailAdressLabel.text")); // NOI18N

        emailAdress.setText(bundle.getString("AddPassenger.emailAdress.text")); // NOI18N

        requiredFields.setText(bundle.getString("AddPassenger.requiredFields.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(aditionalDetailsLabel)
                                    .addComponent(postalCodeRLabel)
                                    .addComponent(addressRLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(requiredFields))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(pdfButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(detailsTextfield, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rPostalCodeTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cityRLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(rCityTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(residentAdresTextfield)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(colorLabel)
                                    .addComponent(lLabelLabel)
                                    .addComponent(shapeLabel)
                                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(phoneNrLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(emailAdressLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(colorTextfield, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(shapeTextfield, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelTextfield)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(nameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(surNameLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(surnameTextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE))
                                    .addComponent(phoneNrText)
                                    .addComponent(emailAdress)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(postalCodeHLabel)
                                    .addComponent(addressHLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cityHLabel)
                                .addGap(18, 18, 18)
                                .addComponent(cityTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(hAddressLabel)
                                .addGap(315, 315, 315))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(residentAddressLabel)
                                .addGap(301, 301, 301))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(homeSeparator)
                    .addComponent(residentSeparator)
                    .addComponent(adresTextfield)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(postalCodeTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lLabelLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(colorTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(colorLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shapeTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shapeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(surnameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(surNameLabel))
                    .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneNrLabel)
                    .addComponent(phoneNrText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailAdressLabel)
                    .addComponent(emailAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(hAddressLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(homeSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adresTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressHLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(postalCodeTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cityHLabel)
                    .addComponent(cityTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(postalCodeHLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(residentAddressLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(residentSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(printButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(requiredFields)
                        .addComponent(pdfButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cancelButton)
                        .addComponent(saveButton)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Print the data from the DB
     * @param evt 
     */
    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed

        pdf = new PDFGenerator();
        pdf.generate(label, color, shape, name, surname, adres, postalCode, city, residentAdres, residentPostalCode, residentCity, details, handlerId, phoneNr, email);
        pdf.print();
    }//GEN-LAST:event_printButtonActionPerformed

    /**
     * save the fields to variables and the variables to the DB
     * @param evt 
     */
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        Passenger newPassenger;

        label = Check.cleanAlphaNumeriek(labelTextfield.getText());
        color = Check.cleanAlpha(colorTextfield.getText());
        shape = shapeTextfield.getText();
        name = Check.cleanAlpha(nameTextfield.getText());
        surname = Check.cleanAlpha(surnameTextfield.getText());
        postalCode = Check.cleanAlphaNumeriek(postalCodeTextfield.getText());
        adres = Check.cleanAlphaNumeriek(adresTextfield.getText());
        city = Check.cleanAlpha(cityTextfield.getText());
        residentAdres = Check.cleanAlphaNumeriek(residentAdresTextfield.getText());
        residentPostalCode = Check.cleanAlphaNumeriek(rPostalCodeTextfield.getText());
        residentCity = Check.cleanAlpha(rCityTextfield.getText());
        details = detailsTextfield.getText();
        phoneNr = Check.cleanPhone(phoneNrText.getText());
        email = emailAdress.getText();
        String footer = String.format(BUNDLE.getString("ConfirmFooter"), BUNDLE.getString("Passenger")).toLowerCase();
        String message = BUNDLE.getString("ConfirmHead") + "\n"
                + BUNDLE.getString("AddPassenger.lLabelLabel.text") + " = " + label + "\n"
                + BUNDLE.getString("AddPassenger.colorLabel.text") + " = " + color + "\n"
                + BUNDLE.getString("AddPassenger.shapeLabel.text") + " = " + shape + "\n"
                + BUNDLE.getString("AddPassenger.nameLabel.text") + " = " + name + "\n"
                + BUNDLE.getString("AddPassenger.surNameLabel.text") + " = " + surname + "\n"
                + BUNDLE.getString("AddPassenger.addressHLabel.text") + " = " + adres + "\n"
                + BUNDLE.getString("AddPassenger.postalCodeHLabel.text") + " = " + postalCode + "\n"
                + BUNDLE.getString("AddPassenger.cityHLabel.text") + " = " + city + "\n"
                + BUNDLE.getString("AddPassenger.addressRLabel.text") + " = " + residentAdres + "\n"
                + BUNDLE.getString("AddPassenger.postalCodeRLabel.text") + " = " + residentPostalCode + "\n"
                + BUNDLE.getString("AddPassenger.cityRLabel.text") + " = " + residentCity + "\n"
                + BUNDLE.getString("AddPassenger.phoneNrLabel.text") + " = " + phoneNr + "\n"
                + BUNDLE.getString("AddPassenger.emailAdressLabel.text") + " = " + email + "\n"
                + BUNDLE.getString("AddPassenger.aditionalDetailsLabel.text") + " = " + details + "\n\n"
                + footer;
        int selectedOption = JOptionPane.showConfirmDialog(null,
                message,
                BUNDLE.getString("Confirm"),
                JOptionPane.YES_NO_OPTION);
        if (Check.verifyPassenger(label, color, shape, name, surname, adres, postalCode, city, residentAdres, residentPostalCode, residentCity, details, phoneNr, email)&&selectedOption == JOptionPane.YES_OPTION) {
            newPassenger = new Passenger(label, color, shape, name, surname, adres, postalCode, city, residentAdres, residentPostalCode, residentCity, details, phoneNr, email);
            PassengerDAO test = new PassengerDAO();
            try {
                test.create(newPassenger, handlerId);
            } catch (SQLException e) {
                Debug.printError(e.toString());
            }
            dispose();
        } else {
            JOptionPane.showMessageDialog(null,
                    "Your input was invalid. The label, name, surname, adres, postalcode, city and phone number can not be empty",
                    "Input error - empty",
                    JOptionPane.ERROR_MESSAGE);}
    }//GEN-LAST:event_saveButtonActionPerformed

    /**
     * Exit the form
     * @param evt 
     */
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * Save a PDF file with the current data
     * @param evt 
     */
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
