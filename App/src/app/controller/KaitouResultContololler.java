package app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.model.KaitouStatus;
import app.service.KaitouStatusService;


@WebServlet("/login/kaitouresult")
public class KaitouResultContololler extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/kaitouResult.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		KaitouStatus status= new KaitouStatus();
		KaitouStatusService st = new KaitouStatusService();
		/*製作途中
		for(){
			int qustion_id = request.getParameter();
			status.setQuestion_id(question_id);
			status.setResult(result);
			status.setReview(review);
			status.setRevision(revision);
			status.setTime(time);
			status.setUesr_id(uesr_id);

			st.create(status);

		}
		*/



	}

}
