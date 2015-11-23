package app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.model.ProjectY;
import app.model.User;
import app.model.UserTemp;
import app.service.MailService;
import app.service.UserService;
import app.service.UserTempService;

/**
 * Servlet implementation class UserTempController
 */
@WebServlet("/login/usertemp")
public class UserTempController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserTempController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		UserTemp user = new UserTemp();
		String attribute=request.getParameter("attribute");

		int id=(int)request.getSession().getAttribute("userid");
		user.setId(id);
		user.setAttribute(attribute);
		user.setValue(request.getParameter(attribute));

		if(user.getAttribute().equals("password")){
			ProjectY py = new ProjectY();
			py.setStr(user.getValue());
			user.setValue(py.getStr());
		}

		UserTempService usertemp = new UserTempService();

		int recordid = usertemp.create(user);
		usertemp.setUrl(recordid);
		String parameter = usertemp.getUrl(recordid);
		String url = "http://localhost:8080"+ request.getContextPath() + "/userupdatecommit?id="+parameter;
		UserService userservice = new UserService();
		User userinfo= userservice.getUser((long)id);

		Thread th =new Thread(new Runnable() {

			@Override
			public void run() {
				MailService mail = new MailService();
				mail.send(userinfo.getEmail(), "下記のURLをクリックすることで変更が完了されます\n"+url);

			}
		});
		th.start();


		response.sendRedirect(request.getContextPath()+"/login/userupdatesendmail");
	}

}
