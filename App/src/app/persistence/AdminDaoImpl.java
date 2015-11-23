package app.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

public class AdminDaoImpl implements AdminDao{

	private DataSource dataSource = DataSourceFactory.getDataSource();

	public boolean loginCheck(String id, String password){
		int flag = 0;

		//DBとの接続
		try(Connection conn = dataSource.getConnection();
		//SQL文を用意
		PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM admin WHERE id = ? and password = md5(?)");){
			//SQL文に値をセット
			stmt.setString(1, id);
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
	public String getId(String id){
		//変数名の重複を避けるため、ローカル変数をadminidと定義
		String adminid="";
		try(Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT id FROM admin WHERE id = ?");){
			stmt.setString(1, id);
			ResultSet result = stmt.executeQuery();
			result.next();
			adminid = result.getString("id");

		}catch(Exception e){
			e.printStackTrace();
		}
		return adminid;
	}

}
