/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author smillernl
 */
public class Check {

    private static Medewerker medew;

    public static void setMedew(Medewerker medew) {
	Check.medew = medew;
    }

    public static void resetMedew(Medewerker medew) {
	Check.medew = null;
    }

    static public String cleanLabel(String label) {
	label = label.replaceAll("[^\\\\p{L}\\\\p{Nd}]", "");
	return label;
    }

    static public String cleanPhone(String number) {
	number = number.replaceAll("[^0-9()+]", "");
	return number;
    }

    static public boolean verifyLuggage(String label, String color, String shape, String location, String details, String phoneNr) {
	boolean verified = true;
	if (label == null || color == null || phoneNr == null) {
	    verified = false;
	} else if (label.equals("") || color.equals("") || phoneNr.equals("")) {
	    verified = false;
	}
	return verified;
    }

    public static boolean verifyLogin() {
	try{
	if (medew.getName() == null || medew.getPassword() == null) {
	    return false;
	}else{
	    return true;
	}}catch(NullPointerException e){
	    Debug.printError(e.toString());
	    return false;
	}
    }
}
