package app.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import app.listener.BootListener;
import app.model.EntryQuestion;
import app.service.QuestionMainClassService;
import app.service.QuestionService;
import app.service.QuestionSubClassService;
import app.service.YearService;



/**
 * Servlet implementation class AdminQuestionEntryController
 */
@WebServlet("/eb430180f1006fb41dd1e4eb4cdb508d/login/entry")
@MultipartConfig(location="c:\\wls")
public class AdminQuestionEntryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QuestionService questionService = new QuestionService();
	private QuestionMainClassService qmcService = new QuestionMainClassService();
	private QuestionSubClassService qscService = new QuestionSubClassService();
	private YearService yearService = new YearService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		int yearid = (int) session.getAttribute("year_id");

		if(request.getParameter("no")!=null){
			session.setAttribute("qnumber",Integer.parseInt(request.getParameter("no")));
		}
		int no = (int)session.getAttribute("qnumber");
		int type_id = Integer.parseInt((String)session.getAttribute("type"));

		//すでに登録されてる問題がある場合の取り出し
		EntryQuestion adminQuestion = questionService.getQuestion(yearid, no,type_id);
		if(adminQuestion!=null){
			adminQuestion.setMainid(qscService.getMainClassId(adminQuestion.getSubid()));
			adminQuestion.setCatid(qmcService.getCatId(adminQuestion.getMainid()));
			//改行タブを改行コードに置換
			adminQuestion.setQuestion(adminQuestion.getQuestion().replaceAll("<br>", "\r\n"));
			adminQuestion.setAns1(adminQuestion.getAns1().replaceAll("<br>", "\r\n"));
			adminQuestion.setAns2(adminQuestion.getAns2().replaceAll("<br>", "\r\n"));
			adminQuestion.setAns3(adminQuestion.getAns3().replaceAll("<br>", "\r\n"));
			adminQuestion.setAns4(adminQuestion.getAns4().replaceAll("<br>", "\r\n"));
			adminQuestion.setKaisetu(adminQuestion.getKaisetu().replaceAll("<br>", "\r\n"));
			request.setAttribute("adminQuestion", adminQuestion);
		}

		request.getRequestDispatcher("/WEB-INF/view/adminQuestionEntry.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		int count=0;

		HttpSession session = request.getSession();
		int yearid = (int)session.getAttribute("year_id");
		String ronten = request.getParameter("ronten");
		int subid = Integer.parseInt(request.getParameter("subname"));

		//改行コードを改行タブに置換
		String temp = request.getParameter("question");
		temp = temp.replaceAll("\r\n", "<br>");
		temp = temp.replaceAll("\n", "<br>");
		StringBuffer question = new StringBuffer(temp);

		String ans1 = request.getParameter("ans1");
		ans1 = ans1.replaceAll("\r\n", "<br>");
		ans1 = ans1.replaceAll("\n", "<br>");

		String ans2 = request.getParameter("ans2");
		ans2 = ans2.replaceAll("\r\n", "<br>");
		ans2 = ans2.replaceAll("\n", "<br>");

		String ans3 = request.getParameter("ans3");
		ans3 = ans3.replaceAll("\r\n", "<br>");
		ans3 = ans3.replaceAll("\n", "<br>");

		String ans4 = request.getParameter("ans4");
		ans4 = ans4.replaceAll("\r\n", "<br>");
		ans4 = ans4.replaceAll("\n", "<br>");

		String sei = request.getParameter("sei");

		temp = request.getParameter("kaisetu");
		temp = temp.replaceAll("\r\n", "<br>");
		temp = temp.replaceAll("\n", "<br>");
		StringBuffer kaisetu = new StringBuffer(temp);
		int no = Integer.parseInt(request.getParameter("qnumber"));

		//問題文章の画像アップロード処理
		int qimgcnt=Integer.parseInt(request.getParameter("qimgcnt"));
		for(int i=1;i<=qimgcnt;i++){
			Part part = request.getPart("qimg"+i);
			String filename = upload(part,yearid,count++);
			String filetag = "<img src='@@path@@/ImgServlet?path="+yearid+"/"+filename+"'>";
			question.replace(question.indexOf("@@img"+i+"@@"), question.indexOf("@@img"+i+"@@")+8, filetag);
		}

		//回答の画像アップロード処理
		for(int i=1;i<=4;i++){
			if(request.getParameter("haimg"+i).equals("1")){
				Part part = request.getPart("aimg"+i);
				String filename=upload(part,yearid,count++);
				String filetag = "<img src='@@path@@/ImgServlet?path="+yearid+"/"+filename+"'>";
				switch(i){
				case 1:
					ans1 = ans1.replaceAll("@@img@@", filetag);
					break;
				case 2:
					ans2 = ans2.replaceAll("@@img@@", filetag);
					break;
				case 3:
					ans3 = ans3.replaceAll("@@img@@", filetag);
					break;
				case 4:
					ans4 = ans4.replaceAll("@@img@@", filetag);
					break;

				}
			}
		}

		//解説の画像アップロード処理
		if(request.getParameter("hkimg").equals("1")){
			Part part = request.getPart("kimg");
			String filename=upload(part,yearid,count++);
			String filetag = "<img src='@@path@@/ImgServlet?path="+yearid+"/"+filename+"'>";
			kaisetu.replace(kaisetu.indexOf("@@img@@"), kaisetu.indexOf("@@img@@")+7, filetag);
			//kaisetu.append(filetag);
		}

		EntryQuestion eq = new EntryQuestion();
		eq.setYearid(yearid);
		eq.setRonten(ronten);
		eq.setSubid(subid);
		eq.setQuestion(question.toString());
		eq.setAns1(ans1);
		eq.setAns2(ans2);
		eq.setAns3(ans3);
		eq.setAns4(ans4);
		eq.setSei(sei);
		eq.setKaisetu(kaisetu.toString());
		eq.setNo(no);

		//すでにDBに存在する問題番号かどうか？
		if(questionService.checkQuestionNo(yearid, no)){
			questionService.updateQuestion(eq);
		}else{
			questionService.insertQuestion(eq);
		}

		//押されたボタンを判別
		String status = request.getParameter("submitname");
		switch(status){
		case "back":session.setAttribute("qnumber", --no);break;
		case "next":session.setAttribute("qnumber", ++no);break;
		case "list":response.sendRedirect(request.getContextPath()+"/eb430180f1006fb41dd1e4eb4cdb508d/login/list");break;
		case "onetimesave":yearService.publicYear(yearid,0);
			BootListener listener = new BootListener();
			listener.contextInitialized(new ServletContextEvent(request.getServletContext()));
			session.setAttribute("year",request.getServletContext().getAttribute("year"+session.getAttribute("type")));
			response.sendRedirect(request.getContextPath()+"/eb430180f1006fb41dd1e4eb4cdb508d/login/mainmenu");break;
		case "posting":yearService.publicYear(yearid,1);
			BootListener listener2 = new BootListener();
			listener2.contextInitialized(new ServletContextEvent(request.getServletContext()));
			session.setAttribute("year",request.getServletContext().getAttribute("year"+session.getAttribute("type")));
			response.sendRedirect(request.getContextPath()+"/eb430180f1006fb41dd1e4eb4cdb508d/login/mainmenu");break;
		case "preview":response.sendRedirect(request.getContextPath()+"/eb430180f1006fb41dd1e4eb4cdb508d/login/preview");break;
		}

		doGet(request, response);
	}

	//画像をアップロードするメソッド
	public String upload(Part part,int yearid,int count){

		String disposition = part.getHeader("Content-Disposition");
		String fname = "img"+yearid+count+

				new Date().getTime();
		String ext="";

		String[] headers = disposition.split(";");
		for(String header:headers){
			String str = header.trim();
			if(str.startsWith("filename=")){
				str = str.substring(10,str.length()-1);
				String[] paths = str.split("\\\\");
				ext = paths[paths.length-1];
			}
		}
		int point = ext.lastIndexOf(".");
		if(point!=-1){
			fname = fname+ext.substring(point);
		}
		try {
			part.write("\\"+yearid+"\\"+fname);
		} catch (IOException e) {
		}
		return fname;
	}

}
