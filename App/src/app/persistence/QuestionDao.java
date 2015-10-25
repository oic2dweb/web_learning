package app.persistence;

import java.util.ArrayList;

import app.model.Question;

public interface QuestionDao {
	public ArrayList<Question> getQustion(String sql);
	public ArrayList<Integer> getClassCount(String sql);

}
