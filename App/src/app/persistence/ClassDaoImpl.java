package app.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.sql.DataSource;

public class ClassDaoImpl implements ClassDao{

	private DataSource dataSource = DataSourceFactory.getDataSource();

	public Map<Integer,String> getClasses(){
		Map<Integer,String> classes = new LinkedHashMap<Integer,String>();

		try(Connection conn = dataSource.getConnection();
			//SQL文を用意
			PreparedStatement stmt = conn.prepareStatement("select id, name from class;");){

			ResultSet rs = stmt.executeQuery();

			while(rs.next()){
				classes.put(rs.getInt("id"),rs.getString("name"));
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return classes;
	}
}
