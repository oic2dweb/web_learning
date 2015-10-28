package app.service;

import app.persistence.QuestionSubClassDao;
import app.persistence.QuestionSubClassDaoImpl;

public class QuestionSubClassService {
	private QuestionSubClassDao questionSubClassDao = new QuestionSubClassDaoImpl();
	public int getTotal(){
		return questionSubClassDao.getTotal();
	}
}
