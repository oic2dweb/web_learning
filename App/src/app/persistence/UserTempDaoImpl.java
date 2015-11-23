package app.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import app.model.UserTemp;

public class UserTempDaoImpl implements UserTempDao{
	private DataSource dataSource = DataSourceFactory.getDataSource();

	public int create(UserTemp user) {

		String sql = "INSERT INTO user_temp (user_id,attribute,value) VALUES(?,?,?)";
		if(user.getAttribute().equals("password")){
			sql = "INSERT INTO user_temp (user_id,attribute,value) VALUES(?,?,md5(?))";
		}
		//DBとの接続
		try(Connection conn = dataSource.getConnection();
				//SQL文を用意
			PreparedStatement stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
				//SQL文に値をセット
			stmt.setInt(1, user.getId());
			stmt.setString(2, user.getAttribute());
			stmt.setString(3, user.getValue());

			//SQl文を実行
			stmt.executeUpdate();
			ResultSet result =stmt.getGeneratedKeys();
			result.next();
			int recordid =result.getInt(1);

			return recordid;

		}catch(Exception e) {
			return 0;
		}
	}

	public boolean setUrl(int recordid){
		String sql = "UPDATE user_temp SET url=md5(?) WHERE id=?";
		//DBとの接続
		try(Connection conn = dataSource.getConnection();
				//SQL文を用意
				PreparedStatement stmt = conn.prepareStatement(sql)){

				//SQL文に値をセット
				stmt.setInt(1, recordid);
				stmt.setInt(2, recordid);

				//SQl文を実行
				stmt.executeUpdate();

				return true;

			}catch(Exception e) {
				return false;
			}

	}

	public String getUrl(int recordid) {
	    String parameter="";
		try(Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT url FROM user_temp WHERE id = ?");){
			stmt.setInt(1, recordid);
			ResultSet result = stmt.executeQuery();
			result.next();
			parameter = result.getString("url");

		}catch(Exception e){
			e.printStackTrace();
		}
		return parameter;
	}

	public UserTemp getUserTemp(String url) {
		UserTemp user = new UserTemp();
		try(Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM user_temp WHERE url = ?");){
			stmt.setString(1, url);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				user.setId(rs.getInt(1));
				user.setUser_id(rs.getInt(2));
				user.setAttribute(rs.getString(3));
				user.setValue(rs.getString(4));
				user.setUrl(rs.getString(5));

			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}

	public boolean delete(String attribute,int user_id) {
		try(Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM user_temp WHERE user_id = ? AND attribute = ?");){

			stmt.setInt(1, user_id);
			stmt.setString(2, attribute);

			stmt.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}

	public boolean checkUrl(String url) {

		int flag = 0;

			//Dbとの接続
		try(Connection conn = dataSource.getConnection();
			//SQL文を用意
			PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM user_temp WHERE url = ?");){
			//SQL文に値をセット
			stmt.setString(1,url);
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

}
