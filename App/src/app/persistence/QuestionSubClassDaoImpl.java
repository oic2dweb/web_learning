package app.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

public class QuestionSubClassDaoImpl implements QuestionSubClassDao{

	private DataSource dataSource = DataSourceFactory.getDataSource();
	@Override
	public int getTotal() {
		int total = 0;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement("select count(*) as total from question_subclass");){
				ResultSet rs = stmt.executeQuery();
				rs.next();
				total = rs.getInt("total");
		}catch(Exception e){

		}
		return total;

	}

	//Mapにsubclass_idをキー、subclass_nameを値として取得
	public Map<Integer,String> getSubClass(int mainid){
		Map<Integer,String> map = new HashMap<Integer,String>();
		try(Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement("select * from question_subclass where mainclass_id=?");){
			stmt.setInt(1, mainid);
			ResultSet result = stmt.executeQuery();
			while(result.next()){
				map.put(result.getInt("subclass_id"), result.getString("subclass_name"));
			}
		}catch (Exception e) {
		}
		return map;

	}

}
