package app.controller.rest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.service.MailService;
import app.service.UserService;

/**
 * Servlet implementation class ForgetAjax
 */
@WebServlet("/ForgetAjax")
public class ForgetAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MailService mail = new MailService();
	private UserService userDao = new UserService();
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String email = request.getParameter("email");


		boolean flg = userDao.emailCheck(email);
		String json ="{\"flg\":\"false\"}";
		if(flg){
			String text ="あなたのパスワードは～です";
			mail.send(email, text);
			json = "{\"flg\":\"true\"}";
		}
		out.print(json);

	}

}
