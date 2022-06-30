package tax.nalog.gov.by.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateSession {
	private SessionFactory sessionFactory;
	
	public HibernateSession() {
		HibernateUtil hutil = new HibernateUtil();
		sessionFactory = hutil.getMySQLSessionFactory();
	}
	
	public Session getSession() {
		return sessionFactory.openSession();
	}
}