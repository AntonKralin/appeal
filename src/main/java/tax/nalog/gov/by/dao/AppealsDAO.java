package tax.nalog.gov.by.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tax.nalog.gov.by.entity.Appeals;
import tax.nalog.gov.by.utils.HibernateSession;
import tax.nalog.gov.by.utils.SpringConfig;

public class AppealsDAO {
	HibernateSession hSession;
	
	public AppealsDAO() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		hSession = (HibernateSession)ctx.getBean("hibernateSession");
		ctx.close();
	}
	
	public Appeals findById(int id) {
		Session session = hSession.getSession();
		return session.get(Appeals.class, id);
	}
	
	public void save(Appeals entity) {
		Session session = hSession.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(entity);
		transaction.commit();
		session.close();
	}
	
	public void update(Appeals entity) {
		Session session = hSession.getSession();
		Transaction tr = session.beginTransaction();
		session.update(entity);
		tr.commit();
		session.close();
	}
	
	public void delete(Appeals entity) {
		Session session = hSession.getSession();
		Transaction tr = session.beginTransaction();
		session.delete(entity);
		tr.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Appeals> findAll(){
		Session session = hSession.getSession();
		List<Appeals> entitys = (List<Appeals>)session.createQuery("From Appeals").list();
		return entitys;
 	}
	
}
