package app.service;

import app.model.QuestionType;
import app.persistence.QuestionTypeDao;
import app.persistence.QuestionTypeDaoImpl;

public class QuestionTypeService {
	QuestionTypeDao dao = new QuestionTypeDaoImpl();
	public String getName(int id){
		return dao.getName(id);
		
	}
	public QuestionType getQuestionType(int id) {
		return dao.getQuestionType(id);
	}

}
