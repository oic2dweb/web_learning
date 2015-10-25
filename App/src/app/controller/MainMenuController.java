package app.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.model.Question;
import app.persistence.QuestionDao;
import app.persistence.QuestionDaoImpl;

@WebServlet({ "/MainMenuController", "/login/mainmenu" })

public class MainMenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/mainMenu.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String[] subid = request.getParameterValues("subid");
		StringBuffer sql = new StringBuffer();
		sql.append("select * from question_fe where subclass_id in(");
		sql.append(subid[0]);
		for(int i=1;i<subid.length;i++){
			sql.append(","+subid[i]);
		}
		sql.append(")");
		QuestionDao quedao = new QuestionDaoImpl();
		ArrayList<Question> qes = quedao.getQustion(sql.toString());

		HttpSession session = request.getSession();

		//セッションにページ番号をpagenumberという名前で保存
		session.setAttribute("pagenumber",0);

		//セッションに問題情報をquestionという名前で保存
		session.setAttribute("question", qes);
		response.sendRedirect(request.getContextPath()+"/login/mondai");
	}
}