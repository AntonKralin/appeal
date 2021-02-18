package tax.nalog.gov.by.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tax.nalog.gov.by.entity.Imns;
import tax.nalog.gov.by.utils.HibernateSession;
import tax.nalog.gov.by.utils.SpringConfig;

public class ImnsDAO {
	HibernateSession hSession;
	
	public ImnsDAO() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		hSession = (HibernateSession)ctx.getBean("hibernateSession");
		ctx.close();
	}
	
	public Imns findById(int id) {
		Session session = hSession.getSession();
		return session.get(Imns.class, id);
	}
	
	public void save(Imns entity) {
		Session session = hSession.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(entity);
		transaction.commit();
		session.close();
	}
	
	public void update(Imns entity) {
		Session session = hSession.getSession();
		Transaction tr = session.beginTransaction();
		session.update(entity);
		tr.commit();
		session.close();
	}
	
	public void delete(Imns entity) {
		Session session = hSession.getSession();
		Transaction tr = session.beginTransaction();
		session.delete(entity);
		tr.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Imns> findAll(){
		Session session = hSession.getSession();
		List<Imns> entitys = (List<Imns>)session.createQuery("From Imns").list();
		return entitys;
 	}
	
}
