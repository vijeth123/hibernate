package com.vijeth.load.get;

import com.vijeth.load.get.model.Employee;
import com.vijeth.load.get.util.HibernateUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class ApplicationMain {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationMain.class);

    public static void main(String[] args) {
        Session session1 = HibernateUtil.getSessionFactory().openSession();
        session1.beginTransaction();

        Employee employee1 = new Employee();
        employee1.setEmail("vijeth123@gmail.com");
        employee1.setFirstName("Vijeth");
        employee1.setLastName("Kumar");
        employee1.setJoiningDate(LocalDate.now());

        Employee employee2 = new Employee();
        employee2.setEmail("bharath123@gmail.com");
        employee2.setFirstName("Bharath");
        employee2.setLastName("Gowdra");
        employee2.setJoiningDate(LocalDate.of(2019, 04, 04));

        session1.save(employee1);
        session1.save(employee2);

        session1.getTransaction().commit();
        session1.close();

        Session session2 = HibernateUtil.getSessionFactory().openSession();
        Employee emp1 = (Employee) session2.load(Employee.class, 1);
        LOGGER.info("Employee-1 id: {}", emp1.getEmployeeId());
        LOGGER.info("Employee-1 details: {}", emp1);

        Employee emp2 = (Employee) session2.get(Employee.class, 2);
        LOGGER.info("Employee-2 id: {}", emp2.getEmployeeId());
        LOGGER.info("Employee-2 details: {}", emp2);
        session2.close();

        HibernateUtil.shutDown();
    }
}
