package app.persistence;

import app.model.User;

public interface TempRegisterDao {
	public boolean create(User user);
	public User getUser(String url);
	public boolean deleteUser(String email);
}
