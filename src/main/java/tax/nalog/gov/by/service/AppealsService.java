package tax.nalog.gov.by.service;

import java.util.List;

import tax.nalog.gov.by.dao.AppealsDAO;
import tax.nalog.gov.by.entity.Appeals;
import tax.nalog.gov.by.entity.Imns;
import tax.nalog.gov.by.form.AppearDataForm;

public class AppealsService {
	private static AppealsDAO dao;
	
	public AppealsService() {
		dao = new AppealsDAO();
	}
	
	public void createEntity(AppearDataForm appearDataForm, Imns imns) {
		Appeals entity = new Appeals();
		
		entity.setDate(appearDataForm.getDate());
		entity.setDone(appearDataForm.getDone());
		entity.setResult(appearDataForm.getResult());
		entity.setType(appearDataForm.getType());
		entity.setUnit(appearDataForm.getUnit());
		entity.setWhat(appearDataForm.getWhat());
		entity.setWho(appearDataForm.getWho());
		entity.setId_imns(imns);
		
		dao.save(entity);
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
