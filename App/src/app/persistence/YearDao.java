package app.persistence;

import java.util.Map;

import app.model.Year;

public interface YearDao {
	public boolean checkUniqueness(String year_name,int type_id);
	public boolean create(Year year);
	public boolean delete(int year_id);
	public int getId(String year_name,int type_id);
	public Map<Integer,String> getYear(int flg,int type_id);
	public void publicYear(int year_id,int num);	//引数で渡した年度IDを公開又は非公開にする
	public String getName(int year_id);
}
