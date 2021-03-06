package com.vijeth.collection;

import com.vijeth.collection.model.Address;
import com.vijeth.collection.model.Employee;
import com.vijeth.load.get.util.HibernateUtil;
import org.hibernate.Session;

import java.time.LocalDate;

public class ApplicationMain {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Address homeAddress = new Address();
        homeAddress.setDoorNumber(20);
        homeAddress.setStreet("Sutton Lane");
        homeAddress.setPinCode("SM5 123");

        Address officeAddress = new Address();
        officeAddress.setDoorNumber(50);
        officeAddress.setStreet("High Street");
        officeAddress.setPinCode("MN 123");

        Employee employee = new Employee();
        employee.setEmail("vijeth123@gmail.com");
        employee.setFirstName("Vijeth");
        employee.setLastName("Kumar");
        employee.setJoiningDate(LocalDate.now());
        employee.getListOfAddresses().add(homeAddress);
        employee.getListOfAddresses().add(officeAddress);

        session.save(employee);
        session.getTransaction().commit();

        HibernateUtil.shutDown();
    }
}
