package app.persistence;

import java.util.ArrayList;

import app.model.SubClass;

public interface QuestionSubClassDao {
	public int getTotal();
	public ArrayList<SubClass> getSubClass();
	public int getMainClassId(int subid);
}
