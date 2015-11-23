package app.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.sql.DataSource;

import app.model.Year;

public class YearDaoImpl implements YearDao{

	private DataSource dataSource = DataSourceFactory.getDataSource();

	@Override
	public Map<Integer,String> getYear(int flg) {
		Map<Integer,String> year = new LinkedHashMap<Integer,String>();

		try(Connection conn = dataSource.getConnection();
			//SQL文を用意
			PreparedStatement stmt = conn.prepareStatement("select * from year where flg = ? order by year_id desc;");){
			//SQL文に値をセット
			stmt.setInt(1, flg);

			ResultSet rs = stmt.executeQuery();

			while(rs.next()){
				year.put(rs.getInt("year_id"),rs.getString("year_name"));
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return year;
	}

	@Override
	public int getId(String year_name){
		int recordid = 0;

		try(Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement("select year_id from year where year_name = ?");){
			//SQL文に値をセット
			stmt.setString(1, year_name);

			ResultSet result = stmt.executeQuery();
			result.next();
			recordid = result.getInt("year_id");

		}catch(Exception e){
			e.printStackTrace();
		}
		return recordid;
	}

	@Override
	public boolean checkUniqueness(String year_name) {
		int flag = 0;
			//DBとの接続
		try(Connection conn = dataSource.getConnection();
			//SQL文を用意
			PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM year WHERE year_name = ?");){
			//SQL文に値をセット
			stmt.setString(1, year_name);
			//実行結果の参照情報を格納するResultSet型の変数を用意する
			ResultSet rs = stmt.executeQuery();
			//もしレコード数が１以上だったら、ユニークではなく、falseを返す
			if(rs.next()){
				flag = rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		//レコードがなし、ユニークで、trueを返す
		if(flag >= 1){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public boolean create(Year year){
		//DBとの接続
		try(Connection conn = dataSource.getConnection();
			//SQL文を用意
			PreparedStatement stmt = conn.prepareStatement("insert into year (year_name,flg) values(?,?)");){

			//SQL文に値をセット
			stmt.setString(1, year.getYear_name());
			stmt.setInt(2, year.getFlg());

			//SQl文を実行
			stmt.executeUpdate();
			return true;

		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(int year_id){
		//DBとの接続
		try(Connection conn = dataSource.getConnection();
			//SQL文を用意
			PreparedStatement stmt = conn.prepareStatement("delete from year where year_id=?");){

			//SQL文に値をセット
			stmt.setInt(1, year_id);

			//SQl文を実行
			stmt.executeUpdate();
			return true;

		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public void publicYear(int no) {
		try(Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement("update year set flg = 1 where year_id = ?");){
			stmt.setInt(1, no);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
