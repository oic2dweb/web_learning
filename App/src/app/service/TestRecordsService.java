package app.service;

import app.persistence.TestRecordsDao;
import app.persistence.TestRecordsDaoImpl;

public class TestRecordsService {
	TestRecordsDao trDao = new TestRecordsDaoImpl();
	public int getId(int userid){
		return trDao.getId(userid);
	}
}
