package app.service;

import java.util.ArrayList;

import app.model.Question;
import app.persistence.QuestionDao;
import app.persistence.QuestionDaoImpl;

public class QuestionService {

	private QuestionDao questionDao = new QuestionDaoImpl();

	public ArrayList<Question> getQuestion(String sql) {
		return questionDao.getQustion(sql);
	}
}
