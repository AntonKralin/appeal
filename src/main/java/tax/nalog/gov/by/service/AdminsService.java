package tax.nalog.gov.by.service;

import java.util.List;

import tax.nalog.gov.by.dao.AdminsDAO;
import tax.nalog.gov.by.entity.Admins;

public class AdminsService {
	private static AdminsDAO dao;
	
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
	
	public List<Admins> findAll(){
		return dao.findAll();
	}
	
}
