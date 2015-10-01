package app.controller.rest;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import app.service.UserService;

import com.google.gson.Gson;

//ユーザー登録用のAJAX処理のコントローラー
@Path("/user")
public class UserRestController {

private UserService userService = new UserService();
	
	//即時入力のメールやユーザーIDがすでにDBに入るかどうかのチェック処理
	@SuppressWarnings("unchecked")
	@POST
	@Path("/unique")
	@Consumes("application/json")
	public Response checkUniqueness(String data){
		
		//届いたJSON文字列をJAVAのマップに変換
		Gson gson = new Gson();
		Map<String, String> map = new HashMap<String, String>();
		map = gson.fromJson(data, map.getClass());
		
		//もし同じデータがあったら、ユニークではなく、falseを返す
		//同じデータがなかったら、ユニークで、trueを返す
		boolean result = userService.checkUniqueness(map.get("attribute"), map.get("value"));
		
		//クライアントサイドにメッセージ表示用のキーを送信
		if(result){
			return Response.ok("REGISTER_OK").build();
		}else{
			return Response.ok("REGISTER_NOTUNIQUE").build();
		}
	}
}
