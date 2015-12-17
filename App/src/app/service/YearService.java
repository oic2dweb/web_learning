package app.service;

import java.util.Map;

import app.model.Year;
import app.persistence.YearDao;
import app.persistence.YearDaoImpl;

public class YearService {

	private YearDao yearDao = new YearDaoImpl();

	public Map<Integer,String> getYear(int flg,int type_id) {
		return yearDao.getYear(flg,type_id);
	}

	public boolean register(Year year){
		return yearDao.create(year);
	}

	public boolean delete(int year_id){
		return yearDao.delete(year_id);
	}

	public boolean checkUniqueness(String year_name,int type_id){
		return yearDao.checkUniqueness(year_name,type_id);
	}

	public int getId(String nendo,int type_id){
		return yearDao.getId(nendo,type_id);
	}

	public void publicYear(int year_id,int num){
		yearDao.publicYear(year_id,num);
	}
	public String getName(int year_id){
		return yearDao.getName(year_id);


	}

}
