/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author ChrisvanderHeijden
 */
public class Passenger {
    private String label;
    private String color;
    private String shape;
    private String name;
    private String surname;
    private String adres;
    private String postalCode;
    private String city;
    private String residentAdres;
    private String residentPostalCode;
    private String residentCity;
    private String details;
    private String phoneNr;

    public Passenger() {
    }

    public Passenger(String label, String color, String shape, String name, String surname, String adres, String postalCode, String city, String residentAdres, String residentPostalCode, String residentCity, String details, String phoneNr) {
        this.label = label;
        this.color = color;
        this.shape = shape;
        this.name = name;
        this.surname = surname;
        this.adres = adres;
        this.postalCode = postalCode;
        this.city = city;
        this.residentAdres = residentAdres;
        this.residentPostalCode = residentPostalCode;
        this.residentCity = residentCity;
        this.details = details;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getResidentAdres() {
        return residentAdres;
    }

    public void setResidentAdres(String residentAdres) {
        this.residentAdres = residentAdres;
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    @Override
    public String toString() {
        return "Passenger{" + "label=" + label + ", color=" + color + ", shape=" + shape + ", name=" + name + ", surname=" + surname + ", adres=" + adres + ", postalCode=" + postalCode + ", city=" + city + ", residentAdres=" + residentAdres + ", residentPostalCode=" + residentPostalCode + ", residentCity=" + residentCity + ", details=" + details + ", phoneNr=" + phoneNr + '}';
    }

    
    
}
