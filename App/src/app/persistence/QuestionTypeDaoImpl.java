package app.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import app.model.QuestionType;

public class QuestionTypeDaoImpl implements QuestionTypeDao{
	private DataSource dataSource = DataSourceFactory.getDataSource();
	@Override
	public String getName(int id) {
		String name ="";
		try(Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement("select type_name from question_type where id = ?");){
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				name = rs.getString("type_name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return name;
	}
	@Override
	public QuestionType getQuestionType(int id) {
		QuestionType model = new QuestionType();
		try(Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement("select * from question_type where id = ?");){
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				model.setId(id);
				model.setTypeName(rs.getString("type_name"));
				model.setQuantity(rs.getInt("quantity"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}

}
