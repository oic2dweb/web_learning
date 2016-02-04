package app.persistence;

import java.util.Map;



public interface SecretQuestionDao {
	public Map<Integer,String> getQuestion();
}
