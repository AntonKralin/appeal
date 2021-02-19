package tax.nalog.gov.by.service;

import java.util.List;
import tax.nalog.gov.by.dao.ImnsDAO;
import tax.nalog.gov.by.entity.Imns;

public class ImnsSerivce {
	private static ImnsDAO dao;
	
	public ImnsSerivce() {
		dao = new ImnsDAO(); 
	}
	
	public void save(Imns entity) {
		dao.save(entity);
	}
	
	public Imns findByID (int id) {
		return dao.findById(id);
	}
	
	public void update(Imns entity) {
		dao.update(entity);
	}
	
	public void delete(Imns entity) {
		dao.delete(entity);
	}
	
	public List<Imns> findAll(){
		return dao.findAll();
	}
	
}