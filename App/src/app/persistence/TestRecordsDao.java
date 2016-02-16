package app.persistence;

import java.util.Date;

public interface TestRecordsDao {
	public int getId(int userid, int score);
	public int Average(int user_id);
	public Date lastAnswer(int user_id);
}
