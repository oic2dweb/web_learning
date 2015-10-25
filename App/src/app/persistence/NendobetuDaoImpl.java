package app.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import app.model.Question;

public class NendobetuDaoImpl implements NendobetuDao {

	private DataSource dataSource = DataSourceFactory.getDataSource();

	@Override
	public ArrayList<Question> getNendobetu(String sql) {
		Question qes = new Question();
		ArrayList<Question> question = new ArrayList<Question>();

		try(Connection conn = dataSource.getConnection();
				//SQL文を用意
				PreparedStatement stmt = conn.prepareStatement(sql);){
				ResultSet rs = stmt.executeQuery();
				 qes = new Question();
				while(rs.next()){
					qes = new Question();
					qes.setQuestion(rs.getString("question"));
					qes.setRonten(rs.getString("ronten"));
					qes.setAns1(rs.getString("ans1"));
					qes.setAns2(rs.getString("ans2"));
					qes.setAns3(rs.getString("ans3"));
					qes.setAns4(rs.getString("ans4"));
					qes.setSei(rs.getString("sei"));
					qes.setKaisetu(rs.getString("kaisetu"));
					qes.setSubclass(rs.getString("subclass_name"));
					question.add(qes);
				}
		}catch(Exception e){
			e.printStackTrace();
		}


		return question;
	}

}
