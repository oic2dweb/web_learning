package app.persistence;

import java.util.ArrayList;

import app.model.MainClass;

public interface QuestionMainClassDao {
	public ArrayList<MainClass> getMainClass();
	public int getCatId(int mainid);	//引数のmainclass_idからcat_idを取得して返す
}
