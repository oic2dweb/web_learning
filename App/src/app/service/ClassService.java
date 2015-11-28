package app.service;

import java.util.Map;

import app.persistence.ClassDao;
import app.persistence.ClassDaoImpl;

public class ClassService {

	private ClassDao classDao = new ClassDaoImpl();

	public Map<Integer,String> getClasses(){
		return classDao.getClasses();
	}
}
