package app.controller.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import app.model.TestRecord;
import app.service.MyPageService;

@Path("/mypage")
public class MyPageRestController {

	private MyPageService myPageService = new MyPageService();

	@GET
	@Path("/testRecords/all")
	@Produces("application/json")
	public Response getAllTestRecords(@Context HttpServletRequest request){
		Long userid = (long)(int)(request.getSession().getAttribute("userid"));
		HttpSession session = request.getSession();
		String type = (String)session.getAttribute("type");
		List<TestRecord> records = myPageService.getAllTestRecords(userid,type);
		return Response.ok(records).build();
	}

}
