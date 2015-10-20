package app.persistence;

import app.model.User;

public interface UserDao {
	public boolean checkUniqueness(String attribute, String value);
	public boolean create(User user);
	public boolean loginCheck(String email, String password);
	public boolean emailCheck(String value);
	public int getId(String email);
}
