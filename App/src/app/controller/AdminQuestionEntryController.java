package app.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

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
	int count=0;
	int yearid;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		yearid = (int) session.getAttribute("year_id");

		if(request.getParameter("no")!=null){
			session.setAttribute("qnumber",Integer.parseInt(request.getParameter("no")));
		}
		int no = (int)session.getAttribute("qnumber");

		EntryQuestion adminQuestion = questionService.getQuestion(yearid, no);
		if(adminQuestion!=null){
			adminQuestion.setMainid(qscService.getMainClassId(adminQuestion.getSubid()));
			adminQuestion.setCatid(qmcService.getCatId(adminQuestion.getMainid()));
			request.setAttribute("adminQuestion", adminQuestion);
		}

		request.getRequestDispatcher("/WEB-INF/view/adminQuestionEntry.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		QuestionService questionService = new QuestionService();

		HttpSession session = request.getSession();
		yearid = (int)session.getAttribute("year_id");
		String ronten = request.getParameter("ronten");
		int subid = Integer.parseInt(request.getParameter("subname"));
		StringBuffer question = new StringBuffer(request.getParameter("question"));
		StringBuffer ans1 = new StringBuffer(request.getParameter("ans1"));
		StringBuffer ans2 = new StringBuffer(request.getParameter("ans2"));
		StringBuffer ans3 = new StringBuffer(request.getParameter("ans3"));
		StringBuffer ans4 = new StringBuffer(request.getParameter("ans4"));
		String sei = request.getParameter("sei");
		StringBuffer kaisetu = new StringBuffer(request.getParameter("kaisetu"));
		int no = Integer.parseInt(request.getParameter("qnumber"));

		int qimgcnt=Integer.parseInt(request.getParameter("qimgcnt"));
		for(int i=1;i<=qimgcnt;i++){
			Part part = request.getPart("qimg"+i);
			String filename = upload(part);
			String filetag = "<img src='@@path@@/ImgServlet?path="+yearid+"/"+filename+"' class='img-responsive'>";
			question.append(filetag);
		}

		for(int i=1;i<=4;i++){
			if(request.getParameter("haimg"+i).equals("1")){
				Part part = request.getPart("aimg"+i);
				String filename=upload(part);
				String filetag = "<img src='@@path@@/ImgServlet?path="+yearid+"/"+filename+"' class='img-responsive'>";
				switch(i){
				case 1:
					ans1.append(filetag);
					break;
				case 2:
					ans2.append(filetag);
					break;
				case 3:
					ans3.append(filetag);
					break;
				case 4:
					ans4.append(filetag);
					break;

				}
			}
		}

		if(request.getParameter("hkimg").equals("1")){
			Part part = request.getPart("kimg");
			String filename=upload(part);
			String filetag = "<img src='@@path@@/ImgServlet?path="+yearid+"/"+filename+"' class='img-responsive'>";
			kaisetu.append(filetag);
		}

		EntryQuestion eq = new EntryQuestion();
		eq.setYearid(yearid);
		eq.setRonten(ronten);
		eq.setSubid(subid);
		eq.setQuestion(question.toString());
		eq.setAns1(ans1.toString());
		eq.setAns2(ans2.toString());
		eq.setAns3(ans3.toString());
		eq.setAns4(ans4.toString());
		eq.setSei(sei);
		eq.setKaisetu(kaisetu.toString());
		eq.setNo(no);

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
		case "onetimesave":response.sendRedirect(request.getContextPath()+"/eb430180f1006fb41dd1e4eb4cdb508d/login/menu");break;
		case "posting":yearService.publicYear(yearid);
			response.sendRedirect(request.getContextPath()+"/eb430180f1006fb41dd1e4eb4cdb508d/login/menu");break;
		case "preview":response.sendRedirect(request.getContextPath()+"/eb430180f1006fb41dd1e4eb4cdb508d/login/preview");break;
		}


		//request.getRequestDispatcher("/WEB-INF/view2/AdminQuestionEntry.jsp").forward(request,response);
		doGet(request, response);
	}

	public String upload(Part part){

		String disposition = part.getHeader("Content-Disposition");
		String fname = "img"+ new Date().getTime()+(count++);
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
