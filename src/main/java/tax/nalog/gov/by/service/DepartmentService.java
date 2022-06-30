package tax.nalog.gov.by.service;

import java.util.List;
import java.util.TreeMap;
import tax.nalog.gov.by.entity.Departments;
import tax.nalog.gov.by.dao.DepartmentDAO;

public class DepartmentService {
	DepartmentDAO dao;
	
	public DepartmentService() {
		dao = new DepartmentDAO();
	}
	
	public void save(Departments entity) {
		dao.save(entity);
	}
	
	public Departments findByID (int id) {
		return dao.findById(id);
	}
	
	public void update(Departments entity) {
		dao.update(entity);
	}
	
	public void delete(Departments entity) {
		dao.delete(entity);
	}
	
	public TreeMap<String, String> findAll(){
		TreeMap<String,String> resultList = new TreeMap<String, String>();
		List<Departments> all = dao.findAll();
		
		for (Departments department : all ) {
			resultList.put(department.getName(), department.getName());
		}
		
		return resultList;
	}
}
