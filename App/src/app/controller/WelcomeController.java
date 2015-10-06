package app.controller;

import java.io.IOException;

@WebServlet({ "/WelcomeController", "/welcome" })
public class WelcomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

//コメントkatai
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/welcome.jsp");
		rd.forward(request, response);
	}
}
