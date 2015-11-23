package app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.service.QuestionService;
import app.service.YearService;

/**
 * Servlet implementation class AdminQuestionSaveController
 */
@WebServlet({ "/AdminQuestionSaveController","/eb430180f1006fb41dd1e4eb4cdb508d/login/save"})
public class AdminQuestionSaveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QuestionService questionService = new QuestionService();
	private YearService yearService = new YearService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int year_id = Integer.parseInt(request.getParameter("year_id"));
		String year_name = yearService.getName(year_id);
		HttpSession session = request.getSession();
		session.setAttribute("year_id",year_id);
		session.setAttribute("year_name",year_name);
		int no = questionService.getMaxNo(year_id);
		
		session.setAttribute("qnumber", no);
		response.sendRedirect(request.getContextPath() + "/eb430180f1006fb41dd1e4eb4cdb508d/login/entry");
	}

}
