package app.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.model.EntryQuestion;
import app.service.QuestionService;

/**
 * Servlet implementation class AdminQuestionListController
 */
@WebServlet("/eb430180f1006fb41dd1e4eb4cdb508d/login/list")
public class AdminQuestionListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QuestionService  questionService = new QuestionService();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int yearid = (int)session.getAttribute("year_id");
		ArrayList<EntryQuestion> qlist = questionService.getList(yearid);
		//session.setAttribute("qlist", qlist);
		request.setAttribute("qlist", qlist);
		request.getRequestDispatcher("/WEB-INF/view/adminQuestionList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
