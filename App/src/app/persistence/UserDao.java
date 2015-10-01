package app.persistence;

import app.model.User;

public interface UserDao {
	public boolean checkUniqueness(String attribute, String value);
	public boolean create(User user);
}
