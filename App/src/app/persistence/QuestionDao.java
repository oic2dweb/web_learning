package app.persistence;

import java.util.ArrayList;
import java.util.List;

import app.model.EntryQuestion;
import app.model.Question;
import app.model.TestRecord;

public interface QuestionDao {
	public ArrayList<Question> getQustion(String sql);
	public ArrayList<Integer> getClassCount(String sql);
	public ArrayList<Question> getNendobetu(String sql);
	public List<TestRecord> getAllTestRecordsByUser(Long userId,String type_id);
	public ArrayList<Question> getHukusyu(String sql);
	public void insertQuestion(EntryQuestion eq);	//問題を追加する
	public void updateQuestion(EntryQuestion eq);	//問題を更新する
	public boolean checkQuestionNo(int yearid,int no);	//既に問題が登録されているとtrueを返す
	public EntryQuestion getQuestion(int yearid, int no,int type_id) ;
	public ArrayList<EntryQuestion> getList(int yearid);
	public int getQuantity(int year_id);
	public boolean delete(int year_id);
	public int getMaxNo(int year_id);
}
