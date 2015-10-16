package app.controller.rest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.model.Question;

import com.google.gson.Gson;

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
		Question qes = (Question) session.getAttribute("question");
		int i = (int)session.getAttribute("pagenumber");


		if(str.equals("back")){
			session.setAttribute("pagenumber", --i);
		}else if(str.equals("next")){
			session.setAttribute("pagenumber", ++i);
		}



		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();

		HashMap<String,String> map = new HashMap<String,String>();
		map.put("pagenumber", String.valueOf(i + 1));
		map.put("question",qes.getQuestion(i));
		map.put("ans1",qes.getAns1(i));
		map.put("ans2",qes.getAns2(i));
		map.put("ans3",qes.getAns3(i));
		map.put("ans4",qes.getAns4(i));
		map.put("kaisetu",qes.getKaisetu(i));

		Gson gson = new Gson();
		 json = gson.toJson(map);
		//json ="{\"question\":" + qes.getQuestion(0) + "\"}";
		//System.out.println(json);
		out.print(json);
	}

}
