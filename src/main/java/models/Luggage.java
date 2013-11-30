/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

    public Luggage(String label, String color, String shape, String location, String details) {
        this.label = label;
        this.color = color;
        this.shape = shape;
        this.location = location;
        this.details = details;
    }

    Luggage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        return "Luggage{" + "label=" + label + ", color=" + color + ", shape=" + shape + ", location=" + location + ", details=" + details + '}';
    }
    
}