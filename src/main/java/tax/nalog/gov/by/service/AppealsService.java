package tax.nalog.gov.by.service;

import java.util.List;

import tax.nalog.gov.by.dao.AppealsDAO;
import tax.nalog.gov.by.entity.Appeals;

public class AppealsService {
	private static AppealsDAO dao;
	
	public AppealsService() {
		dao = new AppealsDAO();
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
	
}
