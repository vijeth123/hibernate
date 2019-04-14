package com.vijeth.collection.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

public class Address implements Serializable{

    private static final long serialVersionUID = 1L;

    private Integer doorNumber;
    private String street;
    private String pinCode;

    public Integer getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(Integer doorNumber) {
        this.doorNumber = doorNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "doorNumber=" + doorNumber +
                ", street='" + street + '\'' +
                ", pinCode='" + pinCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(doorNumber, address.doorNumber) &&
                Objects.equals(street, address.street) &&
                Objects.equals(pinCode, address.pinCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doorNumber, street, pinCode);
    }
}
