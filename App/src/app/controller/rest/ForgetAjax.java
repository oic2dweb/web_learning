package app.controller.rest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.model.ProjectY;
import app.model.User;
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
		User user = new User();
		ProjectY py = new ProjectY();


		boolean flg = userDao.emailCheck(email);
		String json ="{\"flg\":\"true\"}";
		if(flg){
			py.setRandPass();
			String pass = py.getRandPass();
			String text ="仮パスワード発行\n\n仮パスワードは"+ pass +"です。\n\nこのパスワードはあくまでも仮のものです。\n初回ログイン時に必ず本パスワードへの変更をお願い致します。";
			
			py.setStr(pass);
			user.setEmail(email);
			user.setPassword(py.getStr());
			userDao.setTempPassword(user);
			boolean sendflg = mail.send(email, text);
			json = "{\"flg\":\""+sendflg+"\"}";
		}
		out.print(json);

	}

}
