package models;

import java.awt.Color;
import java.sql.SQLException;
import java.util.Date;

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
    private String phoneNumber;

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

    private int handlerID;
    private Date addDate;
    private Date resolveDate;

    /**
     * Create a new case
     */
    public Case() {
    }

    /**
     * Create a new case based on the input
     * @param label
     * @param name
     * @param surName
     * @param emailAdress
     * @param phoneNumber
     * @param homeAddress
     * @param homePostalCode
     * @param homeCity
     * @param residentAddress
     * @param residentPostalCode
     * @param residentCity
     * @param color
     * @param shape
     * @param aditionalDetails
     * @param storageLocation
     * @param handler
     * @param addDate
     * @param resolveDate 
     */
    public Case(String label, String name, String surName, String emailAdress, String phoneNumber, String homeAddress, String homePostalCode, String homeCity, String residentAddress, String residentPostalCode, String residentCity, String color, String shape, String aditionalDetails, String storageLocation, int handler, Date addDate, Date resolveDate) {
        this.label = label;
        this.name = name;
        this.surName = surName;
        this.emailAdress = emailAdress;
        this.phoneNumber = phoneNumber;
        this.homeAddress = homeAddress;
        this.homePostalCode = homePostalCode;
        this.homeCity = homeCity;
        this.residentAddress = residentAddress;
        this.residentPostalCode = residentPostalCode;
        this.residentCity = residentCity;
        this.color = color;
        this.shape = shape;
        this.aditionalDetails = aditionalDetails;
        this.storageLocation = storageLocation;
        this.handlerID = handler;
        this.addDate = addDate;
        this.resolveDate = resolveDate;
    }

    /**
     * Get the status
     *
     * @return the status of the case
     */
    public Color getStatus() {
        if (this.getName() == null) {
        }
        return Color.RED;
    }

    /**
     * Get the label
     *
     * @return the label of the case
     */
    public String getLabel() {
        return label;
    }

    /**
     * Set the label of the case
     *
     * @param label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Get the name
     *
     * @return name set in the case
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name associated with the case
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get the surname of the client
     *
     * @return
     */
    public String getSurName() {
        return surName;
    }

    /**
     * Set the surname
     *
     * @param surName
     */
    public void setSurName(String surName) {
        this.surName = surName;
    }

    /**
     * Get the home address
     *
     * @return
     */
    public String getHomeAddress() {
        return homeAddress;
    }

    /**
     * Set the home address
     *
     * @param homeAddress
     */
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    /**
     * get the postal code of the home address
     *
     * @return
     */
    public String getHomePostalCode() {
        return homePostalCode;
    }

    /**
     * Set the postal code of the home address
     *
     * @param homePostalCode
     */
    public void setHomePostalCode(String homePostalCode) {
        this.homePostalCode = homePostalCode;
    }

    /**
     * Get the city of the home
     *
     * @return
     */
    public String getHomeCity() {
        return homeCity;
    }

    /**
     * Set the city of the home
     *
     * @param homeCity
     */
    public void setHomeCity(String homeCity) {
        this.homeCity = homeCity;
    }

    /**
     * Get address at the destination
     *
     * @return
     */
    public String getResidentAddress() {
        return residentAddress;
    }

    /**
     * Set the address at the destination
     *
     * @param residentAddress
     */
    public void setResidentAddress(String residentAddress) {
        this.residentAddress = residentAddress;
    }

    /**
     * Get the postal code at the destination
     *
     * @return
     */
    public String getResidentPostalCode() {
        return residentPostalCode;
    }

    /**
     * Set the postal code at the destination
     *
     * @param residentPostalCode
     */
    public void setResidentPostalCode(String residentPostalCode) {
        this.residentPostalCode = residentPostalCode;
    }

    /**
     * Get the city of the destination
     *
     * @return
     */
    public String getResidentCity() {
        return residentCity;
    }

    /**
     * Set the city of the destination
     *
     * @param residentCity
     */
    public void setResidentCity(String residentCity) {
        this.residentCity = residentCity;
    }

    /**
     * Get the shape of the luggage
     *
     * @return
     */
    public String getShape() {
        return shape;
    }

    /**
     * Set the shape of the luggage
     *
     * @param shape
     */
    public void setShape(String shape) {
        this.shape = shape;
    }

    /**
     * Get the additional details
     *
     * @return
     */
    public String getAditionalDetails() {
        return aditionalDetails;
    }

    /**
     * Set the additional details
     *
     * @param aditionalDetails
     */
    public void setAditionalDetails(String aditionalDetails) {
        this.aditionalDetails = aditionalDetails;
    }

    /**
     * Get the storage location
     *
     * @return
     */
    public String getStorageLocation() {
        return storageLocation;
    }

    /**
     * Set the storage Location
     *
     * @param storageLocation
     */
    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }

    /**
     * Get the handler of the luggage
     *
     * @return
     */
    public String getHandler() {
        String handler;
        UserDAO dbMedewerker = new UserDAO();
        User dBhandler;
        try {
            dBhandler = dbMedewerker.getMedewerkerById(this.handlerID);
            handler = dBhandler.getName();
        } catch (SQLException e) {
            handler = "John Doe (No name found)";
            Debug.printError(e.toString());
        }
        return handler;
    }

    /**
     * Set the handler of the luggage
     *
     * @param handlerID
     */
    public void setHandler(int handlerID) {
        this.handlerID = handlerID;
    }

    /**
     * Get the add-date
     *
     * @return
     */
    public Date getAddDate() {
        return addDate;
    }

    /**
     * Set the add-date
     *
     * @param addDate
     */
    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    /**
     * Get the resolve date
     *
     * @return
     */
    public Date getResolveDate() {
        return resolveDate;
    }

    /**
     * Set the resolve date
     *
     * @param resolveDate
     */
    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    /**
     * Get the email address
     *
     * @return
     */
    public String getEmailAdress() {
        return emailAdress;
    }

    /**
     * Set the email address
     *
     * @param emailAdress
     */
    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    /**
     * get the color of the case
     *
     * @return
     */
    public String getColor() {
        return color;
    }

    /**
     * Set the color of the case
     *
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Set the phone number to a value
     *
     * @param phoneNr
     */
    public void setPhoneNumber(String phoneNr) {
        this.phoneNumber = phoneNr;
    }

    /**
     * Get the phone number
     *
     * @return phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * parse the object to a string
     *
     * @return
     */
    @Override
    public String toString() {
        return "Case{" + "status=" + status + ", label=" + label + ", name=" + name + ", surName=" + surName + ", homeAddress=" + homeAddress + ", homePostalCode=" + homePostalCode + ", homeCity=" + homeCity + ", residentAddress=" + residentAddress + ", residentPostalCode=" + residentPostalCode + ", residentCity=" + residentCity + ", color=" + color + ", shape=" + shape + ", aditionalDetails=" + aditionalDetails + ", storageLocation=" + storageLocation + ", handler=" + getHandler() + ", addDate=" + addDate + ", resolveDate=" + resolveDate + '}';
    }

}
