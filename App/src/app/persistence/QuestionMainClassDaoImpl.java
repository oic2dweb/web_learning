package app.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import app.model.MainClass;

public class QuestionMainClassDaoImpl implements QuestionMainClassDao{
	private DataSource dataSource = DataSourceFactory.getDataSource();
	@Override
	public ArrayList<MainClass> getMainClass() {
		ArrayList<MainClass> list = new ArrayList<MainClass>();
		MainClass mainclass;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement("select * from question_mainclass");){
			ResultSet result = stmt.executeQuery();
			while(result.next()){
				mainclass = new MainClass();
				mainclass.setCatId(result.getInt("cat_id"));
				mainclass.setName(result.getString("mainclass_name"));
				mainclass.setMainId(result.getInt("mainclass_id"));
				list.add(mainclass);
			}
		}catch (Exception e) {
		}
		return list;
	}

	//
	@Override
	public int getCatId(int mainid) {
		int catid = -1;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement("select * from question_mainclass where mainclass_id = ?");){
			stmt.setInt(1, mainid);
			ResultSet result = stmt.executeQuery();
			if(result.next()){
				catid  =result.getInt("cat_id");
			}
			
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return catid;
	}


}
