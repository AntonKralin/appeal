package tax.nalog.gov.by.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tax.nalog.gov.by.dao.AdminsDAO;
import tax.nalog.gov.by.entity.Admins;
import tax.nalog.gov.by.form.PasswordForm;
import tax.nalog.gov.by.utils.HibernateSession;
import tax.nalog.gov.by.utils.SpringConfig;

public class AdminsService {
	private static AdminsDAO dao;
	private static final Logger logger = Logger.getLogger(PasswordForm.class);
	
	public AdminsService() {
		dao = new AdminsDAO();
	}
	
	public void save(Admins entity) {
		dao.save(entity);
	}
	
	public Admins findByID (int id) {
		return dao.findById(id);
	}
	
	public void update(Admins entity) {
		dao.update(entity);
	}
	
	public void delete(Admins entity) {
		dao.delete(entity);
	}
	
	public Admins findByLogin(String login) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		HibernateSession hSession = (HibernateSession)ctx.getBean("hibernateSession");
		ctx.close();
		Session session = hSession.getSession();
		String hql = "FROM Admins where login = :param";
		Query<Admins> query = session.createQuery(hql,Admins.class);
		query.setParameter("param", login);
		List<Admins> list = query.getResultList();
		if (list == null) {
			logger.info("findByLogin: null");
			return null;
		}
		for(Admins rez : list) {
			return rez;
		}
 		return null;
	}
	
	public List<Admins> findAll(){
		return dao.findAll();
	}
	
}
