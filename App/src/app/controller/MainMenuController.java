package app.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.model.Question;
import app.persistence.QuestionDao;
import app.persistence.QuestionDaoImpl;

@WebServlet({ "/MainMenuController", "/login/mainmenu" })

public class MainMenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		session.removeAttribute("question");
		String nowyear = request.getParameter("year");
		if(nowyear!=null&&!nowyear.equals("")){
			ArrayList<Question> que2 = SqlCreate(nowyear);
			session.setAttribute("question", que2);
			request.setAttribute("nowyear", nowyear);
			
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/mainMenu.jsp");
		rd.forward(request, response);
	}
	//選択された年度の問題情報をセッションに格納
	public ArrayList<Question> SqlCreate(String year){
		String sql = "select f.question,f.ronten,f.ans1,f.ans2,f.ans3,f.ans4,f.sei,f.kaisetu,"
					+ "s.subclass_name from question_fe f join question_subclass" +
						" s on f.subclass_id = s.subclass_id where year_id = " + year;

		QuestionDao quedao = new QuestionDaoImpl();
		ArrayList<Question> qes = quedao.getNendobetu(sql);
		return qes;

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String[] subid = request.getParameterValues("subid");
		StringBuffer sql = new StringBuffer();
		sql.append("select * from question_fe where subclass_id in(");
		sql.append(subid[0]);
		for(int i=1;i<subid.length;i++){
			sql.append(","+subid[i]);
		}
		sql.append(")");
		QuestionDao quedao = new QuestionDaoImpl();
		ArrayList<Question> qes = quedao.getQustion(sql.toString());

		HttpSession session = request.getSession();

		//セッションにページ番号をpagenumberという名前で保存
		session.setAttribute("pagenumber",0);

		//セッションに問題情報をquestionという名前で保存
		session.setAttribute("question", qes);
		response.sendRedirect(request.getContextPath()+"/login/bunmondai");
	}
}