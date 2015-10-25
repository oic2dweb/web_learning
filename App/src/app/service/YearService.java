package app.service;

import java.util.Map;

import app.persistence.YearDao;
import app.persistence.YearDaoImpl;

public class YearService {

	private YearDao yearDao = new YearDaoImpl();

	public Map<Integer,String> getYear() {
		return yearDao.getYear();

	}

}
