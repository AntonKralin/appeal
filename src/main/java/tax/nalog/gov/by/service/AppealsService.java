package tax.nalog.gov.by.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tax.nalog.gov.by.dao.AppealsDAO;
import tax.nalog.gov.by.entity.Admins;
import tax.nalog.gov.by.entity.Appeals;
import tax.nalog.gov.by.entity.Imns;
import tax.nalog.gov.by.form.AppearDataForm;
import tax.nalog.gov.by.utils.HibernateSession;
import tax.nalog.gov.by.utils.SpringConfig;

public class AppealsService {
	private static AppealsDAO dao;
	private static final Logger logger = Logger.getLogger(AppealsService.class);
	
	public AppealsService() {
		dao = new AppealsDAO();
	}
	
	public void createEntity(AppearDataForm appearDataForm) {
		Appeals entity = new Appeals();
		ImnsService imnsService = new ImnsService();
		
		entity.setDate(appearDataForm.getDate());
		entity.setDone(appearDataForm.getDone());
		entity.setResult(appearDataForm.getResult());
		entity.setType(appearDataForm.getType());
		entity.setUnit(appearDataForm.getUnit());
		entity.setWhat(appearDataForm.getWhat());
		entity.setWho(appearDataForm.getWho());
		entity.setId_imns(imnsService.findByID(appearDataForm.getImns()));
		
		if (appearDataForm.getId() != 0) {
			entity.setId(appearDataForm.getId());
			dao.update(entity);
		}else {
			dao.save(entity);
		}
		
		
	}
	
	public void save(Appeals entity) {
		dao.save(entity);
	}
	
	public Appeals findByID (int id) {
		return dao.findById(id);
	}
	
	public void update(Appeals entity) {
		dao.update(entity);
	}
	
	public void delete(Appeals entity) {
		dao.delete(entity);
	}
	
	public List<Appeals> findAll(){
		return dao.findAll();
	}
	
	public List<Appeals> getListByImns(Imns imns){
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		HibernateSession hSession = (HibernateSession)ctx.getBean("hibernateSession");
		ctx.close();
		Session session = hSession.getSession();
		String hql = "FROM Appeals where id_imns = :param ORDER BY id";
		Query<Appeals> query = session.createQuery(hql,Appeals.class);
		query.setParameter("param", imns.getId());
		List<Appeals> list = query.getResultList();
		if (list == null) {
			logger.info("findByImns: null");
			return null;
		}
 		return list;
	}
	
	public List<Appeals> getListReport74(Admins admin, String type){
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		HibernateSession hSession = (HibernateSession)ctx.getBean("hibernateSession");
		ctx.close();
		Session session = hSession.getSession();
		String hql;
		Query<Appeals> query;
		
		if (admin.getAccess() == 1) {			
			hql = "FROM Appeals where type= :param2 ORDER BY id";
			query = session.createQuery(hql,Appeals.class);
		}else {			
			hql = "FROM Appeals where id_imns = :param AND type= :param2 ORDER BY id";
			query = session.createQuery(hql,Appeals.class);
			query.setParameter("param", admin.getImns().getId());
		}
		
		query.setParameter("param2", type);
		List<Appeals> list = query.getResultList();
		if (list == null) {
			logger.info("findByImnsType: null");
			return null;
		}
 		return list;
	}
	
}
