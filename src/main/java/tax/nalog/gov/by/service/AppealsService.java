package tax.nalog.gov.by.service;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
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
	
	public void createEntity(AppearDataForm appearDataForm, Imns imns) {
		Appeals entity = new Appeals();
		ImnsService imnsService = new ImnsService();
		
		entity.setDate(appearDataForm.getDate());
		entity.setDone(appearDataForm.getDone());
		entity.setResult(appearDataForm.getResult());
		entity.setType(appearDataForm.getType());
		entity.setUnit(appearDataForm.getUnit());
		entity.setWhat(appearDataForm.getWhat());
		entity.setWho(appearDataForm.getWho());
		entity.setMessage(appearDataForm.getMessage());
		entity.setImns(appearDataForm.getImns2());
		entity.setId_imns(imnsService.findByID( imns.getId() ));
		
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
		String hql = "FROM Appeals WHERE id_imns = :param ORDER BY id DESC";
		Query<Appeals> query = session.createQuery(hql,Appeals.class).setMaxResults(100);
		query.setParameter("param", imns.getId());
		List<Appeals> list = query.getResultList();
		if (list == null) {
			logger.info("findByImns: null");
			return null;
		}
		Collections.reverse(list);
 		return list;
	}
	
	public List<Appeals> getListReport74(Admins admin, String type, String from, String to){
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		HibernateSession hSession = (HibernateSession)ctx.getBean("hibernateSession");
		ctx.close();
		Session session = hSession.getSession();
		String hql;
		Query<Appeals> query;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		if (admin.getAccess() == 1) {			
			hql = "FROM Appeals where type NOT LIKE :param2 AND (date BETWEEN :param3 AND :param4) ORDER BY id";
			query = session.createQuery(hql,Appeals.class);
		}else {			
			hql = "FROM Appeals where id_imns = :param AND type NOT LIKE :param2 AND (date BETWEEN :param3 AND :param4) ORDER BY id";
			query = session.createQuery(hql,Appeals.class);
			query.setParameter("param", admin.getImns().getId());
			
		}
		
		Date param3 = null;
		Date param4 = null;
		try {
			if (from.equals("")) {
				param3 = dateFormat.parse("2000-01-01");
			}else {
				param3 = dateFormat.parse(from);
			}
			param4 = dateFormat.parse(to);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		
		query.setParameter("param2", type);
		query.setParameter("param3", param3);
		query.setParameter("param4", param4);
		List<Appeals> list = query.getResultList();
		if (list == null) {
			logger.info("findByImnsType: null");
			return null;
		}
 		return list;
 		
	}
	
	public List<Appeals> getListReport7(Admins admin, String type, String from, String to){
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		HibernateSession hSession = (HibernateSession)ctx.getBean("hibernateSession");
		ctx.close();
		Session session = hSession.getSession();
		String hql;
		Query<Appeals> query;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		if (admin.getAccess() == 1) {			
			hql = "FROM Appeals where type LIKE :param2 AND (date BETWEEN :param3 AND :param4)  ORDER BY id";
			query = session.createQuery(hql,Appeals.class);
		}else {			
			hql = "FROM Appeals where id_imns = :param AND type LIKE :param2 AND (date BETWEEN :param3 AND :param4)  ORDER BY id";
			query = session.createQuery(hql,Appeals.class);
			query.setParameter("param", admin.getImns().getId());
		}
		
		Date param3 = null;
		Date param4 = null;
		try {
			if (from.equals("")) {
				param3 = dateFormat.parse("2000-01-01");
			}else {
				param3 = dateFormat.parse(from);
			}
			param4 = dateFormat.parse(to);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		
		query.setParameter("param2", type);
		query.setParameter("param3", param3);
		query.setParameter("param4", param4);
		List<Appeals> list = query.getResultList();
		if (list == null) {
			logger.info("findByImnsType: null");
			return null;
		}
 		return list;
	}
	
}
