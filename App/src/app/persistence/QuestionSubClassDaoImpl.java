package app.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import app.model.SubClass;

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
	public ArrayList<SubClass> getSubClass(){
		ArrayList<SubClass> list = new ArrayList<SubClass>();
		SubClass subclass;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement("select * from question_subclass");){
			ResultSet result = stmt.executeQuery();
			while(result.next()){
				subclass = new SubClass();
				subclass.setId(result.getInt("subclass_id"));
				subclass.setName(result.getString("subclass_name"));
				subclass.setMainid(result.getInt("mainclass_id"));
				list.add(subclass);
			}
		}catch (Exception e) {
		}
		return list;

	}


	@Override
	public int getMainClassId(int subid) {

		
		int mainid=-1;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement("select * from question_subclass where subclass_id = ?");){
			stmt.setInt(1, subid);
			ResultSet result = stmt.executeQuery();
			if(result.next()){

				mainid = result.getInt("mainclass_id");
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return mainid;
	}


}
