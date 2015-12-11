package app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.service.AdminService;

@WebServlet({ "/AdminController","/eb430180f1006fb41dd1e4eb4cdb508d/admin" })

public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminService adminService = new AdminService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("adminid");
		String password = request.getParameter("password");

		//AdminServiceクラスにid,passwordを渡す
		boolean flg = adminService.loginCheck(id,password);

		//ログインできたかチェック
		if(flg){
			//変数名の重複を避けるため、ローカル変数をadminidと定義
			String adminid = adminService.getId(id);
			HttpSession session = request.getSession();
			session.setAttribute("adminid", adminid);
			response.sendRedirect("login/select");
		}else{
			request.setAttribute("error", "<font color=\"red\">※ID　or　パスワードに誤りがございます。</font>");
			request.getRequestDispatcher("/WEB-INF/view/admin.jsp").forward(request, response);
		}
	}
	//テスト
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("adminid")!=null){
			session.invalidate();
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/admin.jsp");
		rd.forward(request, response);
	}

}
