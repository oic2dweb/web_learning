package app.service;

import app.persistence.AdminDao;
import app.persistence.AdminDaoImpl;
public class AdminService {

	private AdminDao adminDao = new AdminDaoImpl();

	public boolean loginCheck(String id, String password){
		return adminDao.loginCheck(id, password);
	}
	public String getId(String id){
		return adminDao.getId(id);
	}

}
