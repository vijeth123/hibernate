package com.vijeth.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.File;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try{
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
            serviceRegistryBuilder.applySettings(configuration.getProperties());
            ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
            return configuration.buildSessionFactory(serviceRegistry);
        }catch (Exception e){
            e.printStackTrace();
            throw new ExceptionInInitializerError("Initial SessionFactory creation failed.");
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutDown(){
        getSessionFactory().close();
    }
}
