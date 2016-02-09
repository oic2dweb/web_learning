package app.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.model.ProjectY;
import app.model.User;
import app.persistence.HashMd5;
import app.persistence.UseMail;
import app.service.ClassService;
import app.service.TempRegisterService;

//pushのテスト
/**
 * Servlet implementation class RegisterController
 */
@WebServlet({ "/RegisterController", "/register" })
public class RegisterController extends HttpServlet {

	private ClassService classService = new ClassService();
	private TempRegisterService tempRegisterService = new TempRegisterService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//クラスのIDをkeyとしてクラス名を取得
		Map<Integer,String> classes = classService.getClasses();
		request.setAttribute("classes", classes);
		String nowclass = request.getParameter("class");
		if(nowclass!=null&&!nowclass.equals("")){
			request.setAttribute("nowclass", nowclass);
		}

		

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/registerForm.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String kana = request.getParameter("kana");
		String student_id = request.getParameter("student_id");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		int class_id = Integer.parseInt(request.getParameter("class"));
		int secret_id = Integer.parseInt(request.getParameter("question"));
		String secret_text = request.getParameter("answer");
		ProjectY py = new ProjectY();
		ProjectY py2 = new ProjectY();
		py.setStr(password);
		py2.setStr(secret_text);
		HashMd5 md5 = new HashMd5();
		String hash = md5.create(email);
		//Userインスタンスにフォームから受け取った値をセット

		User user = new User();
		user.setName(name);
		user.setKana(kana);
		user.setStudentId(student_id);
		user.setPassword(py.getStr());
		user.setEmail(email);
		user.setClassId(class_id);
		user.setSecret_id(secret_id);
		user.setSecret_text(py2.getStr());
		user.setUrl(hash);

		InetAddress addr = InetAddress.getLocalHost();
		//String url = "http://"+addr.getHostAddress()+":8080"+request.getContextPath()+"/registerCommit?id="+hash;
		String url = "http://localhost:8080"+request.getContextPath()+"/registerCommit?id="+hash;
		UseMail mail = new UseMail();
		mail.send(email, "下記のURLをクリックすることで登録が完了されます\n"+url);

		boolean flg = tempRegisterService.create(user);
		/*
		//UserServiceクラスにUserインスタンスを渡す
		boolean flg = userService.register(user);
		*/

		//登録できたかチェック
		if(!flg){
			request.getRequestDispatcher("/WEB-INF/view/500error.jsp").forward(request, response);
		}else{
			response.sendRedirect(request.getContextPath()+"/interimRegister");
		}
	}

}
