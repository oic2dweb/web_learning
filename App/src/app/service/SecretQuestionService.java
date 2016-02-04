package app.service;

import java.util.Map;

import app.persistence.SecretQuestionDao;
import app.persistence.SecretQuestionDaoImpl;

public class SecretQuestionService {
	SecretQuestionDao dao = new SecretQuestionDaoImpl();

	public Map<Integer,String> getQuestion(){
		return dao.getQuestion();
	}
}
