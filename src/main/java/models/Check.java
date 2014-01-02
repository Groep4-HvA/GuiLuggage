package models;

/**
 * The checks for variables or being logged in
 * @author smillernl
 */
public class Check {

    private static Medewerker medew;
    /**
     * log in (set the variable)
     * @param medew 
     */
    public static void setMedew(Medewerker medew) {
        Check.medew = medew;
    }
    /**
     * log out (clear the variable)
     * @param medew 
     */
    public static void resetMedew(Medewerker medew) {
        Check.medew = null;
    }

    /**
     * Clean up the label
     * @param label
     * @return 
     */
    static public String cleanLabel(String label) {
        label = label.replaceAll("[^\\\\p{L}\\\\p{Nd}]", "");
        return label;
    }
    /**
     * Clean up the phone number
     * @param number
     * @return 
     */
    static public String cleanPhone(String number) {
        number = number.replaceAll("[^0-9()+]", "");
        return number;
    }
    /**
     * Check of the data in luggage is valid
     * @param label
     * @param color
     * @param shape
     * @param location
     * @param details
     * @param phoneNr
     * @return if parameters are valid
     */
    static public boolean verifyLuggage(String label, String color, String shape, String location, String details, String phoneNr) {
        boolean verified = true;
        if (label == null || color == null || phoneNr == null) {
            verified = false;
        } else if (label.equals("") || color.equals("") || phoneNr.equals("")) {
            verified = false;
        }
        return verified;
    }

    /**
     * Verify if there was ever someone logged in
     * @return loggedIn
     */
    public static boolean verifyLogin() {
        try {
            return medew.getName() != null && medew.getPassword() != null;
        } catch (NullPointerException e) {
            Debug.printError(e.toString());
            return false;
        }
    }
}
