package app.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

public class QuestionCatDaoImpl implements QuestionCatDao{
	private DataSource dataSource = DataSourceFactory.getDataSource();

	//cat_name一覧を取得するメソッド
	@Override
	public Map<Integer,String> getCatName() {
		Map<Integer,String> map = new HashMap<Integer,String>();
		try(Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement("select * from question_cat order by cat_id");){
			ResultSet result = stmt.executeQuery();
			while(result.next()){
				map.put(result.getInt("cat_id"),result.getString("cat_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

}
