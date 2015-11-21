package app.controller.rest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.model.Question;
import app.service.KaitouStatusService;
import app.service.QuestionService;

import com.google.gson.Gson;


@WebServlet("/HukusyuAjax")
public class HukusyuAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json="";
		//セッションの取得
		HttpSession session = request.getSession();

		//セッションからユーザー名を取得
		int userid = (int) session.getAttribute("userid");
		String sql = "select distinct f.id,f.question,f.ronten,f.ans1,f.ans2,f.ans3,f.ans4,f.sei,f.kaisetu,y.year_name"
					+ " from question_fe f join year y on f.year_id = y.year_id join kaitou_status k on f.id = k.question_id"
					+" join test_records t on k.records_id = t.id where k.revision = 1 and t.user_id = " + userid
					+" order by f.id";

		//ＤＢから問題情報を取得
		QuestionService questionService = new QuestionService();
		ArrayList<Question> qes = questionService.getHukusyu(sql);
		//セッションに問題情報を保存
		session.setAttribute("question", qes);
		HashMap<String,ArrayList> map = new HashMap<String,ArrayList>();

		map.put("question", qes);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		json = gson.toJson(map);
		out.print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String questionid = request.getParameter("id");

		//セッションからユーザー名を取得
		HttpSession session = request.getSession();
		int userid = (int) session.getAttribute("userid");

		//DBの処理
		KaitouStatusService ks = new KaitouStatusService();
		ks.change(questionid,userid);
		doGet(request, response);

	}

}
