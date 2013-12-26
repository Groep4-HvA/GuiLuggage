/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.*;

/**
 *
 * @author Sean
 */
public class printJob implements Printable {

    public printJob() {
    }

    public void start() {
	PrinterJob job = PrinterJob.getPrinterJob(); //Get the printer's job list
	job.setPrintable(this); //We print with this class (btnPrintAction, which implements Printable)
	if (job.printDialog() == true) { //If we clicked OK in the print dialog
	    try {
		job.print();
	    } catch (PrinterException ex) {
		//It did not work (PrinterException thrown), so add any error handling routines.
	    }
	}
    }

    @Override
    public int print(Graphics gx, PageFormat pf, int page) throws PrinterException {
	if (page > 0) {
	    return NO_SUCH_PAGE;
	} //Only one page
	Graphics2D g = (Graphics2D) gx; //Cast to Graphics2D object
	g.translate(pf.getImageableX(), pf.getImageableY()); //Match origins to imageable area
	g.drawString("Hello world", 100, 100); //Print Hello World at offset (100, 100)
	return PAGE_EXISTS; //Page exists (offsets start at zero!)
    }
}
