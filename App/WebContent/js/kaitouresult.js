$(document).ready(function(){
	resulttable();

	$(".kaisetsu").click(function(){
		var kaisetsu = "true";
		window.location = "${pageContext.request.contextPath}/login/mondai";
	});

	function resulttable(){
		//正解一覧を配列seiに取ってくる処理
		var sei = new Array();
		var request = $.ajax({
            type:"POST",
            url:CONTEXT_PATH+"KaitouResultAjax",
            datatype:"json",
            async: false,
            success: function(data){
            	for(var i=0;i<sessionStorage.length;i++){
            		sei[i] = data[i].ans
            	}
            }
        });

		$("#kaitouresult").append("<tr>"+"<td>問</td>"+ "<td>回答</td>"+"<td>正誤</td>"+"<td>復習チェック※</td>"+"</tr>");
		for (var i=0; i < sessionStorage.length; i++) {
			var key = sessionStorage.key(i);
			var answer = JSON.parse(sessionStorage.getItem(key));
			var mondaiid = answer.mondaiid;
			var pagenumber = answer.pagenum - 1;
			var seigo = "×";
			if(answer.uans == sei[i]){
				seigo = "○";
			}
			$("#kaitouresult").append("<tr>"+"<td class='kaisetsu'><a href='"+ CONTEXT_PATH + "login/fukushu?pagenumber=" + pagenumber + "'>" + key + "</a></td>"+ "<td>"+answer.uans+"</td>"+"<td>"+seigo+"</td>"+"<td><input type='checkbox' name='revision"+i+"'>復習</td>"+"</tr>");
			//回答結果を保存するためにサーバに送信するデータの記述
			$("#kaitouresult").append("<input type='hidden' name='seigo' value='"+seigo+"'>");
		}
	}
});