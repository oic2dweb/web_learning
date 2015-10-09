package app.service;

import app.model.User;
import app.persistence.UserDao;
import app.persistence.UserDaoImpl;

public class UserService {

	private UserDao userDao = new UserDaoImpl();

	public boolean register(User user){
		return userDao.create(user);
	}

	public boolean checkUniqueness(String attribute, String value){
		return userDao.checkUniqueness(attribute, value);
	}
	public boolean emailCheck(String email){
		return userDao.emailCheck(email);
	}
	public boolean loginCheck(String email, String password){
		return userDao.loginCheck(email, password);
	}

}
