package models;

/**
 *
 * @author ChrisvanderHeijden
 */
public class Luggage {
    private String label;
    private String color;
    private String shape;
    private String location;
    private String details;
    private String phoneNr;
    
    /**
     * Create a new luggage object based on parameters
     * @param label
     * @param color
     * @param shape
     * @param location
     * @param details
     * @param phoneNr 
     */
    public Luggage(String label, String color, String shape, String location, String details, String phoneNr) {
        this.label = label;
        this.color = color;
        this.shape = shape;
        this.location = location;
        this.details = details;
        this.phoneNr = phoneNr;
    }

    /**
     * Create a new empty luggage object
     */
    public Luggage() {}

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }
    
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Luggage{" + "label=" + label + ", color=" + color + ", shape=" + shape + ", location=" + location + ", details=" + details + ", phoneNr=" + phoneNr + '}';
    }
    
}