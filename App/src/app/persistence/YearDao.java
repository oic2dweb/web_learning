package app.persistence;

import java.util.Map;

import app.model.Year;

public interface YearDao {
	public boolean checkUniqueness(String year_name);
	public boolean create(Year year);
	public boolean delete(int year_id);
	public int getId(String year_name);
	public Map<Integer,String> getYear(int flg);
	public void publicYear(int no);	//引数で渡した年度IDを公開状態にする
}
