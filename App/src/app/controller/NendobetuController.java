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
import app.persistence.NendobetuDao;
import app.persistence.NendobetuDaoImpl;
import app.persistence.YearDao;
import app.persistence.YearDaoImpl;


@WebServlet("/login/nendobetu")
public class NendobetuController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//nowyearを１で初期化
	String nowyear= "1";

	//最初にページロードされたときの処理
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		YearSet(request, response);

		ArrayList<Question> que1 = SqlCreate(nowyear);
			//セッションに問題情報をquestionという名前で保存
			session.setAttribute("question", que1);
			request.setAttribute("nowyear", nowyear);
			request.getRequestDispatcher("/WEB-INF/view/nendobetu.jsp").forward(request, response);


	}

	//年度選択プルダウンメニューが変更されたときの処理
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		YearSet(request, response);

		session.removeAttribute("question");
		nowyear = request.getParameter("year");
		ArrayList<Question> que2 = SqlCreate(nowyear);
		session.setAttribute("question", que2);
		request.setAttribute("nowyear", nowyear);
		request.getRequestDispatcher("/WEB-INF/view/nendobetu.jsp").forward(request, response);

	}

	//選択された年度の問題情報をセッションに格納
	public ArrayList<Question> SqlCreate(String year){
		String sql = "select f.question,f.ronten,f.ans1,f.ans2,f.ans3,f.ans4,f.sei,f.kaisetu,"
				+ "s.subclass_name from question_fe f join question_subclass" +
					" s on f.subclass_id = s.subclass_id where year_id = " + year;

		NendobetuDao quedao = new NendobetuDaoImpl();
		ArrayList<Question> qes = quedao.getNendobetu(sql);

		return qes;

	}
	//年度プルダウンメニューの設定
	public void YearSet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		YearDao yeardao = new YearDaoImpl();
		Map<Integer,String> year = yeardao.getYear();
		request.setAttribute("year", year);
	}

}
