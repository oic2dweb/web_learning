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
		String year = request.getParameter("years");
		String sql = "select * from question_fe where year_id = " + year;
		QuestionService questionService = new QuestionService();
		ArrayList<Question> qes = questionService.getQuestion(sql);

		HttpSession session = request.getSession();

		//セッションにページ番号をpagenumberという名前で保存
		session.setAttribute("pagenumber",0);

		//セッションに問題情報をquestionという名前で保存
		session.setAttribute("question", qes);
		response.sendRedirect(request.getContextPath()+"/login/mondai");


	}


}
