package HibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class Demo {
public static void main(String [] args)
{
	Configuration config = new Configuration();
	config.configure();
	
	config.addAnnotatedClass(Employee.class);
	
	SessionFactory sf = config.buildSessionFactory();
	
	Session session = sf.openSession();
	
	session.beginTransaction();
	
	session.persist(new Employee (101,"suarj",7000));

    session.getTransaction().commit();
}
}
