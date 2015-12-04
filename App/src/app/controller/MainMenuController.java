package app.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.model.Question;
import app.persistence.QuestionDao;
import app.persistence.QuestionDaoImpl;
import app.service.QuestionTypeService;

@WebServlet({ "/MainMenuController", "/login/mainmenu" })

public class MainMenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QuestionTypeService questionTypeService = new QuestionTypeService();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		if(request.getParameter("type")!=null){
			session.setAttribute("type", request.getParameter("type"));
			String type_name = questionTypeService.getName(Integer.parseInt(request.getParameter("type")));
			session.setAttribute("type_name", type_name);
			ServletContext app = request.getServletContext();
			session.setAttribute("year",app.getAttribute("year"+request.getParameter("type")));
			session.setAttribute("count", app.getAttribute("count"+request.getParameter("type")));
		}
		//session.removeAttribute("question");
		String nowyear = request.getParameter("year");
		if(nowyear!=null&&!nowyear.equals("")){
			String type = (String)session.getAttribute("type");
			ArrayList<Question> que2 = SqlCreate(nowyear,type);
			session.setAttribute("question", que2);
			request.setAttribute("nowyear", nowyear);

		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/mainMenu.jsp");
		rd.forward(request, response);
	}
	//選択された年度の問題情報をセッションに格納
	public ArrayList<Question> SqlCreate(String year,String type){
		String sql = "select f.question,f.ronten,f.ans1,f.ans2,f.ans3,f.ans4,f.sei,f.kaisetu,"
					+ "s.subclass_name from questiones f join question_subclass" +
						" s on f.subclass_id = s.subclass_id join year y on f.year_id = y.year_id where y.year_id = " + year+" and y.type_id = "+type+" order by f.no";

		QuestionDao quedao = new QuestionDaoImpl();
		ArrayList<Question> qes = quedao.getNendobetu(sql);
		return qes;

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String type = (String)session.getAttribute("type");
		String[] subid = request.getParameterValues("subid");
		StringBuffer sql = new StringBuffer();
		sql.append("select q.id,q.question,q.ronten,q.ans1,q.ans2,q.ans3,q.ans4,q.sei,q.kaisetu from questiones q join year y on q.year_id = y.year_id where q.subclass_id in(");
		sql.append(subid[0]);
		for(int i=1;i<subid.length;i++){
			sql.append(","+subid[i]);
		}
		sql.append(") and y.flg = 1 and y.type_id = "+type);

		QuestionDao quedao = new QuestionDaoImpl();
		ArrayList<Question> qes = quedao.getQustion(sql.toString());


		//セッションにページ番号をpagenumberという名前で保存
		session.setAttribute("pagenumber",0);

		//セッションに問題情報をquestionという名前で保存
		session.setAttribute("question", qes);
		response.sendRedirect(request.getContextPath()+"/login/bunmondai");
	}
}