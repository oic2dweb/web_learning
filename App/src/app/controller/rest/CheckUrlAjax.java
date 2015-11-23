package app.controller.rest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.service.UserTempService;

import com.google.gson.Gson;

/**
 * Servlet implementation class CheckUrlAjax
 */
@WebServlet("/CheckUrlAjax")
public class CheckUrlAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");

		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		String json = "";
		String url = request.getParameter("url");

		UserTempService usertemp = new UserTempService();

		boolean result = usertemp.checkUrl(url);
		Map<String,Boolean> map = new HashMap<String, Boolean>();
		map.put("result",result);
		json = gson.toJson(map);

		//クライアント側に結果を返す
		out.print(json);
	}

}
