package app.persistence;

import app.model.KaitouStatus;

public interface KaitouStatusDao {

	public boolean create(KaitouStatus status) ;
	public void RevChange(String questionid,Integer userid);
}
