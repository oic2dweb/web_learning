package app.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import app.model.User;

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
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (name,kana,username,password,email) VALUES(?,?,?,MD5(?),?)");){

			//SQL文に値をセット
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getKana());
			stmt.setString(3, user.getUsername());
			stmt.setString(4, user.getPassword());
			stmt.setString(5, user.getEmail());

			//SQl文を実行
			stmt.executeUpdate();
			
			return true;

		}catch(Exception e) {
			return false;
		}
	}
}
