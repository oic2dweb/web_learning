package app.service;

import app.model.User;
import app.model.UserTemp;
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
	public boolean student_idCheck(String email){
		return userDao.studentIdCheck(email);
	}
	public boolean emailCheck(String email,int secret_id,String secret_text){
		return userDao.emailCheck(email,secret_id,secret_text);
	}
	public boolean loginCheck(String student_id, String password){
		return userDao.loginCheck(student_id, password);
	}
	public int getId(String email){
		return userDao.getId(email);
	}
	public User getUser(Long userid){
		return userDao.getUser(userid);
	}
	public boolean update(UserTemp user){
		return userDao.update(user);
	}
	public boolean checkPassword(int id, String password){
		return userDao.checkPassword(id, password);
	}
	public String getName(int id){
		return userDao.getName(id);
	}
	public boolean setTempPassword(User user){
		return userDao.setTempPassword(user);
	}
}
