package app.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import app.model.KaitouStatus;

public class KaitouStatusDaoImpl implements KaitouStatusDao{

	private DataSource dataSource = DataSourceFactory.getDataSource();

	public boolean create(KaitouStatus status) {
		//DBとの接続
	try(Connection conn = dataSource.getConnection();
		//SQL文を用意
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO kaitou_status (question_id,user_id,result,time,revision) VALUES(?,?,?,?,?)");){

		//SQL文に値をセット
		stmt.setLong(1, status.getQuestion_id());
		stmt.setLong(2, status.getUesr_id());
		stmt.setInt(3, status.getResult());
		stmt.setString(4, status.getTime());
		stmt.setInt(5, status.getReview());

		//SQl文を実行
		stmt.executeUpdate();

		return true;

	}catch(Exception e) {
		return false;
	}
}


}
