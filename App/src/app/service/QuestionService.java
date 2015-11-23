package app.service;

import java.util.ArrayList;

import app.model.EntryQuestion;
import app.model.Question;
import app.persistence.QuestionDao;
import app.persistence.QuestionDaoImpl;

public class QuestionService {

	private QuestionDao questionDao = new QuestionDaoImpl();

	public ArrayList<Question> getQuestion(String sql) {
		return questionDao.getQustion(sql);
	}
	public ArrayList<Integer> getClassCount(String sql){
		return questionDao.getClassCount(sql);
	}

	public ArrayList<Question> getHukusyu(String sql){
		return questionDao.getHukusyu(sql);
	}
	public void insertQuestion(EntryQuestion eq){
		questionDao.insertQuestion(eq);
	}
	public void updateQuestion(EntryQuestion eq){
		questionDao.updateQuestion(eq);
	}
	public boolean checkQuestionNo(int yearid,int no){
		return questionDao.checkQuestionNo(yearid, no);
	}
	public EntryQuestion getQuestion(int yearid, int no) {
		return questionDao.getQuestion(yearid, no);
	}
	public ArrayList<EntryQuestion> getList(int yearid){
		return questionDao.getList(yearid);
	}
	public boolean delete(int year_id){
		return questionDao.delete(year_id);
	}
}
