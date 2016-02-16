package app.service;

import java.util.Date;

import app.persistence.TestRecordsDao;
import app.persistence.TestRecordsDaoImpl;

public class TestRecordsService {
	TestRecordsDao trDao = new TestRecordsDaoImpl();
	public int getId(int userid, int score){
		return trDao.getId(userid, score);
	}
	public int Average(int user_id){
		return trDao.Average(user_id);
	}
	public Date lastAnswer(int user_id){
		return trDao.lastAnswer(user_id);
	}
}
