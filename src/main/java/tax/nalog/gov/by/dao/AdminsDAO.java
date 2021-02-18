package tax.nalog.gov.by.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tax.nalog.gov.by.entity.Admins;
import tax.nalog.gov.by.utils.HibernateSession;
import tax.nalog.gov.by.utils.SpringConfig;

public class AdminsDAO {
	HibernateSession hSession;
	
	public AdminsDAO() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		hSession = (HibernateSession)ctx.getBean("hibernateSession");
		ctx.close();
	}
	
	public Admins findById(int id) {
		Session session = hSession.getSession();
		return session.get(Admins.class, id);
	}
	
	public void save(Admins entity) {
		Session session = hSession.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(entity);
		transaction.commit();
		session.close();
	}
	
	public void update(Admins entity) {
		Session session = hSession.getSession();
		Transaction tr = session.beginTransaction();
		session.update(entity);
		tr.commit();
		session.close();
	}
	
	public void delete(Admins entity) {
		Session session = hSession.getSession();
		Transaction tr = session.beginTransaction();
		session.delete(entity);
		tr.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Admins> findAll(){
		Session session = hSession.getSession();
		List<Admins> entitys = (List<Admins>)session.createQuery("From Imns").list();
		return entitys;
 	}
	
}
