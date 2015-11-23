package app.controller;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.model.Year;
import app.persistence.QuestionDao;
import app.persistence.QuestionDaoImpl;
import app.service.YearService;

/**
 * Servlet implementation class AdminMainMenuController
 */
@WebServlet({ "/AdminMainMenuController","/eb430180f1006fb41dd1e4eb4cdb508d/login/mainmenu" })
public class AdminMainMenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public YearService yearService = new YearService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String gengo = request.getParameter("gengo");
		String nensu = request.getParameter("nensu");
		String jiki = request.getParameter("jiki");
		String sonotajiki = request.getParameter("sonotajiki");

		//個別に入力した年度情報を連結
		StringBuilder buf = new StringBuilder();
		buf.append(gengo);
		buf.append(nensu);
		buf.append("年");
		if(jiki.equals("その他")){
			buf.append(sonotajiki);
		}else{
			buf.append(jiki);
		}
		String year_name = buf.toString();

		//既に登録されている年度でないかチェック
		boolean unique = yearService.checkUniqueness(year_name);
		if(unique == false){
			//既に登録されていた場合メインメニューに戻る
			request.setAttribute("error", "※既に登録されている年度です");
			request.getRequestDispatcher("/WEB-INF/view/adminMainMenu.jsp").forward(request, response);
		}else{
			//登録されていなかった場合登録の処理
			Year year = new Year();
			year.setYear_name(year_name);
			year.setFlg(0);

			boolean flg = yearService.register(year);

			if(!flg){
				//登録できなかった時はエラーページへ
				request.getRequestDispatcher("/WEB-INF/view/500error.jsp").forward(request, response);
			}else{
				//セッションにyear_idとyear_nameを格納し登録ページへ移動
				int year_id = yearService.getId(year_name);
				HttpSession session = request.getSession();
				session.setAttribute("year_id",year_id);
				session.setAttribute("year_name",year_name);
				session.setAttribute("qnumber", 1);	//問題番号の初期化
				
				//画像フォルダの作成
				File newfile = new File("c:\\wls\\"+year_id);
				if(newfile.mkdir()){
					System.out.println("ディレクトリの作成に成功しました");
				}
				response.sendRedirect(request.getContextPath() + "/eb430180f1006fb41dd1e4eb4cdb508d/login/entry");
			}
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();

		String nowyear = request.getParameter("year");
		if(nowyear!=null&&!nowyear.equals("")){
			request.setAttribute("nowyear", nowyear);
		}

		//公開フラグのない年度情報を取得
		Map<Integer,String> noflgyear = yearService.getYear(0);
		session.setAttribute("noflgyear", noflgyear);

		//年度idをkeyとして公開フラグのない年度の問題数を取得
		Map<Integer,Integer> quantity = new LinkedHashMap<Integer,Integer>(){
			{
				put(0,0);
			}
		};
		QuestionDao quedao = new QuestionDaoImpl();
		for(Map.Entry<Integer,String> entry : noflgyear.entrySet()){
			quantity.put(entry.getKey(), quedao.getQuantity(entry.getKey()));
		}
		//問題数をセッションに格納
		session.setAttribute("quantity", quantity);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/adminMainMenu.jsp");
		rd.forward(request, response);
	}

}