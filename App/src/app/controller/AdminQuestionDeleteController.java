package app.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.persistence.DeleteDir;
import app.service.QuestionService;
import app.service.YearService;

/**
 * Servlet implementation class AdminQuestionDeleteController
 */
@WebServlet({"/AdminQuestionEntryController","/eb430180f1006fb41dd1e4eb4cdb508d/login/delete"})
public class AdminQuestionDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public QuestionService questionService = new QuestionService();
	public YearService yearService = new YearService();
	private DeleteDir dir = new DeleteDir();


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int year_id = Integer.parseInt(request.getParameter("year_id"));

		//指定された年度の問題を削除
		boolean flg1 = questionService.delete(year_id);
		if(!flg1){
			//削除できなかった時はエラーページへ
			request.getRequestDispatcher("/WEB-INF/view/500error.jsp").forward(request, response);
		}else{
			//指定された年度を削除
			boolean flg2 = yearService.delete(year_id);
			//対応したフォルダと画像も削除
			dir.delete(new File("c:\\wls\\"+year_id));
			if(!flg2){
				//削除できなかった時はエラーページへ
				request.getRequestDispatcher("/WEB-INF/view/500error.jsp").forward(request, response);
			}else{
				response.sendRedirect(request.getContextPath() + "/eb430180f1006fb41dd1e4eb4cdb508d/login/mainmenu");
			}
		}

	}

}