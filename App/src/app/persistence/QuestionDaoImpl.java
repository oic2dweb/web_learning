package app.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import app.model.Question;

public class QuestionDaoImpl implements QuestionDao{
	
	private DataSource dataSource = DataSourceFactory.getDataSource();

	@Override
	public Question getQustion(String sql) {
		Question qes = new Question();
		ArrayList<String> question = new ArrayList<String>();

		ArrayList<String> ans1 = new ArrayList<String>();
		ArrayList<String> ans2 = new ArrayList<String>();
		ArrayList<String> ans3 = new ArrayList<String>();
		ArrayList<String> ans4 = new ArrayList<String>();
		ArrayList<Integer> sei = new ArrayList<Integer>();
		ArrayList<String> kaisetu = new ArrayList<String>();
		try(Connection conn = dataSource.getConnection();
				//SQL文を用意
				PreparedStatement stmt = conn.prepareStatement(sql);){
				ResultSet rs = stmt.executeQuery();

				while(rs.next()){
					question.add(rs.getString("question"));
					ans1.add(rs.getString("ans1"));
					ans2.add(rs.getString("ans2"));
					ans3.add(rs.getString("ans3"));
					ans4.add(rs.getString("ans4"));
					sei.add(rs.getInt("sei"));
					kaisetu.add(rs.getString("kaisetu"));
				}
				qes.setQuestion(question);
				qes.setAns1(ans1);
				qes.setAns2(ans2);
				qes.setAns3(ans3);
				qes.setAns4(ans4);
				qes.setSei(sei);
				qes.setKaisetu(kaisetu);
				qes.setCount(question.size());
				
			}catch(Exception e){
				e.printStackTrace();
			}
		return qes;
	}
	
	

}
