package app.service;

import app.model.User;
import app.persistence.TempRegisterDao;
import app.persistence.TempRegisterDaoImpl;

public class TempRegisterService {
	TempRegisterDao dao =  new TempRegisterDaoImpl();
	public boolean create(User user) {
		return dao.create(user);
	}
	public User getUser(String url){
		return dao.getUser(url);
	}
	public boolean deleteUser(String email){
		return dao.deleteUser(email);
	}
}
