package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public void generate(String[] months, int[] totalExamsPassed, int[] totalExamsFailed, int[] totalExamsTodo) {
        try {
            // See http://pdfbox.apache.org/cookbook/documentcreation.html
            // See http://pdfbox.apache.org/docs/1.8.2/javadocs/index.html?overview-summary.html
            // Tip: Use google
            // TODO: generate the pdf

            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.moveTextPositionByAmount(100, 700);
            
            for(int i = 0; i < months.length; i++){
            contentStream.drawString(months[i] + "\t\t\t\t" + "\n");
            contentStream.moveTextPositionByAmount(0, -30);
            }
            String res = Arrays.toString(totalExamsPassed);
            for(int i = 0; i < totalExamsPassed.length; i++){
            contentStream.drawString(res);
            }
            
            
            contentStream.endText();
            contentStream.close();
        } catch (IOException ex) {
            Logger.getLogger(PDFGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }



    }

    public void save(String filename) throws FileNotFoundException, IOException {
        String location = System.getProperty("user.home")+File.separator+"Documents"+"/"+filename;
        location = location.replace("\\", "/");
        OutputStream output = new FileOutputStream(location);
        try {
            // Make sure that the content stream is closed:
            this.contentStream.close();
            // Save the results and ensure that the document is properly closed:
            this.document.save(output);
            this.document.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        output.close();
    }

    public static int stringWidth(String s, PDFont font, double fontSize) {
        try {
            return (int) (font.getStringWidth(s) * fontSize / 1000) + 1;
        } catch (IOException ex) {
            // ignore, but return 0
            return 0;
        }
    }
}
