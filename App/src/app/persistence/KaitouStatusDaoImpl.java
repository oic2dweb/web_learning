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
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO kaitou_status (question_id,result,records_id,revision) VALUES(?,?,?,?)");){

		//SQL文に値をセット
		stmt.setInt(1, status.getQuestion_id());
		stmt.setInt(2, status.getResult());
		stmt.setInt(3, status.getRecord_id());
		stmt.setInt(4, status.getRevision());

		//SQl文を実行
		stmt.executeUpdate();

		return true;

		}catch(Exception e) {
		return false;
		}
	}

	@Override
	public void RevChange(String questionid,Integer userid) {
		String sql = "update kaitou_status s join " +
				"test_records t on s.records_id = t.id " +
				"set revision = 0 " +
				"where s.question_id = " + questionid + " and " +
				"t.user_id = " + userid;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);){
				stmt.executeUpdate();
				}catch(Exception e){
				e.printStackTrace();
			}

	}


}
