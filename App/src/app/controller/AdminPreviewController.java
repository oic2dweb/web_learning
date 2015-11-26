package app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.model.EntryQuestion;
import app.service.QuestionService;

/**
 * Servlet implementation class AdminPreviewController
 */
@WebServlet("/eb430180f1006fb41dd1e4eb4cdb508d/login/preview")
public class AdminPreviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private QuestionService questionService = new QuestionService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int yearid = (int) session.getAttribute("year_id");
		int no = (int)session.getAttribute("qnumber");
		EntryQuestion question = questionService.getQuestion(yearid, no);
		question.setQuestion(question.getQuestion().replaceAll("@@path@@", request.getContextPath()));
		question.setAns1(question.getAns1().replaceAll("@@path@@", request.getContextPath()));
		question.setAns2(question.getAns2().replaceAll("@@path@@", request.getContextPath()));
		question.setAns3(question.getAns3().replaceAll("@@path@@", request.getContextPath()));
		question.setAns4(question.getAns4().replaceAll("@@path@@", request.getContextPath()));
		question.setKaisetu(question.getKaisetu().replaceAll("@@path@@", request.getContextPath()));
		request.setAttribute("question", question);
		request.getRequestDispatcher("/WEB-INF/view/adminPreview.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
