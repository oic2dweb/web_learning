package app.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.model.Question;
import app.service.QuestionService;


/**
 * Servlet implementation class MogiController
 */
@WebServlet("/login/mogi")
public class MogiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String year = request.getParameter("years");
		String type = (String)session.getAttribute("type");
		String sql = "select q.id,q.question,q.ronten,q.ans1,q.ans2,q.ans3,q.ans4,q.sei,q.kaisetu from question_fe q join year y on q.year_id = y.year_id where y.year_id = " + year+ " and y.type_id = "+type+" order by no";
		System.out.println(sql);
		QuestionService questionService = new QuestionService();
		ArrayList<Question> qes = questionService.getQuestion(sql);

		

		//セッションにページ番号をpagenumberという名前で保存
		session.setAttribute("pagenumber",0);

		//セッションに問題情報をquestionという名前で保存
		session.setAttribute("question", qes);
		response.sendRedirect(request.getContextPath()+"/login/mondai");


	}


}
