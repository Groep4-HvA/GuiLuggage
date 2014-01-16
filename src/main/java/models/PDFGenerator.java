package models;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.nio.file.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.xobject.*;

/**
 *
 * @author breud
 */
public class PDFGenerator {

    private final DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    private final Date today = Calendar.getInstance().getTime();
    private final String date = df.format(today);
    private PDXObjectImage correndonLogo;
    private PDXObjectImage banner;
    private PDXObjectImage grafiek;
    private PDDocument document;
    private PDPageContentStream contentStream;
    private final PDFont font = PDType1Font.HELVETICA;
    private PDPage page = null;

    /**
     * Start a new PDF Generator object
     */
    public PDFGenerator() {
        try {
            // Create a document and add a page to it
            this.document = new PDDocument();
            page = new PDPage();
            this.document.addPage(page);

            correndonLogo = new PDJpeg(document, getClass().getResourceAsStream("/img/logo.jpg"));
            banner = new PDJpeg(document, getClass().getResourceAsStream("/img/help.jpg"));
        } catch (IOException e) {
            Debug.printError(e.toString());
        }
    }

    /**
     * Find the width of the string
     *
     * @param s
     * @param font
     * @param fontSize
     * @return
     */
    public static int stringWidth(String s, PDFont font, double fontSize) {
        try {
            return (int) (font.getStringWidth(s) * fontSize / 1000) + 1;
        } catch (IOException e) {
            Debug.printError(e.toString());
            return 0;
        }
    }

    public void setChart(File chart) {
        try {
            if (chart.exists()) {
                BufferedImage img = ImageIO.read(chart);
                ColorModel imgModel = img.getColorModel();
                Debug.printError(imgModel.toString());
                grafiek = new PDJpeg(document, img);
            } else {
                grafiek = new PDJpeg(document, getClass().getResourceAsStream("/img/no-graph.jpg"));
            }
        } catch (IOException e) {
            Debug.printError(e.toString());
        }
    }

    /**
     * User - Generate a PDF with the following information
     *
     * @param label
     * @param color
     * @param shape
     * @param name
     * @param surname
     * @param adres
     * @param postalCode
     * @param city
     * @param residentAdres
     * @param residentPostalCode
     * @param residentCity
     * @param details
     * @param handlerId
     * @param phoneNr
     * @param email
     */
    public void generate(String label, String color, String shape, String name, String surname, String adres, String postalCode, String city, String residentAdres, String residentPostalCode, String residentCity, String details, int handlerId, String phoneNr, String email) {
        try {
            // Start a new content stream which will "hold" the to be created content
            this.contentStream = new PDPageContentStream(document, page);
            
            contentStream.drawImage(banner, 0, 360);
            contentStream.drawImage(correndonLogo, 20, 50);

            contentStream.beginText();

            contentStream.setFont(font, 12);
            contentStream.moveTextPositionByAmount(220, 550);
            contentStream.drawString(date);
            contentStream.moveTextPositionByAmount(0, -40);

            contentStream.drawString("Labelnumber: ");
            contentStream.drawString(label);
            contentStream.moveTextPositionByAmount(0, -40);

            contentStream.drawString("Color: ");
            contentStream.drawString(color);
            contentStream.moveTextPositionByAmount(0, -20);
            contentStream.drawString("Brand: ");
            contentStream.drawString(shape);
            contentStream.moveTextPositionByAmount(0, -20);
            contentStream.drawString("Name: ");
            contentStream.drawString(name);
            //contentStream.moveTextPositionByAmount(0, -20);
            contentStream.drawString("\t\t    Surname: ");
            contentStream.drawString(surname);
            contentStream.moveTextPositionByAmount(0, -40);
            contentStream.drawString("------Home adress------");
            contentStream.moveTextPositionByAmount(0, -20);
            contentStream.drawString("Address: ");
            contentStream.drawString(adres);
            contentStream.moveTextPositionByAmount(0, -20);
            contentStream.drawString("Postalcode: ");
            contentStream.drawString(postalCode);
            contentStream.moveTextPositionByAmount(0, -20);
            contentStream.drawString("City: ");
            contentStream.drawString(city);
            contentStream.moveTextPositionByAmount(0, -40);
            contentStream.drawString("------Resident adress------");
            contentStream.moveTextPositionByAmount(0, -20);
            contentStream.drawString("Resident Address: ");
            contentStream.drawString(residentAdres);
            contentStream.moveTextPositionByAmount(0, -20);
            contentStream.drawString("Postalcode: ");
            contentStream.drawString(residentPostalCode);
            contentStream.moveTextPositionByAmount(0, -20);
            contentStream.drawString("City: ");
            contentStream.drawString(residentCity);
            contentStream.moveTextPositionByAmount(0, -40);
            contentStream.drawString("Additonal Details: ");
            contentStream.drawString(details);
            contentStream.moveTextPositionByAmount(0, -20);
            contentStream.drawString("Phonenumber: ");
            contentStream.drawString(phoneNr);
            contentStream.moveTextPositionByAmount(0, -20);
            contentStream.drawString("email: ");
            contentStream.drawString(email);

            contentStream.endText();
            contentStream.close();

        } catch (IOException e) {
            Debug.printError(e.toString());
        }
    }

    /**
     * Manager - Generate a PDF with the following information
     *
     * @param pending
     * @param resolved
     * @param total
     * @param dateString
     * @param dateString2
     * @param pendingByDate
     * @param resolvedByDate
     * @param totalByDate
     */
    public void generate(String pending, String resolved, String total, String dateString, String dateString2, String pendingByDate, String resolvedByDate, String totalByDate) {
        try {
            // See http://pdfbox.apache.org/cookbook/documentcreation.html
            // See http://pdfbox.apache.org/docs/1.8.2/javadocs/index.html?overview-summary.html
            // Tip: Use google
            // TODO: generate the pdf
            // contentStream.addRect(20f, 20f, 20f, 20f);

            // Start a new content stream which will "hold" the to be created content
            this.contentStream = new PDPageContentStream(document, page);

            contentStream.drawImage(banner, 0, 360);
            contentStream.drawImage(correndonLogo, 20, 50);
            contentStream.drawImage(grafiek, 12, 10);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.moveTextPositionByAmount(240, 550);
            contentStream.drawString(date);

            contentStream.moveTextPositionByAmount(0, -20);
            contentStream.drawString("Total pending: ");
            contentStream.drawString(pending);
            contentStream.moveTextPositionByAmount(0, -20);
            contentStream.drawString("Total resolved: ");
            contentStream.drawString(resolved);
            contentStream.moveTextPositionByAmount(0, -20);
            contentStream.drawString("Total processed: ");
            contentStream.drawString(total);

            contentStream.moveTextPositionByAmount(0, -40);
            contentStream.drawString("From: " + dateString + " till " + dateString2);

            contentStream.moveTextPositionByAmount(0, -20);
            contentStream.drawString("Amount pending: ");
            contentStream.drawString(pendingByDate);
            contentStream.moveTextPositionByAmount(0, -20);
            contentStream.drawString("Amount resolved: ");
            contentStream.drawString(resolvedByDate);
            contentStream.moveTextPositionByAmount(0, -20);
            contentStream.drawString("Amount processed: ");
            contentStream.drawString(totalByDate);

            contentStream.endText();
            contentStream.close();
        } catch (IOException e) {
            Debug.printError(e.toString());
        }

    }

    /**
     * Save the PDF to a file with the specified filename
     *
     * @param filename
     */
    public void save(String filename) {
        String location = System.getProperty("user.home") + File.separator + "Documents" + File.separator + filename + ".pdf";
        OutputStream output;

        System.out.println(location);

        Path path = Paths.get(location);

        if (Files.exists(path)) {
            System.out.println("Dit bestand bestaat al");

            String s;
            s = (String) JOptionPane.showInputDialog("Voer hier nieuwe naam in, laat leeg om te overschrijven");

            //If a string was returned, say so.
            if ((s != null) && (s.length() > 0)) {
                Debug.printError(s);
                location = System.getProperty("user.home") + File.separator + "Documents" + File.separator + s + ".pdf";
            }
        }
        try {
            output = new FileOutputStream(location);

            // Make sure that the content stream is closed:
            this.contentStream.close();

            // Save the results and ensure that the document is properly closed:
            this.document.save(output);
            this.document.close();
            output.close();
        } catch (IOException e) {
            Debug.printError(e.toString());
        } catch (COSVisitorException e) {
            Debug.printError(e.toString());
        }

    }

    /**
     * print the PDF that was generated
     */
    public void print() {
        try {
            PrinterJob job = PrinterJob.getPrinterJob();
            document.print(job);
        } catch (PrinterException e) {
            Debug.printError(e.toString());
        }
    }
}
