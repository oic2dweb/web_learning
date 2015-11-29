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
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import app.service.UserService;

/**
 * Servlet implementation class UserUpdateAjax
 */
@WebServlet("/UserUpdateAjax")
public class UserUpdateAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");

		PrintWriter out = response.getWriter();
		UserService userService = new UserService();
		Gson gson = new Gson();
		String json = "";

		String pass = request.getParameter("value");
		//セッションストレージからidを取得
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("userid");

		//パスワードが間違っていれば、falseを返す
		//パスワードが正しければ、trueを返す
		boolean result = userService.checkPassword(id, pass);
		Map<String,Boolean> map = new HashMap<String, Boolean>();
		map.put("result",result);
		json = gson.toJson(map);

		//クライアント側に結果を返す
		out.print(json);

	}

}
