package tax.nalog.gov.by.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tax.nalog.gov.by.entity.Departments;
import tax.nalog.gov.by.utils.HibernateSession;
import tax.nalog.gov.by.utils.SpringConfig;

public class DepartmentDAO {
	
	HibernateSession hSession;
	
	public DepartmentDAO() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		hSession = (HibernateSession)ctx.getBean("hibernateSession");
		ctx.close();
	}
	
	public Departments findById(int id) {
		Session session = hSession.getSession();
		return session.get(Departments.class, id);
	}
	
	public void save(Departments entity) {
		Session session = hSession.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(entity);
		transaction.commit();
		session.close();
	}
	
	public void update(Departments entity) {
		Session session = hSession.getSession();
		Transaction tr = session.beginTransaction();
		session.update(entity);
		tr.commit();
		session.close();
	}
	
	public void delete(Departments entity) {
		Session session = hSession.getSession();
		Transaction tr = session.beginTransaction();
		session.delete(entity);
		tr.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Departments> findAll(){
		Session session = hSession.getSession();
		List<Departments> entitys = (List<Departments>)session.createQuery("From Departments").list();
		return entitys;
 	}
	
}
