package com.vijeth.hibernate;

import com.vijeth.hibernate.model.Employee;
import com.vijeth.hibernate.util.HibernateUtil;
import org.hibernate.Session;

public class ApplicationMain {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Employee employee = new Employee();
        employee.setEmployeeId(10);
        employee.setEmail("vijeth123@gmail.com");
        employee.setFirstName("Vijeth");
        employee.setLastName("Kumar");

        session.save(employee);
        session.getTransaction().commit();

        HibernateUtil.shutDown();
    }
}
