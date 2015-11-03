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

import com.google.gson.Gson;

import app.model.Question;

/**
 * Servlet implementation class MondaiAjax
 */
@WebServlet("/MondaiAjax")
public class MondaiAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;





	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String str = request.getParameter("status");
		String json="";



		//セッションの取得
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<Question> qes = (ArrayList<Question>) session.getAttribute("question");

		//セッションから何問目かを取得
		int i = (int)session.getAttribute("pagenumber");

		//前の問題へをクリック時
		if(str.equals("back")){
			session.setAttribute("pagenumber", --i);
		//次の問題へをクリック時
		}else if(str.equals("next")){
			session.setAttribute("pagenumber", ++i);
		}


		//JSONの文字コードセット
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Question que = qes.get(i);
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("pagenumber", String.valueOf(i + 1));
		map.put("id", String.valueOf(que.getId()));
		map.put("question",que.getQuestion());
		map.put("ans1",que.getAns1());
		map.put("ans2",que.getAns2());
		map.put("ans3",que.getAns3());
		map.put("ans4",que.getAns4());
		map.put("kaisetu",que.getKaisetu());
		map.put("sei", que.getSei());

		Gson gson = new Gson();
		 json = gson.toJson(map);
		//json ="{\"question\":" + qes.getQuestion(0) + "\"}";
		//System.out.println(json);
		out.print(json);
	}

}
