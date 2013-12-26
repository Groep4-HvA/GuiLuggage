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

    public Color getStatus(){
        if(this.getName()==null){}
        return Color.RED;
    }
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getHomePostalCode() {
        return homePostalCode;
    }

    public void setHomePostalCode(String homePostalCode) {
        this.homePostalCode = homePostalCode;
    }

    public String getHomeCity() {
        return homeCity;
    }

    public void setHomeCity(String homeCity) {
        this.homeCity = homeCity;
    }

    public String getResidentAddress() {
        return residentAddress;
    }

    public void setResidentAddress(String residentAddress) {
        this.residentAddress = residentAddress;
    }

    public String getResidentPostalCode() {
        return residentPostalCode;
    }

    public void setResidentPostalCode(String residentPostalCode) {
        this.residentPostalCode = residentPostalCode;
    }

    public String getResidentCity() {
        return residentCity;
    }

    public void setResidentCity(String residentCity) {
        this.residentCity = residentCity;
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

    public String getAditionalDetails() {
        return aditionalDetails;
    }

    public void setAditionalDetails(String aditionalDetails) {
        this.aditionalDetails = aditionalDetails;
    }

    public String getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }

    public String getHandler() {
        return handler;
    }

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

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }
    public List<Case> readAll(){
        CaseDao cases = new CaseDao();
        List<Case> list = null;
        try {
            cases.readAll();
        } catch (SQLException e) {
            Debug.printError(e.toString());
        }
        return list;
    }

    @Override
    public String toString() {
        return "Case{" + "status=" + status + ", label=" + label + ", name=" + name + ", surName=" + surName + ", homeAddress=" + homeAddress + ", homePostalCode=" + homePostalCode + ", homeCity=" + homeCity + ", residentAddress=" + residentAddress + ", residentPostalCode=" + residentPostalCode + ", residentCity=" + residentCity + ", color=" + color + ", shape=" + shape + ", aditionalDetails=" + aditionalDetails + ", storageLocation=" + storageLocation + ", handler=" + handler + ", addDate=" + addDate + ", resolveDate=" + resolveDate + '}';
    }
    
}
