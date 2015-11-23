package app.service;

import java.util.Map;

import app.persistence.QuestionCatDao;
import app.persistence.QuestionCatDaoImpl;

public class QuestionCatService {
	private QuestionCatDao dao = new QuestionCatDaoImpl();
	public Map<Integer,String> getCatName(){
		return dao.getCatName();
	}
}
