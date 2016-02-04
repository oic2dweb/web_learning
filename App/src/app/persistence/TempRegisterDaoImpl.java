package app.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import app.model.User;

public class TempRegisterDaoImpl implements TempRegisterDao{
	private DataSource dataSource = DataSourceFactory.getDataSource();
	@Override
	public boolean create(User user) {
		try(Connection conn = dataSource.getConnection();
				//SQL文を用意	　attributeはメールもしくはユーザーID
				PreparedStatement stmt = conn.prepareStatement("INSERT INTO temp_register (name,kana,student_id,password,email,class_id,secret_id,secret_text,url) VALUES(?,?,?,md5(?),?,?,?,md5(?),?)");){

				//SQL文に値をセット
				stmt.setString(1, user.getName());
				stmt.setString(2, user.getKana());
				stmt.setString(3, user.getStudentId());
				stmt.setString(4, user.getPassword());
				stmt.setString(5, user.getEmail());
				stmt.setInt(6, user.getClassId());
				stmt.setInt(7, user.getSecret_id());
				stmt.setString(8, user.getSecret_text());
				stmt.setString(9, user.getUrl());
				//SQl文を実行
				stmt.executeUpdate();

				return true;

			}catch(Exception e) {
				return false;
			}
	}
	@Override
	public User getUser(String url) {
		User user = null;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement stmt =conn.prepareStatement("select * from temp_register where url = ?");){
			stmt.setString(1,url);
			ResultSet result = stmt.executeQuery();

			while(result.next()){
				user = new User();
				user.setName(result.getString("name"));
				user.setKana(result.getString("kana"));
				user.setStudentId(result.getString("student_id"));
				user.setPassword(result.getString("password"));
				user.setEmail(result.getString("email"));
				user.setClassId(result.getInt("class_id"));
				user.setSecret_id(result.getInt("secret_id"));
				user.setSecret_text(result.getString("secret_text"));
			}


		} catch (SQLException e) {
			user = null;
		}

		return user;
	}
	@Override
	public boolean deleteUser(String email) {
		boolean flg = false;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement stmt =conn.prepareStatement("delete from temp_register where email = ?");){
			stmt.setString(1, email);
			int count = stmt.executeUpdate();
			if(0<count){
				flg = true;
			}

		} catch (SQLException e) {
			System.out.println("エラー");
		}
		return flg;
	}


}
