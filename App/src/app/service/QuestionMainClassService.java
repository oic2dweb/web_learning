package app.service;

import java.util.ArrayList;

import app.model.MainClass;
import app.persistence.QuestionMainClassDao;
import app.persistence.QuestionMainClassDaoImpl;

public class QuestionMainClassService {
	private QuestionMainClassDao questionMainClassDao = new QuestionMainClassDaoImpl();
	public ArrayList<MainClass> getMainClass(){
		return questionMainClassDao.getMainClass();
	}
	public int getCatId(int mainid){
		return questionMainClassDao.getCatId(mainid);
	}
}
