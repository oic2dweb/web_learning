package app.service;

import java.util.ArrayList;

import app.model.SubClass;
import app.persistence.QuestionSubClassDao;
import app.persistence.QuestionSubClassDaoImpl;

public class QuestionSubClassService {
	private QuestionSubClassDao questionSubClassDao = new QuestionSubClassDaoImpl();
	public int getTotal(){
		return questionSubClassDao.getTotal();
	}
	public ArrayList<SubClass> getSubClass(){
		return questionSubClassDao.getSubClass();
	}
	public int getMainClassId(int subid){
		return questionSubClassDao.getMainClassId(subid);

	}
}
