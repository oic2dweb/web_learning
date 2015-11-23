package app.persistence;

public interface AdminDao {
	public boolean loginCheck(String id, String password);
	public String getId(String id);
}