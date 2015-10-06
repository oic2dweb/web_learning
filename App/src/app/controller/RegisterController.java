package app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.model.User;
import app.service.UserService;
//pushのテスト
/**
 * Servlet implementation class RegisterController
 */
@WebServlet({ "/RegisterController", "/register" })
public class RegisterController extends HttpServlet {

	private UserService userService = new UserService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/registerForm.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String kana = request.getParameter("kana");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		//Userインスタンスにフォームから受け取った値をセット

		User user = new User();
		user.setName(name);
		user.setKana(kana);
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setAuthority("user");


		//UserServiceクラスにUserインスタンスを渡す
		boolean flg = userService.register(user);

		//登録できたかチェック
		if(!flg){
			request.setAttribute("messagesKey", "DATABASE_CONNECTION_FAILED");
			request.getRequestDispatcher("/WEB-INF/view/registerForm.jsp").forward(request, response);
		}else{
			response.sendRedirect("welcome");
		}
	}

}
