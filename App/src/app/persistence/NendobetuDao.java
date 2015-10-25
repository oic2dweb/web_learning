package app.persistence;

import java.util.ArrayList;

import app.model.Question;

	public interface NendobetuDao {
		public ArrayList<Question> getNendobetu(String sql);

}
