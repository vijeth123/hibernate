package com.vijeth.collection.model;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@org.hibernate.annotations.Entity(optimisticLock = OptimisticLockType.ALL, dynamicUpdate = true)
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "EMPLOYEE_ID", unique = true, nullable = false, length = 100)
    private Integer id;

    @Column(name = "EMAIL", unique = true, nullable = false, length = 100)
    private String email;

    @Column(name = "FIRST_NAME", unique = false, nullable = false, length = 100)
    private String firstName;

    @Column(name = "LAST_NAME", unique = false, nullable = false, length = 100)
    private String lastName;

    @Column(name = "JOINING_DATE")
    private LocalDate joiningDate;

    @ElementCollection
    @JoinTable(name = "EMPLOYEE_ADDRESS", joinColumns = @JoinColumn(name = "EMP_ID"))
    @GenericGenerator(name = "hilo-gen", strategy = "hilo")
    @CollectionId(columns = @Column(name = "ADDRESS_ID"), type = @Type(type = "long"), generator = "hilo-gen")
    private Collection<Address> listOfAddresses = new ArrayList<>();

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

    public Integer getId() {
        return id;
    }

    public Collection<Address> getListOfAddresses() {
        return listOfAddresses;
    }

    public void setListOfAddresses(List<Address> listOfAddresses) {
        this.listOfAddresses = listOfAddresses;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", joiningDate=" + joiningDate +
                ", listOfAddresses=" + listOfAddresses +
                '}';
    }
}
