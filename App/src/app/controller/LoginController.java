package app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.model.ProjectY;
import app.service.UserService;


@WebServlet({ "/LoginController","/login" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserService();


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String student_id = request.getParameter("student_id");
		String password = request.getParameter("password");
		ProjectY py = new ProjectY();
		py.setStr(password);

		//UserServiceクラスにstudent_id,passwordを渡す
		boolean flg = userService.loginCheck(student_id,py.getStr());

		//ログインできたかチェック
		if(flg){
			int id = userService.getId(student_id);
			String name = userService.getName(id);
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			session.setAttribute("userid", id);
			response.sendRedirect("login/selectcontent");
		}else{
			request.setAttribute("error", "<font color=\"red\">※学籍番号　or　パスワードに誤りがございます。</font>");
			request.getRequestDispatcher("/WEB-INF/view/welcome.jsp").forward(request, response);

		}
	}
}
