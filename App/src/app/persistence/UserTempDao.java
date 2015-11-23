package app.persistence;

import app.model.UserTemp;

public interface UserTempDao {
	public int create(UserTemp user);
	public boolean setUrl(int recordid);
	public String getUrl(int recordid);
	public UserTemp getUserTemp(String url);
	public boolean delete(String attribute,int user_id);
	public boolean checkUrl(String url);

}
