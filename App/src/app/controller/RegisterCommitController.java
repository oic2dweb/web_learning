package app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.model.User;
import app.service.TempRegisterService;
import app.service.UserService;

/**
 * Servlet implementation class RegisterCommitController
 */
@WebServlet("/registerCommit")
public class RegisterCommitController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TempRegisterService tempRegister = new TempRegisterService();
	private UserService userService = new UserService();


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String status="この新規登録情報は無効です";
		String id = request.getParameter("id");
		User user = tempRegister.getUser(id);
		if(user!=null){

			userService.register(user);
			tempRegister.deleteUser(user.getEmail());
			status = "新規登録が完了しました";
		}
		request.setAttribute("status",status);
		request.getRequestDispatcher("/WEB-INF/view/registerCommit.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
