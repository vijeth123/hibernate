package com.vijeth.hello.world;

import com.vijeth.hello.world.model.Employee;
import com.vijeth.load.get.util.HibernateUtil;
import org.hibernate.Session;

import java.time.LocalDate;

public class ApplicationMain {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Employee employee = new Employee();
        employee.setEmail("vijeth123@gmail.com");
        employee.setFirstName("Vijeth");
        employee.setLastName("Kumar");
        employee.setJoiningDate(LocalDate.now());

        session.save(employee);
        session.getTransaction().commit();

        HibernateUtil.shutDown();
    }
}
