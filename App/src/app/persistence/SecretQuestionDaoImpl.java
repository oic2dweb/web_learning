package app.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.sql.DataSource;



public class SecretQuestionDaoImpl implements SecretQuestionDao{
	private DataSource dataSource = DataSourceFactory.getDataSource();

	@Override
	public Map<Integer, String> getQuestion() {
		Map<Integer,String> question = new LinkedHashMap<Integer,String>();

		try(Connection conn = dataSource.getConnection();
			//SQL文を用意
			PreparedStatement stmt = conn.prepareStatement("select * from secret_question");){
			ResultSet result = stmt.executeQuery();
			while(result.next()){
				question.put(result.getInt("id"), result.getString("question"));
			}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return question;
	}

}
