package app.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.persistence.YearDao;
import app.persistence.YearDaoImpl;

/**
 * Servlet implementation class NendobetuController
 */
@WebServlet("/login/nendobetu")
public class NendobetuController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		YearDao yeardao = new YearDaoImpl();
		Map<Integer,String> year = yeardao.getYear();
		request.setAttribute("year", year);

		request.getRequestDispatcher("/WEB-INF/view/nendobetu.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
