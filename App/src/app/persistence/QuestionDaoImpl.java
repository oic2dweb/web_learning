package app.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import app.model.Question;
import app.model.TestRecord;

public class QuestionDaoImpl implements QuestionDao{

	private DataSource dataSource = DataSourceFactory.getDataSource();

	@Override
	public ArrayList<Question> getQustion(String sql) {
		Question qes = new Question();
		ArrayList<Question> question = new ArrayList<Question>();


		try(Connection conn = dataSource.getConnection();
				//SQL文を用意
				PreparedStatement stmt = conn.prepareStatement(sql);){
				ResultSet rs = stmt.executeQuery();

				while(rs.next()){
					qes = new Question();
					qes.setId(rs.getInt("id"));
					qes.setQuestion(rs.getString("question"));
					qes.setRonten(rs.getString("ronten"));
					qes.setAns1(rs.getString("ans1"));
					qes.setAns2(rs.getString("ans2"));
					qes.setAns3(rs.getString("ans3"));
					qes.setAns4(rs.getString("ans4"));
					qes.setSei(rs.getString("sei"));
					qes.setKaisetu(rs.getString("kaisetu"));
					question.add(qes);
				}


			}catch(Exception e){
				e.printStackTrace();
			}
		return question;
	}

	//小分類ごとの問題数をArrayListに入れて返す
	public ArrayList<Integer> getClassCount(String sql){
		ArrayList<Integer> list = new ArrayList<Integer>();
		try(Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);){
			ResultSet result = stmt.executeQuery();
			ResultSetMetaData meta = result.getMetaData();
			int count = meta.getColumnCount();
			result.next();

			for(int i=1;i<=count;i++){
				list.add(result.getInt(i));
			}

		}catch(Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	//年度別モード
		@Override
		public ArrayList<Question> getNendobetu(String sql) {
			Question qes = new Question();
			ArrayList<Question> question = new ArrayList<Question>();

			try(Connection conn = dataSource.getConnection();
					//SQL文を用意
					PreparedStatement stmt = conn.prepareStatement(sql);){
					ResultSet rs = stmt.executeQuery();
					 qes = new Question();
					while(rs.next()){
						qes = new Question();
						qes.setQuestion(rs.getString("question"));
						qes.setRonten(rs.getString("ronten"));
						qes.setAns1(rs.getString("ans1"));
						qes.setAns2(rs.getString("ans2"));
						qes.setAns3(rs.getString("ans3"));
						qes.setAns4(rs.getString("ans4"));
						qes.setSei(rs.getString("sei"));
						qes.setKaisetu(rs.getString("kaisetu"));
						qes.setSubclass(rs.getString("subclass_name"));
						question.add(qes);
					}
			}catch(Exception e){
				e.printStackTrace();
			}


			return question;
		}
		@Override
		public List<TestRecord> getAllTestRecordsByUser(Long userId) {

			List<TestRecord> list = new ArrayList<>();
			String sql = "SELECT a.id, a.time, COUNT(b.id), "
					   + "SUM(b.result), ROUND(SUM(b.result)/COUNT(b.id) *100) "
					   + "FROM test_records a JOIN kaitou_status b "
					   + "on (a.id = b.records_id) "
					   + "WHERE a.user_id = ? "
					   + "GROUP BY a.id, a.time "
					   + "ORDER BY a.time";

			try(Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);){
					stmt.setString(1, userId.toString());
					ResultSet rs = stmt.executeQuery();
					while(rs.next()){
						TestRecord testRecord = new TestRecord();
						testRecord.setId(rs.getLong(1));
						testRecord.setDate(rs.getTimestamp(2));
						testRecord.setTotalCount(rs.getInt(3));
						testRecord.setCorrectCount(rs.getInt(4));
						testRecord.setPercentage(rs.getInt(5));
						list.add(testRecord);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			return list;
		}

		@Override
		public ArrayList<Question> getHukusyu(String sql) {
			Question qes = new Question();
			ArrayList<Question> question = new ArrayList<Question>();

			try(Connection conn = dataSource.getConnection();
					//SQL文を用意
					PreparedStatement stmt = conn.prepareStatement(sql);){
					ResultSet rs = stmt.executeQuery();
					 qes = new Question();
					while(rs.next()){
						qes = new Question();
						qes.setId(rs.getInt("id"));
						qes.setQuestion(rs.getString("question"));
						qes.setRonten(rs.getString("ronten"));
						qes.setAns1(rs.getString("ans1"));
						qes.setAns2(rs.getString("ans2"));
						qes.setAns3(rs.getString("ans3"));
						qes.setAns4(rs.getString("ans4"));
						qes.setSei(rs.getString("sei"));
						qes.setKaisetu(rs.getString("kaisetu"));
						qes.setYearname(rs.getString("year_name"));
						question.add(qes);
					}
			}catch(Exception e){
				e.printStackTrace();
			}
			return question;

		}




}
