package app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.service.YearService;

/**
 * Servlet implementation class AdminQuestionEditController
 */
@WebServlet({ "/AdminQuestionEditController","/eb430180f1006fb41dd1e4eb4cdb508d/login/edit" })
public class AdminQuestionEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public YearService yearService = new YearService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String year_name = request.getParameter("year_name");
		HttpSession session = request.getSession();
		session.setAttribute("year_name", year_name);
		session.setAttribute("year_id", yearService.getId(year_name));

		response.sendRedirect(request.getContextPath() + "/eb430180f1006fb41dd1e4eb4cdb508d/login/entry");
	}
}
