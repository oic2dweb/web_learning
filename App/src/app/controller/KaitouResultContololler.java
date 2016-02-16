package app.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.model.KaitouStatus;
import app.model.Question;
import app.persistence.KaitouStatusDao;
import app.persistence.KaitouStatusDaoImpl;
import app.persistence.TestRecordsDao;
import app.persistence.TestRecordsDaoImpl;


@WebServlet("/login/kaitouresult")
public class KaitouResultContololler extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/kaitouResult.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		int userid = (int) session.getAttribute("userid");//ユーザidの取得
		int score = Integer.parseInt(request.getParameter("score"));//得点を取得
		TestRecordsDao trDao = new TestRecordsDaoImpl();
		int record_id = trDao.getId(userid,score);	//TestRecordsテーブルにuserIdを保存して、オートインクリメントの値を取得

		@SuppressWarnings("unchecked")
		ArrayList<Question> questionList = (ArrayList<Question>)session.getAttribute("question");
		Question question;

		int result;
		int revision;
		String[] seigo = request.getParameterValues("seigo");	//フォームから正誤の取得

		KaitouStatus ks= new KaitouStatus();	//Daoに渡すクラスのインスタンス化
		ks.setRecord_id(record_id);

		//kaitoustatusテーブルに保存
		KaitouStatusDao kaitouStatusDao = new KaitouStatusDaoImpl();
		for(int i=0;i<questionList.size();i++){
			 question = questionList.get(i);
			 ks.setQuestion_id(question.getId());

			 //正誤の変換
			 if(seigo[i].equals("○")){
				 result = 1;
			 }else{
				 result = 0;
			 }
			 ks.setResult(result);

			 //復習チェックの確認
			 if(request.getParameter("revision"+(i+1))!=null){
				 revision = 1;
			 }else{
				 revision = 0;
			 }
			 ks.setRevision(revision);

			 kaitouStatusDao.create(ks);
		}

		response.sendRedirect(request.getContextPath()+"/login/mainmenu");
	}

}
