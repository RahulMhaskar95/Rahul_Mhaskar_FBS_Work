package demo.repository;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// Package match for Employee entity
import HibernateDemo.Employee;

public class HibernateUtil {
    private static SessionFactory sf;

    static {
        try {
            Configuration config = new Configuration();
            config.configure("hibernate.cfg.xml");
            
            config.addAnnotatedClass(Employee.class);
            
            sf = config.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sf;
    }
}