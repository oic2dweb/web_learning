package app.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

public class YearDaoImpl implements YearDao{

	private DataSource dataSource = DataSourceFactory.getDataSource();

	@Override
	public Map<Integer,String> getYear() {
		Map<Integer,String> year = new HashMap<Integer,String>();

		try(Connection conn = dataSource.getConnection();
				//SQL文を用意
				PreparedStatement stmt = conn.prepareStatement("select * from year;");){
				ResultSet rs = stmt.executeQuery();

				while(rs.next()){
					year.put(rs.getInt("year_id"),rs.getString("year_name"));
				}

			}catch(Exception e){
				e.printStackTrace();
			}

		return year;
	}


}
