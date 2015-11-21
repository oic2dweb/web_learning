package app.service;

import app.model.KaitouStatus;
import app.persistence.KaitouStatusDao;
import app.persistence.KaitouStatusDaoImpl;

public class KaitouStatusService {
	KaitouStatusDao ksDao = new KaitouStatusDaoImpl();

	public boolean create(KaitouStatus status){
		return ksDao.create(status);
	}
	public void change(String questionid,Integer userid){
		ksDao.RevChange(questionid,userid);
	}
}
