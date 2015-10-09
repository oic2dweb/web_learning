package app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.service.UserService;


@WebServlet({ "/LoginController","/login" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		//UserServiceクラスにemail,passwordを渡す
		boolean flg = userService.loginCheck(email,password);

		//ログインできたかチェック
		if(flg){
			response.sendRedirect("mainmenu");
		}else{
			//request.setAttribute("messagesKey", "DATABASE_CONNECTION_FAILED");
			response.sendRedirect("welcome");


		}
	}
}
