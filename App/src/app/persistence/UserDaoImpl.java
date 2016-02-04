package app.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import app.model.ProjectY;
import app.model.User;
import app.model.UserTemp;

public class UserDaoImpl implements UserDao {

	private DataSource dataSource = DataSourceFactory.getDataSource();

	@Override
	public boolean checkUniqueness(String attribute, String value) {

		int flag = 0;
			//DBとの接続
		try(Connection conn = dataSource.getConnection();
			//SQL文を用意	　attributeはメールもしくはユーザーID
			PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM users WHERE " + attribute + " = ?");){
			//SQL文に値をセット
			stmt.setString(1, value);
			//実行結果の参照情報を格納するResultSet型の変数を用意する
			ResultSet rs = stmt.executeQuery();
			//もしレコード数が１以上だったら、ユニークではなく、falseを返す
			if(rs.next()){
				flag = rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		//レコードがなし、ユニークで、trueを返す
		if(flag >= 1){
			return false;
		}else{
			return true;
		}
	}
	//random
	@Override
	public boolean create(User user) {
			//DBとの接続
		try(Connection conn = dataSource.getConnection();
			//SQL文を用意	　attributeはメールもしくはユーザーID
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (name,kana,student_id,password,email,class_id,secret_id,secret_text) VALUES(?,?,?,(?),?,?,?,?)");){

			//SQL文に値をセット
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getKana());
			stmt.setString(3, user.getStudentId());
			stmt.setString(4, user.getPassword());
			stmt.setString(5, user.getEmail());
			stmt.setInt(6, user.getClassId());
			stmt.setInt(7, user.getSecret_id());
			stmt.setString(8, user.getSecret_text());

			//SQl文を実行
			stmt.executeUpdate();

			return true;

		}catch(Exception e) {
			return false;
		}
	}


	public boolean loginCheck(String student_id, String password) {

		int flag = 0;

			//Dbとの接続
		try(Connection conn = dataSource.getConnection();
			//SQL文を用意
			PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM users WHERE student_id = ? and password = md5(?)");){
			//SQL文に値をセット
			stmt.setString(1, student_id);
			stmt.setString(2, password);
			//実行結果の参照情報を格納するResultSet型の変数を用意する
			ResultSet rs = stmt.executeQuery();
			//もしレコード数が１以上だったら、trueを返す
			if(rs.next()){
				flag = rs.getInt(1);
			}


		}catch(Exception e){
			e.printStackTrace();
		}
		//レコードがあればtrueを、なければfalseを返す
		if(flag >= 1){
			return true;
		}else{
			return false;
		}

	}
	@Override
	public boolean studentIdCheck(String value) {

		int flag = 0;
			//DBとの接続
		try(Connection conn = dataSource.getConnection();
			//SQL文を用意
			PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM users WHERE student_id = ?");){
			//SQL文に値をセット
			stmt.setString(1, value);
			//実行結果の参照情報を格納するResultSet型の変数を用意する
			ResultSet rs = stmt.executeQuery();
			//もしレコード数が１以上だったら、trueを返す
			if(rs.next()){
				flag = rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		//レコードがあればtrueを、なければfalseを返す
		if(flag >= 1){
			return true;
		}else{
			return false;
		}
	}
	@Override
	public boolean emailCheck(String value) {

		int flag = 0;
			//DBとの接続
		try(Connection conn = dataSource.getConnection();
			//SQL文を用意
			PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM users WHERE email = ?");){
			//SQL文に値をセット
			stmt.setString(1, value);
			//実行結果の参照情報を格納するResultSet型の変数を用意する
			ResultSet rs = stmt.executeQuery();
			//もしレコード数が１以上だったら、trueを返す
			if(rs.next()){
				flag = rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		//レコードがあればtrueを、なければfalseを返す
		if(flag >= 1){
			return true;
		}else{
			return false;
		}
	}
	@Override
	public int getId(String student_id) {
	    int id=0;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT id FROM users WHERE student_id = ?");){
			stmt.setString(1, student_id);
			ResultSet result = stmt.executeQuery();
			result.next();
			id = result.getInt("id");

		}catch(Exception e){
			e.printStackTrace();
		}
		return id;
	}
	@Override
	public User getUser(Long id) {
		User user = new User();
		try(Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE id = ?");){
			stmt.setString(1, id.toString());
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				user.setId(rs.getLong(1));
				user.setName(rs.getString(2));
				user.setKana(rs.getString(3));
				user.setStudentId(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setEmail(rs.getString(6));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}
	public boolean update(UserTemp user) {

		//DBとの接続
		try(Connection conn = dataSource.getConnection();
				//SQL文を用意
				PreparedStatement stmt = conn.prepareStatement("UPDATE users SET "+ user.getAttribute()+"=? WHERE id=?");){

				//SQL文に値をセット
				stmt.setString(1, user.getValue());
				stmt.setInt(2, user.getUser_id());

				//SQl文を実行
				stmt.executeUpdate();

				return true;

			}catch(Exception e) {
				return false;
			}
	}

	public boolean checkPassword(int id, String password) {

		int flag = 0;
		ProjectY py = new ProjectY();
		py.setStr(password);

			//Dbとの接続
		try(Connection conn = dataSource.getConnection();
			//SQL文を用意
			PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM users WHERE id = ? and password = md5(?)");){
			//SQL文に値をセット
			stmt.setInt(1, id);
			stmt.setString(2, py.getStr());
			//実行結果の参照情報を格納するResultSet型の変数を用意する
			ResultSet rs = stmt.executeQuery();
			//もしレコード数が１以上だったら、trueを返す
			if(rs.next()){
				flag = rs.getInt(1);
			}


		}catch(Exception e){
			e.printStackTrace();
		}
		//レコードがあればtrueを、なければfalseを返す
		if(flag >= 1){
			return true;
		}else{
			return false;
		}

	}
	
		@Override
	public String getName(int id) {
		String name="";
		try(Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE id = ?");){
			stmt.setInt(1, id);
			ResultSet result = stmt.executeQuery();
			if(result.next()){
				name = result.getString("name");
			}

		}catch(Exception e){

		}
		return name;
	}

	public boolean setTempPassword(User user){
		//DBとの接続
			try(Connection conn = dataSource.getConnection();
				//SQL文を用意
					PreparedStatement stmt = conn.prepareStatement("UPDATE users SET password = md5(?) WHERE email = ?");){

					//SQL文に値をセット
					stmt.setString(1, user.getPassword());
					stmt.setString(2, user.getEmail());
					//SQl文を実行
					stmt.executeUpdate();

					return true;

				}catch(Exception e) {
					return false;
				}

	}
}
