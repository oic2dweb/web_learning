package app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.model.Question;
import app.persistence.QuestionDao;
import app.persistence.QuestionDaoImpl;
import app.persistence.YearDao;
import app.persistence.YearDaoImpl;

/**
 * Servlet implementation class MogiController
 */
@WebServlet("/login/mogi")
public class MogiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		YearDao yeardao = new YearDaoImpl();
		Map<Integer,String> year = yeardao.getYear();
		request.setAttribute("year", year);

		request.getRequestDispatcher("/WEB-INF/view/mogi.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String year = request.getParameter("yeardata");
		String sql = "select * from question_fe where year_id = " + year;
		System.out.println(sql);
		QuestionDao quedao = new QuestionDaoImpl();
		ArrayList<Question> qes = quedao.getQustion(sql);

		HttpSession session = request.getSession();

		//セッションにページ番号をpagenumberという名前で保存
		session.setAttribute("pagenumber",0);

		//セッションに問題情報をquestionという名前で保存
		session.setAttribute("question", qes);
		response.sendRedirect(request.getContextPath()+"/login/mondai");


	}


}
