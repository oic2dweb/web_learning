package app.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

public class TestRecordsDaoImpl implements TestRecordsDao{
	private DataSource dataSource = DataSourceFactory.getDataSource();
	@Override
	public int getId(int userid) {
		int recordid = -1;
		//insertしたauto_incrementの値を取得するためにjava.sql.Statement.RETURN_GENERATED_KEYSを第二引数に指定
		try(Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement("insert into test_records(user_id) values(?)",java.sql.Statement.RETURN_GENERATED_KEYS);){
				stmt.setInt(1, userid);
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

}
