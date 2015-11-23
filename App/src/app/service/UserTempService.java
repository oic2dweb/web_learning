package app.service;

import app.model.UserTemp;
import app.persistence.UserTempDao;
import app.persistence.UserTempDaoImpl;

public class UserTempService {
	private UserTempDao usertempDao = new UserTempDaoImpl();

	public int create(UserTemp user) {
		return usertempDao.create(user);
	}

	public boolean setUrl(int recordid){
		return usertempDao.setUrl(recordid);
	}

	public String getUrl(int recordid){
		return usertempDao.getUrl(recordid);
	}

	public UserTemp getUserTemp(String url) {
		return usertempDao.getUserTemp(url);
	}

	public boolean delete(String attribute,int user_id) {
		return usertempDao.delete(attribute, user_id);
	}

	public boolean checkUrl(String url){
		return usertempDao.checkUrl(url);
	}
}
