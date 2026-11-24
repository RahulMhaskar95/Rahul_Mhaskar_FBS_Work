package demo.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;

import HibernateDemo.Employee;

public class HibrenateDAO {

    public void saveEmployee(Employee emp) {
        
       
        if (emp.getName() != null) {
            String dashedName = emp.getName().trim().replaceAll("\\s+", "-");
            emp.setName(dashedName);
        }

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            

            session.persist(emp);
            
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}