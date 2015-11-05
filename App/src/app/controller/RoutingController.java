package app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RoutingController
 */
@WebServlet({ "/RoutingController", "/routing" })
public class RoutingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dest = request.getParameter("dest");
		if(dest == null){
			return;
		}
		request.getRequestDispatcher("/WEB-INF/view/routingTemplate/" + dest + ".jsp").forward(request, response);
	}

}
