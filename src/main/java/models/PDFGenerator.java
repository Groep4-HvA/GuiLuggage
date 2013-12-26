package models;

import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 *
 * @author breud
 */
public class PDFGenerator {

    public static int stringWidth(String s, PDFont font, double fontSize) {
        try {
            return (int) (font.getStringWidth(s) * fontSize / 1000) + 1;
        } catch (IOException ex) {
            // ignore, but return 0
            return 0;
        }
    }
    
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    Date today = Calendar.getInstance().getTime();        
    String date = df.format(today);
    
    
    
    PDDocument document;
    PDPageContentStream contentStream;
    PDFont font = PDType1Font.HELVETICA_BOLD;

    public PDFGenerator() {
        try {
            // Create a document and add a page to it
            this.document = new PDDocument();
            PDPage page = new PDPage();
            this.document.addPage(page);

            // Start a new content stream which will "hold" the to be created content
            this.contentStream = new PDPageContentStream(document, page);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void generate(String label, String color, String shape, String name, String surname, String adres, String postalCode, String city, String residentAdres, String residentPostalCode, String residentCity, String details, int handlerId, String phoneNr){
        try {
           
            contentStream.beginText();
            
            contentStream.setFont(font, 12);
            contentStream.moveTextPositionByAmount(100, 700);
            contentStream.drawString(date);
            contentStream.moveTextPositionByAmount(0, -40);
            
            contentStream.drawString("Labelnumber: ");
            contentStream.drawString(label);
            contentStream.moveTextPositionByAmount(0, -40);
            
            contentStream.drawString("Color: ");
            contentStream.drawString(color);
            contentStream.moveTextPositionByAmount(0, -20);
            contentStream.drawString("Shape: ");
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
            
            
            contentStream.endText();
            contentStream.close();
        
        } catch (IOException e) {
            Debug.printError(e.toString());
        } 
    }

    public void generate(String pending, String resolved, String total, String dateString, String dateString2, String pendingByDate, String resolvedByDate, String totalByDate) {
        try {
            // See http://pdfbox.apache.org/cookbook/documentcreation.html
            // See http://pdfbox.apache.org/docs/1.8.2/javadocs/index.html?overview-summary.html
            // Tip: Use google
            // TODO: generate the pdf
            contentStream.addRect(20f, 20f, 20f, 20f);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.moveTextPositionByAmount(100, 700);
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
            contentStream.drawString("From: " +dateString+ " till "+ dateString2);
            
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

    public void save(String filename){
        String location = System.getProperty("user.home")+File.separator+"Documents"+File.separator+filename+".pdf";
        OutputStream output=null;
	try {
	    output = new FileOutputStream(location);
	} catch (FileNotFoundException e) {
	    Debug.printError(e.toString());
	}
        System.out.println(location);
        try {
            // Make sure that the content stream is closed:
            this.contentStream.close();
            // Save the results and ensure that the document is properly closed:
            this.document.save(output);
            this.document.close();
        } catch (IOException e) {
            Debug.printError(e.toString());
        } catch (COSVisitorException e) {
            Debug.printError(e.toString());
        }
	try {
	    output.close();
	} catch (IOException e) {
	    Debug.printError(e.toString());
	}
    }

    public void print() {
	try {
	    this.contentStream.close();
	    this.document.print();
	    this.document.close();
	} catch (PrinterException e) {
	    Debug.printError(e.toString());
	} catch (IOException e) {
	    Debug.printError(e.toString());
	}
    }
}