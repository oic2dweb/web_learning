package app.persistence;

import java.util.Map;

public interface QuestionSubClassDao {
	public int getTotal();
	public Map<Integer,String> getSubClass(int mainid);
}
