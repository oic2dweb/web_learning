package app.persistence;

import app.model.User;
import app.model.UserTemp;

public interface UserDao {
	public boolean checkUniqueness(String attribute, String value);
	public boolean create(User user);
	public boolean loginCheck(String email, String password);
	public boolean studentIdCheck(String value);
	public boolean emailCheck(String value);
	public int getId(String email);
	public User getUser(Long id);
	public boolean update(UserTemp user);
	public boolean checkPassword(int id, String password);
	public String getName(int id);
	public boolean setTempPassword(User user);
}
