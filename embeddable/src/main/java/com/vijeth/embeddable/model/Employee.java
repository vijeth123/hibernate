package com.vijeth.embeddable.model;

import org.hibernate.annotations.OptimisticLockType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@org.hibernate.annotations.Entity(optimisticLock = OptimisticLockType.ALL, dynamicUpdate = true)
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "EMAIL", unique = true, nullable = false, length = 100)
    private String email;

    @Column(name = "FIRST_NAME", unique = false, nullable = false, length = 100)
    private String firstName;

    @Column(name = "LAST_NAME", unique = false, nullable = false, length = 100)
    private String lastName;

    @Column(name = "JOINING_DATE")
    private LocalDate joiningDate;

    @AttributeOverrides({
            @AttributeOverride(name = "doorNumber", column = @Column(name = "HOME_ADDR_DOOR_NO")),
            @AttributeOverride(name = "street", column = @Column(name = "HOME_ADDR_STREET")),
            @AttributeOverride(name = "pinCode", column = @Column(name = "HOME_ADDR_PIN_CODE"))
    })
    @EmbeddedId
    private Address homeAddress;

    @AttributeOverrides({
            @AttributeOverride(name = "doorNumber", column = @Column(name = "OFFICE_ADDR_DOOR_NO")),
            @AttributeOverride(name = "street", column = @Column(name = "OFFICE_ADDR_STREET")),
            @AttributeOverride(name = "pinCode", column = @Column(name = "OFFICE_ADDR_PIN_CODE"))
    })
    private Address officeAddress;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(Address officeAddress) {
        this.officeAddress = officeAddress;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", joiningDate=" + joiningDate +
                ", homeAddress=" + homeAddress +
                ", officeAddress=" + officeAddress +
                '}';
    }
}
