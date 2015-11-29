package app.controller.rest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import app.model.MainClass;
import app.model.SubClass;

/**
 * Servlet implementation class AdminQuestionEntryAjax
 */
@WebServlet("/AdminQuestionEntryAjax")
public class AdminQuestionEntryAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext app = request.getServletContext();
		@SuppressWarnings("unchecked")
		ArrayList<MainClass> mainClass = (ArrayList<MainClass>)app.getAttribute("mainClass");
		@SuppressWarnings("unchecked")
		ArrayList<SubClass> subClass = (ArrayList<SubClass>)app.getAttribute("subClass");
		Gson gson = new Gson();
		@SuppressWarnings("rawtypes")
		Map<String,ArrayList> map = new HashMap<String,ArrayList>();
		map.put("mainClass", mainClass);
		map.put("subClass",subClass);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//Map内のオブジェクトをjsonに変換して出力
		out.print(gson.toJson(map));
	}

}
