package app.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.sql.DataSource;

public class TestRecordsDaoImpl implements TestRecordsDao{
	private DataSource dataSource = DataSourceFactory.getDataSource();
	@Override
	public int getId(int userid, int score) {
		int recordid = -1;
		//insertしたauto_incrementの値を取得するためにjava.sql.Statement.RETURN_GENERATED_KEYSを第二引数に指定
		try(Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement("insert into test_records(user_id,score) values(?,?)",java.sql.Statement.RETURN_GENERATED_KEYS);){
				stmt.setInt(1, userid);
				stmt.setInt(2, score);
				stmt.executeUpdate();
				//auto_inclementの値を取得
				ResultSet result =stmt.getGeneratedKeys();
				result.next();
				recordid =result.getInt(1);
		}catch(Exception e){
			e.printStackTrace();
		}
		return recordid;
	}

	@Override
	public int Average(int user_id){
		int score = 0;
		int ave = 0;
		//過去10回分の点数を取得
		try(Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT score FROM test_records WHERE user_id = ? ORDER BY time DESC");){
			stmt.setInt(1, user_id);
			ResultSet rs = stmt.executeQuery();
			int rscount = 0;
			for(int i = 0; i < 10; i++){
				if(rs.next()){
					score = rs.getInt("score");
					ave += score;
					rscount++;
				}
			}
			if(ave != 0){
				ave /= rscount;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return ave;
	}

	@Override
	public Date lastAnswer(int user_id){
		Date lastlogin = new Date(0);;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT time FROM test_records WHERE user_id = ? ORDER BY time DESC");){
			stmt.setInt(1, user_id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				lastlogin = rs.getDate("time");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return lastlogin;
	}

}
