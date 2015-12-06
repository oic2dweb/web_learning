package app.persistence;

import app.model.QuestionType;

public interface QuestionTypeDao {
	public String getName(int id);
	public QuestionType getQuestionType(int id);
}
