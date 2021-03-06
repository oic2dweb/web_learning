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
	public Map<Integer,String> getYear(int flg,int type_id) {
		Map<Integer,String> year = new LinkedHashMap<Integer,String>();

		try(Connection conn = dataSource.getConnection();
			//SQL文を用意
			PreparedStatement stmt = conn.prepareStatement("select * from year where flg = ? and type_id = ? order by year_id desc;");){
			//SQL文に値をセット
			stmt.setInt(1, flg);
			stmt.setInt(2, type_id);
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
	public int getId(String year_name,int type_id){
		int recordid = 0;

		try(Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement("select year_id from year where year_name = ? and type_id = ?");){
			//SQL文に値をセット
			stmt.setString(1, year_name);
			stmt.setInt(2, type_id);

			ResultSet result = stmt.executeQuery();
			result.next();
			recordid = result.getInt("year_id");

		}catch(Exception e){
			e.printStackTrace();
		}
		return recordid;
	}

	@Override
	public boolean checkUniqueness(String year_name,int type_id) {
		int flag = 0;
			//DBとの接続
		try(Connection conn = dataSource.getConnection();
			//SQL文を用意
			PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM year WHERE year_name = ? and type_id = ?");){
			//SQL文に値をセット
			stmt.setString(1, year_name);
			stmt.setInt(2, type_id);
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
			PreparedStatement stmt = conn.prepareStatement("insert into year (year_name,type_id,flg) values(?,?,?)");){

			//SQL文に値をセット
			stmt.setString(1, year.getYear_name());
			stmt.setInt(2, year.getType_id());
			stmt.setInt(3, year.getFlg());

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
	public void publicYear(int year_id,int num) {

		try(Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement("update year set flg = ? where year_id = ?");){
			stmt.setInt(1, num);
			stmt.setInt(2, year_id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public String getName(int year_id) {
		String year_name = "";
		try(Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement("select year_name from year where year_id = ?");){
			stmt.setInt(1, year_id);
			ResultSet result = stmt.executeQuery();
			if(result.next()){
				year_name = result.getString("year_name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return year_name;
	}
}
