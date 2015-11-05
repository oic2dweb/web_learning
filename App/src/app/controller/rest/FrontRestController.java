package app.controller.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

//サーバサイドのAJAX処理設定用クラス
//test.kaku
@ApplicationPath("/rest")
public class FrontRestController extends Application {

	private Set<Object> singletons = new HashSet<Object>();
	
	public FrontRestController() {
		singletons.add(new UserRestController());
		singletons.add(new MyPageRestController());
	}

	@Override
	public Set<Object> getSingletons() {
		// TODO Auto-generated method stub
		return singletons;
	}

}
