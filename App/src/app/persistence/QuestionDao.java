package app.persistence;

import java.util.ArrayList;
import java.util.List;

import app.model.Question;
import app.model.TestRecord;

public interface QuestionDao {
	public ArrayList<Question> getQustion(String sql);
	public ArrayList<Integer> getClassCount(String sql);
	public ArrayList<Question> getNendobetu(String sql);
	public List<TestRecord> getAllTestRecordsByUser(Long userId);
	public ArrayList<Question> getHukusyu(String sql);
}
