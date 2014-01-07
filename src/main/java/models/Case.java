package models;

import java.awt.Color;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author sean
 */
public class Case {
    private String status;
    
    private String label;
    private String name;
    private String surName;
    private String emailAdress;
    
    private String homeAddress;
    private String homePostalCode;
    private String homeCity;
    
    private String residentAddress;
    private String residentPostalCode;
    private String residentCity;
    
    private String color;
    private String shape;
    private String aditionalDetails;
    private String storageLocation;
    
    
    private String handler;
    private Date addDate;
    private Date resolveDate;

    public Case() {
    }
    /**
     * Get the status
     * @return the status of the case
     */
    public Color getStatus(){
        if(this.getName()==null){}
        return Color.RED;
    }
    
    /**
     * Get the label
     * @return the label of the case
     */
    public String getLabel() {
        return label;
    }

    /**
     * Set the label of the case
     * @param label 
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Get the name
     * @return name set in the case
     */
    public String getName() {
        return name;
    }
    /**
     * Set the name associated with the case
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get the surname of the client
     * @return 
     */
    public String getSurName() {
        return surName;
    }

    /**
     * Set the surname
     * @param surName 
     */
    public void setSurName(String surName) {
        this.surName = surName;
    }

    /**
     * Get the home address
     * @return 
     */
    public String getHomeAddress() {
        return homeAddress;
    }

    /**
     * Set the home address
     * @param homeAddress 
     */
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    /**
     * get the postal code of the home address
     * @return 
     */
    public String getHomePostalCode() {
        return homePostalCode;
    }

    /**
     * Set the postal code of the home address
     * @param homePostalCode 
     */
    public void setHomePostalCode(String homePostalCode) {
        this.homePostalCode = homePostalCode;
    }

    /**
     * Get the city of the home
     * @return 
     */
    public String getHomeCity() {
        return homeCity;
    }

    /**
     * Set the city of the home
     * @param homeCity 
     */
    public void setHomeCity(String homeCity) {
        this.homeCity = homeCity;
    }

    /**
     * Get address at the destination
     * @return 
     */
    public String getResidentAddress() {
        return residentAddress;
    }

    /**
     * Set the address at the destination
     * @param residentAddress 
     */
    public void setResidentAddress(String residentAddress) {
        this.residentAddress = residentAddress;
    }

    /**
     * Get the postal code at the destination
     * @return 
     */
    public String getResidentPostalCode() {
        return residentPostalCode;
    }

    /**
     * Set the postal code at the destination
     * @param residentPostalCode 
     */
    public void setResidentPostalCode(String residentPostalCode) {
        this.residentPostalCode = residentPostalCode;
    }

    /**
     * Get the city of the destination
     * @return 
     */
    public String getResidentCity() {
        return residentCity;
    }

    /**
     * Set the city of the destination
     * @param residentCity 
     */
    public void setResidentCity(String residentCity) {
        this.residentCity = residentCity;
    }

    /**
     * Get the shape of the luggage
     * @return 
     */
    public String getShape() {
        return shape;
    }

    /**
     * Set the shape of the luggage
     * @param shape 
     */
    public void setShape(String shape) {
        this.shape = shape;
    }

    /**
     * Get the additional details
     * @return 
     */
    public String getAditionalDetails() {
        return aditionalDetails;
    }

    /**
     * Set the additional details
     * @param aditionalDetails 
     */
    public void setAditionalDetails(String aditionalDetails) {
        this.aditionalDetails = aditionalDetails;
    }

    /**
     * Get the storage location
     * @return 
     */
    public String getStorageLocation() {
        return storageLocation;
    }

    /**
     * Set the storage Location
     * @param storageLocation 
     */
    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }

    /**
     * Get the handler of the luggage
     * @return 
     */
    public String getHandler() {
        return handler;
    }

    /**
     * Set the handler of the luggage
     * @param handlerID 
     */
    public void setHandler(int handlerID) {
        MedewerkerDAO dbMedewerker = new MedewerkerDAO();
        Medewerker dBhandler = null;
        try {
            dBhandler = dbMedewerker.getMedewerkerById(handlerID);
        } catch (SQLException e) {
            Debug.printError(e.toString());
        }
        this.handler = dBhandler.getName();
    }

    /**
     * Get the add-date
     * @return 
     */
    public Date getAddDate() {
        return addDate;
    }

    /**
     * Set the add-date
     * @param addDate 
     */
    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    /**
     * Get the resolve date
     * @return 
     */
    public Date getResolveDate() {
        return resolveDate;
    }

    /**
     * Set the resolve date
     * @param resolveDate 
     */
    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    /**
     * Get the email address
     * @return 
     */
    public String getEmailAdress() {
        return emailAdress;
    }

    /**
     * Set the email address
     * @param emailAdress 
     */
    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    /**
     * get the color of the case
     * @return 
     */
    public String getColor() {
        return color;
    }

    /**
     * Set the color of the case
     * @param color 
     */
    public void setColor(String color) {
        this.color = color;
    }
    
    

    /**
     * parse the object to a string
     * @return 
     */
    @Override
    public String toString() {
        return "Case{" + "status=" + status + ", label=" + label + ", name=" + name + ", surName=" + surName + ", homeAddress=" + homeAddress + ", homePostalCode=" + homePostalCode + ", homeCity=" + homeCity + ", residentAddress=" + residentAddress + ", residentPostalCode=" + residentPostalCode + ", residentCity=" + residentCity + ", color=" + color + ", shape=" + shape + ", aditionalDetails=" + aditionalDetails + ", storageLocation=" + storageLocation + ", handler=" + handler + ", addDate=" + addDate + ", resolveDate=" + resolveDate + '}';
    }
    
}
