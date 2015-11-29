package app.service;

import java.util.List;

import app.model.TestRecord;
import app.persistence.QuestionDao;
import app.persistence.QuestionDaoImpl;
import app.persistence.UserDao;
import app.persistence.UserDaoImpl;

public class MyPageService {
	private QuestionDao questionDao = new QuestionDaoImpl();
	private UserDao userDao = new UserDaoImpl();

	public List<TestRecord> getAllTestRecords(Long userId,String type_id){
		return questionDao.getAllTestRecordsByUser(userId,type_id);
	}
}
