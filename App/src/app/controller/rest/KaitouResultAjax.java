package app.controller.rest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.model.Question;

/**
 * Servlet implementation class Ajax
 */
@WebServlet("/KaitouResultAjax")
public class KaitouResultAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
        ArrayList<Question> question = (ArrayList<Question>)session.getAttribute("question");

		//javascriptに送信するjsonを作成
		StringBuffer json = new StringBuffer();
		json.append("[");
		for(int i=0;i<question.size();i++){
			Question que = question.get(i);
			json.append("{\"ans\":\""+que.getSei()+"\"},");
		}

		//不要な最期の,を削除
		int index = json.lastIndexOf(",");
		json.deleteCharAt(index);

		json.append("]");
		//System.out.println(json.toString());
		response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(json);
	}

}
