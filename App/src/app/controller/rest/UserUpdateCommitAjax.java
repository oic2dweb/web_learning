package app.controller.rest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.model.UserTemp;
import app.service.UserService;
import app.service.UserTempService;

/**
 * Servlet implementation class UserUpdateCommitAjax
 */
@WebServlet("/UserUpdateCommitAjax")
public class UserUpdateCommitAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();

		UserTemp usertempmodel = new UserTemp();
		String url = request.getParameter("url");

		UserTempService usertemp = new UserTempService();
		UserService user = new UserService();

		usertempmodel = usertemp.getUserTemp(url);

		user.update(usertempmodel);
		usertemp.delete(usertempmodel.getAttribute(), usertempmodel.getUser_id());
	}

}
