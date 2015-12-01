package app.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import app.model.EntryQuestion;
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
		public List<TestRecord> getAllTestRecordsByUser(Long userId,String type_id) {

			List<TestRecord> list = new ArrayList<>();
			String sql = "SELECT a.id, a.time, COUNT(b.id), "
					   + "SUM(b.result), ROUND(SUM(b.result)/COUNT(b.id) *100) "
					   + "FROM test_records a JOIN kaitou_status b "
					   + "on (a.id = b.records_id) join questiones c on (b.question_id = c.id) join year d on (c.year_id = d.year_id) "
					   + "WHERE a.user_id = ? and d.type_id = ? "
					   + "GROUP BY a.id, a.time "
					   + "ORDER BY a.time";

			try(Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);){
					stmt.setString(1, userId.toString());
					stmt.setString(2, type_id);
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

		@Override
		public void insertQuestion(EntryQuestion eq) {
			try(Connection conn = dataSource.getConnection();
					//SQL文を用意
					PreparedStatement stmt = conn.prepareStatement("insert into questiones(year_id,ronten,subclass_id,question,ans1,ans2,ans3,ans4,sei,kaisetu,no) values(?,?,?,?,?,?,?,?,?,?,?)");){
					stmt.setInt(1, eq.getYearid());
					stmt.setString(2, eq.getRonten());
					stmt.setInt(3, eq.getSubid());
					stmt.setString(4,eq.getQuestion());
					stmt.setString(5, eq.getAns1());
					stmt.setString(6, eq.getAns2());
					stmt.setString(7, eq.getAns3());
					stmt.setString(8, eq.getAns4());
					stmt.setString(9, eq.getSei());
					stmt.setString(10,eq.getKaisetu());
					stmt.setInt(11, eq.getNo());
					stmt.executeUpdate();

			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		}

		@Override
		public boolean checkQuestionNo(int yearid,int no){
			boolean flg = false;

			try(Connection conn = dataSource.getConnection();
					PreparedStatement stmt = conn.prepareStatement("select * from questiones where year_id = ? and no = ?");){
				stmt.setInt(1, yearid);
				stmt.setInt(2, no);

				ResultSet result = stmt.executeQuery();
				if(result.next()){
					flg = true;
				}


			}catch(Exception e){

			}

			return flg;

		}

		@Override
		public void updateQuestion(EntryQuestion eq) {
			try(Connection conn = dataSource.getConnection();
					//SQL文を用意
					PreparedStatement stmt = conn.prepareStatement("update questiones set ronten=?,subclass_id=?,question=?,ans1=?,ans2=?,ans3=?,ans4=?,sei=?,kaisetu=? where year_id = ? and no = ?");){

					stmt.setString(1, eq.getRonten());
					stmt.setInt(2, eq.getSubid());
					stmt.setString(3,eq.getQuestion());
					stmt.setString(4, eq.getAns1());
					stmt.setString(5, eq.getAns2());
					stmt.setString(6, eq.getAns3());
					stmt.setString(7, eq.getAns4());
					stmt.setString(8, eq.getSei());
					stmt.setString(9,eq.getKaisetu());
					stmt.setInt(10, eq.getYearid());
					stmt.setInt(11, eq.getNo());
					stmt.executeUpdate();

			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		}

		@Override
		public EntryQuestion getQuestion(int yearid, int no,int type_id) {
			EntryQuestion question = null;

			try(Connection conn = dataSource.getConnection();
					PreparedStatement stmt = conn.prepareStatement("select * from questiones q join year y on q.year_id = y.year_id where y.year_id = ? and q.no = ? and y.type_id = ?");){
				stmt.setInt(1, yearid);
				stmt.setInt(2, no);
				stmt.setInt(3, type_id);

				ResultSet result = stmt.executeQuery();
				if(result.next()){
					question = new EntryQuestion();
					question.setQuestion(result.getString("question"));
					question.setAns1(result.getString("ans1"));
					question.setAns2(result.getString("ans2"));
					question.setAns3(result.getString("ans3"));
					question.setAns4(result.getString("ans4"));
					question.setNo(result.getInt("no"));
					question.setSei(result.getString("sei"));
					question.setKaisetu(result.getString("kaisetu"));
					question.setSubid(result.getInt("subclass_id"));
					question.setRonten(result.getString("ronten"));
				}
			}catch(Exception e){
				
			}

			return question;
		}

		@Override
		public ArrayList<EntryQuestion> getList(int yearid) {
			ArrayList<EntryQuestion> list = new ArrayList<EntryQuestion>();
			EntryQuestion entry;
			try(Connection conn = dataSource.getConnection();
					PreparedStatement stmt = conn.prepareStatement("select no,left(question,40) as question from questiones where year_id = ? order by no");){
				stmt.setInt(1, yearid);

				ResultSet result = stmt.executeQuery();
				while(result.next()){
					entry = new EntryQuestion();
					entry.setNo(result.getInt("no"));
					entry.setQuestion(result.getString("question").replaceAll("<","&lt"));
					list.add(entry);
				}
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			return list;

		}

		//指定した年度の問題数を取得
		@Override
		public int getQuantity(int year_id){
			int quantity = 0;
			try(Connection conn = dataSource.getConnection();
					PreparedStatement stmt = conn.prepareStatement("select count(*) from questiones where year_id = ?");){
					//SQL文に値をセット
					stmt.setInt(1, year_id);
					ResultSet result = stmt.executeQuery();
					result.next();
					quantity = result.getInt("count(*)");
				}catch(Exception e){
					e.printStackTrace();
				}
			return quantity;
		}

		@Override
		public boolean delete(int year_id){
			//DBとの接続
			try(Connection conn = dataSource.getConnection();
				//SQL文を用意
				PreparedStatement stmt = conn.prepareStatement("delete from questiones where year_id=?");){
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
		public int getMaxNo(int year_id) {

			int no=1;
			try(Connection conn = dataSource.getConnection();
					PreparedStatement stmt = conn.prepareStatement("select max(no) as no from questiones where year_id = ?");){
				stmt.setInt(1, year_id);
				ResultSet result = stmt.executeQuery();
				if(result.next()){
					if(result.getInt("no")!=0){
						no = result.getInt("no");
					}

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return no;

		}

}
